package com.SchildtBeginnersGuide.randomtasks.multithreading.synchronization.waitAndNotify;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

class UserInputReader {
    static String inp;
    synchronized void read() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                wait();
                if (inp != null && inp.equals("stop")) {

                    notify();
                    break;
                }
                inp = reader.readLine();
                notify();
            }
            catch (IOException exception) {
                System.out.println("I/O error");
            }
            catch (InterruptedException exception) {
                System.out.println("Interrupted");
            }
        }
    }
    synchronized void write() {
        PrintWriter pw = new PrintWriter(System.out, true);
        while (true) {
            if (inp == null || inp.equals("")) pw.print("Enter some text: ");
            else if (inp.equals("stop")) {
                pw.println("Quiting...");
                pw.flush();
                notify();
                break;
            }
            else pw.print("Previous text is: " + inp + " enter new text: ");
            pw.flush();
            notify();
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

class MyThread implements Runnable {
    Thread thread;
    boolean read;
    UserInputReader uir;
    MyThread(String name, UserInputReader uir, boolean read) {
        thread = new Thread(this, name);
        this.uir = uir;
        this.read = read;
    }
    public static MyThread createAndStart(String name, UserInputReader uir, boolean read) {
        MyThread thread = new MyThread(name, uir, read);
        thread.thread.start();
        return thread;
    }
    @Override
    public void run() {
        if (read) uir.read();
        else uir.write();
    }
}

public class WaitAndNotify {
    public static void main(String[] args) {
        UserInputReader uir = new UserInputReader();
        MyThread thread1 = MyThread.createAndStart("reader", uir, true);
        MyThread thread2 = MyThread.createAndStart("writer", uir, false);
        try {
            thread1.thread.join();
            thread2.thread.join();
        }
        catch (InterruptedException exception) {
            System.out.println("Join error");
        }
    }
}
