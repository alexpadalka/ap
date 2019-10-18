package ap.task03.model;

public class Message {

  private String subject;
  private String payload;

  public Message() {
    this("", "");
  }

  public Message(String subject, String payload) {
    this.subject = subject;
    this.payload = payload;
  }

  public String getSubject() {
    return subject;
  }

  public void setSubject(String subject) {
    this.subject = subject;
  }

  public boolean isSubject(String sub) {
    if (sub == null || sub.length() == 0) {
      return false;
    }

    return sub.equalsIgnoreCase(subject);
  }

  public String getPayload() {
    return payload;
  }

  public void setPayload(String payload) {
    this.payload = payload;
  }

  public static Message build(String subject, String payload) {
    Message message = new Message();
    message.setSubject(subject);
    message.setPayload(payload);
    return message;
  }

  @Override
  public String toString() {
    return "{'" + getSubject() + "' : '" + getPayload() + "'}";
  }
}
