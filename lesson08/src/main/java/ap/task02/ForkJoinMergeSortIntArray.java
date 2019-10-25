package ap.task02;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ForkJoinMergeSortIntArray extends RecursiveTask<List<Integer>> {

  private List<Integer> numbers;

  public ForkJoinMergeSortIntArray(List<Integer> numbers) {
    this.numbers = numbers;
  }

  private List<Integer> mergeSortList(List<Integer> numbers, int size) {
    if (size > 1) {
      int mid = size / 2;
      List<Integer> left = numbers.subList(0, mid);
      List<Integer> right = numbers.subList(mid, size);

      left = sort(left);
      right = sort(right);

      return mergeLists(left, right, mid, size - mid);
    }
    return Collections.singletonList(numbers.get(0));
  }

  private List<Integer> mergeLists(List<Integer> left, List<Integer> right, int n, int m) {
    List<Integer> result = new ArrayList<>(left.size() + right.size());

    int i = 0;
    int j = 0;

    while (i < n && j < m) {
      if (left.get(i) < right.get(j)) {
        result.add(left.get(i));
        i++;
      } else {
        result.add(right.get(j));
        j++;
      }
    }
    while (i < n) {
      result.add(left.get(i));
      i++;
    }
    while (j < m) {
      result.add(right.get(j));
      j++;
    }

    return result;
  }

  @Override
  protected List<Integer> compute() {
    return mergeSortList(this.numbers, this.numbers.size());
  }

  public static List<Integer> sort(List<Integer> numbers) {
    if (numbers.size() < 1) {
      return Collections.emptyList();
    }
    ForkJoinMergeSortIntArray task = new ForkJoinMergeSortIntArray(numbers);
//    System.out.println(numbers);
    return (new ForkJoinPool()).invoke(task);
  }
}
