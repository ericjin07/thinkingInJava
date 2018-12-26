package com.eric.exceptions;

import javax.sound.midi.Soundbank;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 12/25/2018 5:45 PM
 */
public class InputFile {
    private BufferedReader in;

    public InputFile(String name) throws Exception {
        try {
            in = new BufferedReader(new FileReader(name));
        } catch (FileNotFoundException e) {
            System.out.println("Could not open " + name);
            throw e;
        } catch (Exception e) {
            //All other exception mush close the file
            try {
                in.close();
            } catch (IOException e1) {
                System.out.println("in.close() unsuccessful");
            }
            throw e;
        } finally {
            System.out.println("never close here");
        }
    }

    public String getLine() {
        String s = "";
        try {
            s = in.readLine();
        } catch (IOException e) {
            throw new RuntimeException("readLine failed");
        }
        return s;
    }

    public void dispose() {
        try {
            in.close();
            System.out.println("in closed successful");
        } catch (IOException e) {
            throw new RuntimeException("in.close() unsuccessful");
        }
    }

    public static void main(String[] args) {
        String s;
        try {
            InputFile ipf = new InputFile("D:\\code\\myOwnCode\\thinkInJava\\src\\com\\eric\\exceptions\\Ex8.java");
            try {
                while (( s = ipf.getLine()) != null)
                    System.out.println(s);
            } catch (Exception e) {
                System.out.println("read something failed");
                e.printStackTrace(System.out);
            } finally {
                ipf.dispose();
            }
        } catch (Exception e) {
            System.out.println("Input File Constructor fail");
        }
    }
}
