package ap.task02;

import java.util.Collection;
import java.util.stream.IntStream;

public class IntegerSummarizeThread implements Executive {

  private Collection<Integer> collection;

  public IntegerSummarizeThread(Collection<Integer> collection) {
    this.collection = collection;
  }

  @Override
  public void execute() {
    IntStream.range(0, 1_00)
        .forEach(
            i -> {
              synchronized (collection) {
                System.out.println("Sum " + collection.stream().mapToInt(Integer::intValue).sum());
              }
            });
  }
}
