package mike.wolf.zygl.common.domain;

import lombok.EqualsAndHashCode;
import org.axonframework.common.IdentifierFactory;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Objects;

//@EqualsAndHashCode
public abstract class AbstractAggregateIdentifier implements AggregateIdentifier, Serializable {
  private final String identifier;

  public AbstractAggregateIdentifier() {

    this(IdentifierFactory.getInstance().generateIdentifier());
  }

  public AbstractAggregateIdentifier(String identifier) {
    this.checkIdentifier(identifier);
    this.identifier = identifier;
  }

  private void checkIdentifier(String identifier) {
    Assert.hasLength(identifier, "标识不能为空或null");
  }

  @Override
  public String getIdentifier() {
    return this.identifier;
  }

  @Override
  public String toString() {
    return "identifier=" + getIdentifier();
  }

  @Override
  public int hashCode() {
    return Objects.hash(identifier);
  }

}

