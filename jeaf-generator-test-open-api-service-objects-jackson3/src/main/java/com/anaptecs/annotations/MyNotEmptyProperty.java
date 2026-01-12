package com.anaptecs.annotations;

import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;

import java.lang.annotation.Target;

@Target({ METHOD, PARAMETER })
public @interface MyNotEmptyProperty {

}
