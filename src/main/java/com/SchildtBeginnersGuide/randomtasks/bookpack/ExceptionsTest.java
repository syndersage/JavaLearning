package com.SchildtBeginnersGuide.randomtasks.bookpack;

import java.io.IOException;

class ExtGeneratorBasis {
    static void hehe() throws IOException {
        System.out.println("HEHE");
        System.in.read();
    }
}

class ExcGenerator extends ExtGeneratorBasis {
    static void some() {
        System.out.println("some");
    }
    static void meth(int index) throws ArrayIndexOutOfBoundsException {
        int[] arr = new int[3];
        switch (index) {
            case 0 -> arr[0] = 10 / index;
            case 1 -> arr[5] = 10;
            case 2 -> arr[0] = 1;
            default -> System.out.println("DEFAULT VALUE");
        }
    }
    ExcGenerator(int a, int b) {
        a = b;
    }
}

public class ExceptionsTest {
    public static void main(String[] args) throws java.io.IOException {
        try {
            System.in.read();
            for (int i = 0; i < 3; i++) {
                try {
                    ExcGenerator.meth(i);
                }
                catch (ArithmeticException exc) {
                    throw new RuntimeException();
                }
//                catch (ArrayIndexOutOfBoundsException exc) {
//                    System.out.println("Array size exception: " + exc.getLocalizedMessage());
//                }
//                catch (Throwable exc) {
//                    System.out.println("DEFAULT EXCEPTION!");
//                }
                finally {
                    System.out.println("Finally of " + i + " iteration");
                    String str = "0123";
                    try {
                        int a = Integer.parseInt(str);
                        System.out.println(a);
                    }
                    catch (NumberFormatException e) {
                        System.out.println(str + " string cannot be integer!");
                    }
                }
            }
        }
        catch (IOException exception) {
            System.out.println("HEHE");
        }
//        catch (ArrayIndexOutOfBoundsException exception) {
//            System.out.println("QWEWQEWQEWQ");
//        }
//        catch (Exception e) {
//            System.out.println("DEFAULT");
//        }
        System.out.println(ArrayIndexOutOfBoundsException.class.getSuperclass().getSuperclass().getSuperclass().getSuperclass().getSuperclass());
    }
}
