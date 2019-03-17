package com.eric.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/15/2019 11:03 AM
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UserCase {
    public int id();
    public String description() default "No description";
}
