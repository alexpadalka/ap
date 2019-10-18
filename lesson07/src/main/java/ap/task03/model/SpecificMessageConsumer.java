package ap.task03.model;

public class SpecificMessageConsumer extends MessageConsumer {

  private String topic;

  public SpecificMessageConsumer(String topic) {
    this.topic = topic;
  }


  public String getTopic() {
    return topic;
  }

  @Override
  public void accept(Message message) {
    if (topic == null || topic.length() == 0) {
      return;
    }

    if (topic.equalsIgnoreCase(message.getSubject())) {
      super.accept(message);
    }
  }
}
