package com.eric.stream;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/15/2019 8:45 PM
 */
public class Item46 {

    public static void main(String[] args) {
        String file = "D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\stream\\band.txt";
        Map<String,Long> freq = null;
        try (Stream<String> words = Files.lines(Paths.get(file))){
            freq = words.collect(groupingBy(String::toLowerCase, counting()));
            List<String> top = freq.keySet().stream()
                    .sorted(Comparator.comparing(freq::get).reversed())
                    .limit(10)
                    .collect(toList());
            System.out.println(top);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
