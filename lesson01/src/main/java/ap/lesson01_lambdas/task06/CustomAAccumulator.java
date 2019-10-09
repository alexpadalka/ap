package ap.lesson01_lambdas.task06;

import java.util.HashSet;
import java.util.Set;

public class CustomAAccumulator {

  public int getCountIsB() {
    return setD.size();
  }

  public int getCountNonB() {
    return setI.size();
  }

  public int getAverageI() {
    if (setI.size() == 0) {
      return 0;
    }
    return Math.floorDiv(setI.stream().mapToInt(A::getI).sum(), setI.size());
  }

  public int getMaxI() {
    return setI.stream().mapToInt(A::getI).max().orElse(0);
  }

  public int getMinI() {
    return setI.stream().mapToInt(A::getI).min().orElse(0);
  }

  public double getAverageD() {
    if (setD.size() == 0) {
      return 0;
    }
    return setD.stream().mapToDouble(A::getD).sum() / setD.size();
  }

  public double getMaxD() {
    return setD.stream().mapToDouble(A::getD).max().orElse(Double.valueOf("0.0"));
  }

  public double getMinD() {
    return setD.stream().mapToDouble(A::getD).min().orElse(Double.valueOf("0.0"));
  }

  private Set<A> setI;
  private Set<A> setD;

  private int sumI = 0;
  private double sumD = 0;

  public CustomAAccumulator() {
    this.setI = new HashSet<>();
    this.setD = new HashSet<>();
  }

  public void addA(A a) {
    if (a.isB()) {
      setD.add(a);
      sumD += a.getD();
    }
    else {
      setI.add(a);
      sumI += a.getI();
    }
  }

  public void merge(CustomAAccumulator accumulator) {
    setI.addAll(accumulator.setI);
    setD.addAll(accumulator.setD);
  }

  public double sumI() {
    return sumI;
  }

  public double sumD() {
    return sumD;
  }
}
