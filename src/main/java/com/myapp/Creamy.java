package com.myapp;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

import org.springframework.beans.factory.annotation.Qualifier;

@Target({ElementType.CONSTRUCTOR,ElementType.FIELD,ElementType.METHOD,ElementType.TYPE})
@Qualifier
public @interface Creamy {

}
