package com.SchildtBeginnersGuide.randomtasks;

class ShowBits {
    int maxBitsLength;

    ShowBits(int maxBitsLength) {
        if (maxBitsLength >= 64) {
            this.maxBitsLength = 63;
            if (maxBitsLength > 64) System.out.println("Bit length changed to max value: 64");
        }
        else this.maxBitsLength = maxBitsLength;
    }

    String getBits(long valueToShow) {
        String bitsAsString = "";
        int spacer = 0, spaceEveryNSymbols = 8;
        for (var i = (1L << (maxBitsLength - 1)); i > 0; i >>>= 1, spacer++) {
            if (spacer == 8) {
                bitsAsString = bitsAsString.concat(" ");
                spacer = 0;
            }
            if ((valueToShow & i) == 0) bitsAsString = bitsAsString.concat("0");
            else bitsAsString = bitsAsString.concat("1");
        }
//        while (bitsAsString.length() > 8 && bitsAsString.startsWith("00000000")) {
//            bitsAsString = bitsAsString.substring(9);
//        }
        return bitsAsString;
    }
}

public class BitwiseOperations {
    public static void main(String[] args) {
        ShowBits showbits = new ShowBits(100);
        System.out.println(showbits.getBits(9_223_372_036_854_775_807L));
    }
}
