package mike.wolf.zygl.common.domain;

public interface AggregateIdentifier<T> {
  String getIdentifier();
  boolean equals(Object obj);
  int hashCode();

}
