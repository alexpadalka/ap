package ap.task03.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MessageBus {

  public static final List<String> topics =
      Arrays.asList("topic1", "topic2", "topic3", "topic4", "topic5", "topic6");
//  public static final Integer BUS_SIZE = 1_000_000;
  public static final Integer BUS_SIZE = 1_000;

  private List<Message> bus;

  public MessageBus() {
    this(new ArrayList<>(BUS_SIZE));
  }

  public MessageBus(List<Message> bus) {
    this.bus = bus;
  }

  public void push(Message message) {
    bus.add(message);
  }

  public boolean hasNext(String topic) {
    if (bus.isEmpty()) {
      return false;
    }

    if (topic == null || topic.length() == 0) {
      return false;
    }

    return !bus.stream()
        .filter(e -> topic.equalsIgnoreCase(e.getSubject()))
        .collect(Collectors.toList())
        .isEmpty();
  }

  public Message next(String topic) {
    if (hasNext(topic)) {
      Message message =
          bus.stream().filter(e -> topic.equalsIgnoreCase(e.getSubject())).findFirst().orElse(null);
      if (message != null) {
        bus.remove(message);
      }
      return message;
    }

    return null;
  }

  public static String getRandomTopic() {
    return topics.get((new Random()).nextInt(topics.size()));
  }

  public static String getTopic(int index) {
    return topics.get(index);
  }
}
