package com.SchildtBeginnersGuide.randomtasks.enumerations.selftest.s05.t07;

class CoderStringXOR {
    String key;

    String code(String stringToCode) {
        StringBuilder codedString = new StringBuilder();
        for (int i = 0; i < stringToCode.length(); i++) {
            codedString.append((char) (stringToCode.charAt(i) ^ key.charAt(i % key.length())));
            System.out.println("wtf: " + codedString);
        }
        return codedString.toString();
    }

    CoderStringXOR(String key) {
        this.key = key;
    }
}

public class XORCipher {
    public static void main(String[] args) {
        var coder = new CoderStringXOR("HELLO");
        System.out.println(coder.code("?$?('--)( <$y"));
    }
}
