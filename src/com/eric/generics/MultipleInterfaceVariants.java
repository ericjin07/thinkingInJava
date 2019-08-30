package com.eric.generics;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/25/2019 8:55 PM
 */
public class MultipleInterfaceVariants {
}

interface Payable<T> {}

class Employeer implements Payable<Employeer> {}

class Hourly extends Employeer implements Payable<Employeer>{}
