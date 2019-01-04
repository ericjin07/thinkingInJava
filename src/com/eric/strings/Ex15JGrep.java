package com.eric.strings;

import net.mindview.util.TextFile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 01/03/2019 9:54 PM
 */
public class Ex15JGrep {

    public static void main(String[] args) {

        if (args.length < 2) {
            System.out.println("Usage of the Ex15JGrep");
            System.exit(0);
        }
        int flag = 0;
        if (args.length > 2)
            flag = getFlag(args[2]);
        Pattern p = Pattern.compile(args[1],flag);
        Matcher m = p.matcher("");
        File file = new File(args[0]);

        getFile(file,m);

    }

    private static void getFile(File file, Matcher m) {
        if (!file.isDirectory()) {
            readPattern(file.getAbsolutePath(),m);
        } else {
            File[] files = file.listFiles();
            for (File f : files) {
                if (!f.isDirectory())
                    readPattern(f.getAbsolutePath(),m);
                else getFile(f,m);
            }
        }
    }

    private static void readPattern(String fileName, Matcher m) {
        int i = 0;
        System.out.println(fileName);
        for (String line : new TextFile(fileName)) {
            m.reset(line);
            System.out.println(line);
            while (m.find())
                System.out.println(i++ + ":" + m.group() + " : " + m.start());
        }
    }

    private static int getFlag(String arg) {
        int flag = 0;
        switch (arg) {
            case "CASE_INSENSITIVE":
                flag = Pattern.CASE_INSENSITIVE;
                break;
            case "COMMENTS":
                flag = Pattern.COMMENTS;
                break;
            case "MULTILINE":
                flag = Pattern.MULTILINE;
                break;
            case "LITERAL":
                flag = Pattern.LITERAL;
                break;
            case "DOTALL":
                flag = Pattern.DOTALL;
                break;
            case "UNICODE_CASE":
                flag = Pattern.UNICODE_CASE;
                break;
        }
        return flag;
    }
}
