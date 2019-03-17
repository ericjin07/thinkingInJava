package com.eric.enumerated;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.EnumSet;
import static com.eric.enumerated.Course.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/14/2019 3:07 PM
 */
public enum Course {
    APPETIZER(Food.Appetizer.class),
    MAINCOURSE(Food.MainCourse.class),
    DESSERT(Food.Dessert.class),
    COFFEE(Food.Coffee.class);


    private Food[] foods;

    Course(Class<? extends Food> fs) {
        this.foods = fs.getEnumConstants();
    }

    public Food randFood(){
        return Enums.rand(foods);
    }

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException {
//        for (int i = 0; i < 5; i++) {
//            for (Course course : Course.values()){
//                Food food = course.randFood();
//                System.out.println(food);
//            }
//            System.out.println("---------");
//        }

        EnumSet<Course> set = EnumSet.noneOf(Course.class);
        System.out.println(set);

        Class clz = Class.forName("java.util.EnumSet");
        Field universe = clz.getDeclaredField("universe");
        universe.setAccessible(true);
        System.out.println( "=========" + Arrays.toString((Course[])universe.get(set)));

        set.add(COFFEE);
        set.addAll(EnumSet.allOf(Course.class));
        System.out.println(set);
    }
}
