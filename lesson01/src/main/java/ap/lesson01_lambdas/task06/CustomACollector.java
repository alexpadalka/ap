package ap.lesson01_lambdas.task06;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;

public class CustomACollector implements Collector<A, CustomAAccumulator, CustomACollector> {

  @Override
  public Supplier<CustomAAccumulator> supplier() {
    return CustomAAccumulator::new;
  }

  @Override
  public BiConsumer<CustomAAccumulator, A> accumulator() {
    return CustomAAccumulator::addA;
  }

  @Override
  public BinaryOperator<CustomAAccumulator> combiner() {
    return (left, right) -> {
      left.merge(right);
      return left;
    };
  }

  @Override
  public Function<CustomAAccumulator, CustomACollector> finisher() {
    return CustomACollector::build;
  }

  @Override
  public Set<Characteristics> characteristics() {
    return EnumSet.of(Characteristics.CONCURRENT);
  }

  private CustomAAccumulator accum;

  public static CustomACollector build(CustomAAccumulator accum) {
    CustomACollector collector = new CustomACollector();
    collector.accum = accum;
    return collector;
  }

  public CustomAAccumulator getAccumulator() {
    return accum;
  }
}
