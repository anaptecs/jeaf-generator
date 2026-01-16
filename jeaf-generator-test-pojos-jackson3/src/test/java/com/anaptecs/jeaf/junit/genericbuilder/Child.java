package com.anaptecs.jeaf.junit.genericbuilder;

import com.anaptecs.jeaf.junit.genericbuilder.Child.ChildBuilderImpl;
import tools.jackson.databind.annotation.JsonDeserialize;
import tools.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ChildBuilderImpl.class)
public class Child extends Parent {
  int propertyB;

  protected Child( ChildBuilder<?, ?> b ) {
    super(b);
    this.propertyB = b.propertyB;
  }

  public static ChildBuilder<?, ?> builder( ) {
    return new ChildBuilderImpl();
  }

  @JsonPOJOBuilder(withPrefix = "set")
  public static abstract class ChildBuilder<T extends Child, B extends ChildBuilder<T, B>> extends ParentBuilder<T, B> {

    private int propertyB;

    public B setPropertyB(int y) {
      this.propertyB = y;
      return self();
    }

    @Override
    protected abstract B self( );

    @Override
    public abstract T build( );
  }

  static final class ChildBuilderImpl extends ChildBuilder<Child, ChildBuilderImpl> {

    private ChildBuilderImpl( ) {
    }

    @Override
    protected ChildBuilderImpl self( ) {
      return this;
    }

    @Override
    public Child build( ) {
      return new Child(this);
    }
  }

  public int getPropertyB( ) {
    return propertyB;
  }

}
