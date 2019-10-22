package ap.task02;

public interface Executive extends Runnable {

  @Override
  default void run() {
    execute();
  }

  void execute();
}
