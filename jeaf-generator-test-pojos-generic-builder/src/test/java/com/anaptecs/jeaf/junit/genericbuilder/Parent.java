package com.anaptecs.jeaf.junit.genericbuilder;

public class Parent extends ParentBase {

  public Parent( ParentBuilder<?, ?> pBuilder ) {
    super(pBuilder);
  }

  public static ParentBuilder<?, ?> builder( ) {
    return new ParentBuilderImpl();
  }

  public void doSomethingMagic( ) {
  }
}
