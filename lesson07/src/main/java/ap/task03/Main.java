package ap.task03;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import ap.task03.model.MessageBus;
import ap.task03.model.MessageSupplier;
import ap.task03.model.SpecificMessageConsumer;
import ap.task03.thread.MessageConsumerThread;
import ap.task03.thread.MessageSupplierThread;

public class Main {

  public static void main(String[] args) throws InterruptedException {
    MessageBus bus = new MessageBus();

    List<Thread> suppliers = getSuppliers(bus, 10);
    List<Thread> consumers = getConsumers(bus, 6);

    suppliers.stream().forEach(Thread::start);
    consumers.stream().forEach(Thread::start);

    suppliers.stream().forEach((e) -> {
      try {
        e.join();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    });

    consumers.stream().forEach((e) -> {
      try {
        e.join();
      } catch (InterruptedException ex) {
        ex.printStackTrace();
      }
    });

    System.out.println("End");
  }

  private static List<Thread> getSuppliers(MessageBus bus, int size) {
    return IntStream.range(0, size)
        .mapToObj(i -> new Thread(new MessageSupplierThread(new MessageSupplier(), bus)))
        .collect(Collectors.toList());
  }

  private static List<Thread> getConsumers(MessageBus bus, int size) {
    return IntStream.range(0, size)
        .mapToObj(
            i ->
                new Thread(
                    new MessageConsumerThread(
                        new SpecificMessageConsumer(
                            MessageBus.getTopic(i % MessageBus.topics.size())),
                        bus)))
        .collect(Collectors.toList());
  }
}
