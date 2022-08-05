package com.SchildtBeginnersGuide.randomtasks.bookpack;

class AException extends Exception {
    AException(Throwable thr) {
        super(thr);
    }
    AException(String cause, Throwable thr) {
        super(cause, thr);
    }
}

class BException extends Exception {
    BException(Throwable thr) {
        super(thr);
    }
    BException(String cause, Throwable thr) {
        super(cause, thr);
    }
}

public class ChainingExceptions {
    public static void main(String[] args) {
        try {
            someIntermediateMethod();
        } catch (BException e) {
            System.out.println(e.getCause().getMessage());
        }
    }

    private static void someIntermediateMethod() throws BException {
        try {
            someMethod();
        } catch (AException e) {
            throw new BException(e);
        }
    }

    private static void someMethod() throws AException {
        try {
            int[] arr = new int[4];
            arr[5] = 10;
        }
        catch (ArrayIndexOutOfBoundsException exc) {
            throw new AException(exc);
        }
    }
}
