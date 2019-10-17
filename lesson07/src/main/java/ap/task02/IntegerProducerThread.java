package ap.task02;

import java.util.Collection;
import java.util.Random;
import java.util.stream.IntStream;

public class IntegerProducerThread implements Executive {

  private Collection<Integer> collection;

  public IntegerProducerThread(Collection<Integer> collection) {
    this.collection = collection;
  }

  @Override
  public void execute() {
    Random rand = new Random();

    IntStream.range(0, 1_000_000)
        .forEach(
            i -> {
              synchronized (collection) {
                int nextInt = rand.nextInt();
                collection.add(nextInt);
//                System.out.println("Add " + nextInt);
              }
            });
  }
}
