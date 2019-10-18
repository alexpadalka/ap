package ap.task03.model;

import java.util.function.Consumer;

public class MessageConsumer implements Consumer<Message> {

  @Override
  public void accept(Message message) {
    System.out.println(message);
  }
}
