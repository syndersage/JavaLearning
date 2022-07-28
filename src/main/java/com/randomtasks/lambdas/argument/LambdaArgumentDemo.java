package com.randomtasks.lambdas.argument;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

interface StringFunc {
    String changer(String str) throws IOException;
}

public class LambdaArgumentDemo {
    int var = 1;

    static String changeStr(StringFunc func, String str) throws IOException {
        return func.changer(str);
    }

    public static void main(String[] args) throws IOException {
        String inStr = "Some input text!";
        StringFunc reverse = str -> {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            reader.readLine();
            StringBuilder retStr = new StringBuilder();
            for (int i = str.length() - 1; i >= 0; i--) {
                retStr.append(str.charAt(i));
            }
            return retStr.toString();
        };
        System.out.println(changeStr(reverse, inStr));
        System.out.println(changeStr(str -> {
            String retStr = "";
            while (true) {
                if (str.lastIndexOf(' ') != -1) {
                    retStr += str.substring(str.lastIndexOf(' ') + 1) + " ";
                    str = str.substring(0, str.lastIndexOf(' '));
                } else return retStr.concat(str);
            }
        }, inStr));
        System.out.println(changeStr(str -> str.replace(' ', '-'), inStr));
    }
}
