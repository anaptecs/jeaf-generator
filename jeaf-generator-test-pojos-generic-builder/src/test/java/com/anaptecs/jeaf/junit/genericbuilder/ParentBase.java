package com.anaptecs.jeaf.junit.genericbuilder;

import com.anaptecs.jeaf.junit.genericbuilder.ParentBase.ParentBuilderImpl;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;

@JsonDeserialize(builder = ParentBuilderImpl.class)
public abstract class ParentBase {
  String propertyA;

  protected ParentBase( ParentBuilder<?, ?> pBuilder ) {
    this.propertyA = pBuilder.propertyA;
  }

  @JsonPOJOBuilder(withPrefix = "set")
  public static abstract class ParentBuilder<T extends Parent, B extends ParentBuilder<T, B>> {

    private String propertyA;

    public B setPropertyA(String x) {
      this.propertyA = x;
      return self();
    }

    protected abstract B self( );

    public abstract T build( );
  }

  static final class ParentBuilderImpl extends ParentBuilder<Parent, ParentBuilderImpl> {
    ParentBuilderImpl( ) {
    }

    @Override
    protected ParentBuilderImpl self( ) {
      return this;
    }

    @Override
    public Parent build( ) {
      return new Parent(this);
    }
  }

  public String getPropertyA( ) {
    return propertyA;
  }

}
