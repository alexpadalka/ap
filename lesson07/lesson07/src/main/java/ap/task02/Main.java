package ap.task02;

import java.util.ArrayList;
import java.util.List;

public class Main {

  public static void main(String[] args) {
    List<Integer> list = new ArrayList<>();

    IntegerProducerThread integerProducerThread = new IntegerProducerThread(list);
    IntegerSummarizeThread integerSummarizeThread = new IntegerSummarizeThread(list);
    SqrtRootThread sqrtRootThread = new SqrtRootThread(list);

    Thread producerThread = new Thread(integerProducerThread);
    Thread summarizeThread = new Thread(integerSummarizeThread);
    Thread rootThread = new Thread(sqrtRootThread);

    producerThread.start();
    summarizeThread.start();
    rootThread.start();

    try {
      producerThread.join();
      summarizeThread.join();
      rootThread.join();
    } catch (InterruptedException e) {
      e.printStackTrace();
    }
  }
}
