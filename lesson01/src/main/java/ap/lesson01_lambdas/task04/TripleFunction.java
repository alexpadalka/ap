package ap.lesson01_lambdas.task04;

@FunctionalInterface
public interface TripleFunction<P, V, T, R> {
  R apply(P p, V v, T t);
}
