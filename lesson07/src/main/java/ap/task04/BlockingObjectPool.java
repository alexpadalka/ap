package ap.task04;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class BlockingObjectPool {

  private int size;
  private List<Object> pool;

  private final ReadWriteLock lock;
  private final Lock readLock;
  private final Lock writeLock;


  public BlockingObjectPool(int size) {
    this.size = size;
    pool = new ArrayList<>(size);

    lock = new ReentrantReadWriteLock();
    readLock = lock.readLock();
    writeLock = lock.writeLock();
  }

  public Object get() {
    readLock.lock();
    Object result = null;
    try {
      if (!isEmpty()) {
        int index = pool.size() - 1;
        result = pool.get(index);
        pool.remove(index);
      }
    } finally{
      if (!isFull()) {
        writeLock.unlock();
      }
      if (!isEmpty()) {
        readLock.unlock();
      }
    }
    return result;
  }

  public void take(Object object) {
    writeLock.lock();
    try {
      if (!isFull()) {
        pool.add(object);
      }
    } finally{
      if (!isFull()) {
        writeLock.unlock();
      }
      if (!isEmpty()) {
        readLock.unlock();
      }
    }
  }

  private boolean isEmpty() {
    return pool.isEmpty();
  }

  private boolean isFull() {
    return pool.size() >= size;
  }
}
