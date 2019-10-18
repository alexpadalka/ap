package ap.task03.thread;

import java.util.Random;
import java.util.stream.IntStream;

import ap.task03.model.MessageBus;
import ap.task03.model.MessageSupplier;

public class MessageSupplierThread implements Runnable {

  private MessageSupplier supplier;
  private MessageBus bus;

  public MessageSupplierThread(MessageSupplier supplier, MessageBus bus) {
    this.supplier = supplier;
    this.bus = bus;
  }

  @Override
  public void run() {
    IntStream.range(0, MessageBus.BUS_SIZE)
        .forEach(
            i -> {
              synchronized (bus) {
                String subject = MessageBus.getRandomTopic();
                String payload = subject + "_" + i;
                supplier.setSubject(subject);
                supplier.setPayload(payload);

                bus.push(supplier.get());
              }

              try {
                Thread.sleep((new Random()).nextInt(100));
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
  }
}
