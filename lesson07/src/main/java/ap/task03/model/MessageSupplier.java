package ap.task03.model;

import java.util.function.Supplier;

public class MessageSupplier implements Supplier<Message> {

  private String subject;
  private String payload;

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  @Override
  public Message get() {
    return Message.build(subject, payload);
  }
}
