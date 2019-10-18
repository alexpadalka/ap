package ap.task03.thread;

import java.util.Random;
import java.util.stream.IntStream;

import ap.task03.model.Message;
import ap.task03.model.MessageBus;
import ap.task03.model.SpecificMessageConsumer;

public class MessageConsumerThread implements Runnable {

  private SpecificMessageConsumer consumer;
  private MessageBus bus;

  public MessageConsumerThread(SpecificMessageConsumer consumer, MessageBus bus) {
    this.consumer = consumer;
    this.bus = bus;
  }

  @Override
  public void run() {
    IntStream.range(0, MessageBus.BUS_SIZE)
        .forEach(
            i -> {
              synchronized (bus) {
                Message message = bus.next(consumer.getTopic());
                if (message != null) {
                  System.out.println(Thread.currentThread().getName());
                  consumer.accept(message);
                }
              }

              try {
                Thread.sleep((new Random()).nextInt(1000));
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
            });
  }
}
