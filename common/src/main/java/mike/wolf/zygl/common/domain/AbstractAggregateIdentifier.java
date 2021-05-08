package mike.wolf.zygl.common.domain;

import lombok.EqualsAndHashCode;
import org.axonframework.common.IdentifierFactory;
import org.springframework.util.Assert;

import java.io.Serializable;
import java.util.Objects;
/*
一个AggregateIdentifier必须：
   实现equal和hashCode方法，因为它会被拿来与其他标识对比
   实现toString方法，其结果也应该是全局唯一的
   实现Serializable接口以表明可序列化
 */
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

