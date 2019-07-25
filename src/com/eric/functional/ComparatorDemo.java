package com.eric.functional;

import java.util.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 07/16/2019 4:24 PM
 */
public class ComparatorDemo {

    public static void main(String[] args) {
        List<Date> dates = new ArrayList<>();
        Calendar calendar = Calendar.getInstance();
        dates.add(calendar.getTime());
        calendar.set(1990,10,7);
        dates.add(calendar.getTime());
        calendar.set(1992,7,14);
        dates.add(calendar.getTime());
        dates.add(null);
        System.out.println(dates);

        dates.sort(Comparator.comparing(date -> date, Comparator.nullsFirst(Comparator.reverseOrder())));
        System.out.println(dates);
    }
}
