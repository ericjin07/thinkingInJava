package com.eric.interfaces;

import java.io.IOException;
import java.nio.CharBuffer;
import java.util.Random;
import java.util.Scanner;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 09/20/2018 8:25 PM
 */
public class AdaptRandomChar
        extends RandomChars
        implements Readable {
    private int count;
    public AdaptRandomChar(int count) {
        this.count = count;
    }
    public int read(CharBuffer cb) {
        if(count-- == 0) return -1;
        String result = Character.toString(next()) + " ";
        System.out.println("result ---" + result);
        cb.append(result);
        return result.length();
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(new AdaptRandomChar(10));
        while(s.hasNext())
            System.out.println(s.next() + " ");
    }
}

class RandomChars {
	private static Random rand = new Random();
	public char next() {
		return (char)rand.nextInt(128);
	}
	public static void main(String[] args) {
		RandomChars rc = new RandomChars();
		for(int i = 0; i < 10; i++)
			System.out.print(rc.next() + " ");
	}
 }