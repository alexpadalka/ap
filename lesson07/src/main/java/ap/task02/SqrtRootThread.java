package ap.task02;

import java.util.Collection;
import java.util.stream.IntStream;

public class SqrtRootThread implements Executive {

  private Collection<Integer> collection;

  public SqrtRootThread(Collection<Integer> collection) {
    this.collection = collection;
  }

  @Override
  public void execute() {
    IntStream.range(0, 1_00)
        .forEach(
            i -> {
              synchronized (collection) {
                for (Integer value : collection) {
                  System.out.println(
                      "SQRT Root from " + value + " is " + Math.sqrt(value));
                }
              }
            });
  }
}
