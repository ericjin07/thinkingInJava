package com.eric.strings;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by IntelliJ IDEA.
 * Author: EricJin
 * Date: 05/22/2019 9:36 AM
 */
public class JsEncode {

    private static final Pattern SCRIPT_PATTERN = Pattern.compile("<[/]?script>", Pattern.CASE_INSENSITIVE);

    public static String jsEncode(String input) {
        Matcher m = SCRIPT_PATTERN.matcher(input);
        String next ;
        while (m.find()) {
            System.out.println(m.group());
            next = angleBracketEncode(m.group());
            input = input.replaceFirst(m.group(), next);
        }
        return input;
    }

    public static String angleBracketEncode(String input) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < input.length(); ++i) {
            char ch = input.charAt(i);

            if (ch == '<') {
                sb.append("&lt;");
            } else if (ch == '>') {
                sb.append("&gt;");
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String js = "<a><Script>a<//script><a>";
        System.out.println(jsEncode(js));
    }
}
