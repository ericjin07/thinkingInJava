package com.eric.initializationAndClean;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/05/2018 10:52 PM
 */
public class EnumEx21 {

    public static void main(String[] args) {
        for (Currency currency: Currency.values()) {
            System.out.println(currency + " the index is " + currency.ordinal());
            description(currency);
        }
    }

    static void description(Currency currency){
        switch (currency){
            case COIN:
                System.out.println("this is coin for Every Country");
                break;
            case YONG:
                System.out.println("the Janpaniese");
                break;
            case ERURO:
            case PONDS:
                System.out.println("all for Europ");
                break;
            case YUAN:
            case DOLLOR:
                System.out.println("from china and USA");
        }
    }
}

enum Currency{
    YUAN, DOLLOR, PONDS, ERURO, YONG, COIN
        }
