package com.eric.annotation.database;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/15/2019 3:18 PM
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SqlString {
    int value() default 0;
    String name() default "";
    Constriants constriants() default @Constriants;
}
