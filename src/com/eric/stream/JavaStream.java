package com.eric.stream;

import org.junit.Test;

import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 03/20/2019 11:23 AM
 */
public class JavaStream {

    //Integer Stream forEach
    @Test
    public void test1(){
        IntStream.range(1,10)
                .forEach(System.out::print);
    }

    //Integer Stream with skip
    @Test
    public void test2(){
        IntStream.range(1,10)
                .skip(4)
                .forEach(x ->System.out.print(x));
    }

    //Integer Stream with sum
    @Test
    public void test3(){
        System.out.println(
        IntStream.range(1,10)
                .sum()
        );
    }

    //Stream of,sorted and firstFind
    @Test
    public void test4(){
        Stream.of("Ava","Aneri","Alberto")
                .sorted()
                .findFirst()
                .ifPresent(System.out::println);
    }

    //Stream for Array,sort,filter and print
    @Test
    public void test5(){
        String [] names = {"Al","Ankit","Kushal","Brent","Sarika","amanda","Hans","Shivika","Shara"};
        Arrays.stream(names)    //same as  Stream.of(names)
                .filter(x -> x.startsWith("S"))
                .sorted()
                .forEach(System.out::println);
    }

    //Average of squares of an int array
    @Test
    public void test6(){
        Arrays.stream(new int[]{2,4,6,8})
                .map(x -> x * x)
                .average()
                .ifPresent(System.out::println);
    }

    //Stream for List,filter and print
    @Test
    public void test7(){
        List<String> people = Arrays.asList("Al","Ankit","Kushal","Brent","Sarika","amanda","Hans","Shivika","Shara");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }

    //Stream rows from text file,sort,filter and print
    @Test
    public void test8() throws IOException {
        Stream<String> band = Files.lines(Paths.get("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\stream\\band.txt"));
        band
                .filter(x->x.length() > 13)
                .sorted()
                .forEach(System.out::println);
        band.close();
    }

    //Stream rows from text file and save to list
    @Test
    public void test9() throws IOException {
        List<String> band = Files.lines(Paths.get("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\stream\\band.txt"))
                .filter(x->x.contains("jit"))
                .collect(Collectors.toList());
        band.forEach(System.out::println);
    }

    //Stream rows from CVS file and count
    @Test
    public void test10() throws IOException {
        Stream<String> row = Files.lines(Paths.get("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\stream\\data.txt"));
                int rowCnt = (int) row.map(x->x.split(","))
                .filter(x -> x.length == 3)
                .count();
        System.out.println(rowCnt + " rows.");
        row.close();
    }


    //Stream rows from CVS file and store fields in a HashMap
    @Test
    public void test11() throws IOException {
        Stream<String> row = Files.lines(Paths.get("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\stream\\data.txt"));
        Map<String,Integer> map = row.map(x->x.split(","))
                .filter(x -> x.length == 3)
                .filter(x -> Integer.parseInt(x[1]) > 13)
                .collect(Collectors.toMap(x->x[0],x->Integer.parseInt(x[1])));
        for (String key : map.keySet())
            System.out.println(key + ":" + map.get(key));
        row.close();
    }

    //Reduction and sum
    @Test
    public void test12() {
       double total = Stream.of(7.3,2.5,33.2)
               .reduce(.0,(Double a,Double b)->(a+b));
        System.out.println(total);
    }

    //Summary statistic
    @Test
    public void test13(){
        IntSummaryStatistics summary =
                IntStream.of(12,23,44)
                .summaryStatistics();
        System.out.println(summary);
    }
}
