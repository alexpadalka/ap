package ap.lesson01_lambdas.task02;

import java.util.Comparator;

public interface PersonComparable {
  Comparator<Person> getComparator();
}
