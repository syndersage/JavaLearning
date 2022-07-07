package com.randomtasks;

class OuterTest {
    int a;
    class InnerTest {
        int b;
        void meth () {
            this.b = a;
        }
    }
}

public class ShowBitsOuter {
    public static void main(String[] args) {
        class ShowBitsInner {
            private final byte size;
            private final static byte defaultSize = 16;

            ShowBitsInner(int size) {
                this.size = (size < 1 || size >= 64) ? defaultSize : (byte) size;
            }

            public String getBits(long value) {
                var result = new StringBuilder();
                byte spacer = (byte) (9 - (size % 8));
                for (var i = (1L << (size - 1)); i > 0; i >>>= 1, spacer++) {
                    result.append((value & i) == 0 ? "0" : "1");
                    if (spacer == 8) {
                        result.append(" ");
                        spacer = 0;
                    }
                }
                return result.toString();
            }
        }
        var bits = new ShowBitsInner(17);
        System.out.println(bits.getBits(-1234567890123213999L));
    }
}
