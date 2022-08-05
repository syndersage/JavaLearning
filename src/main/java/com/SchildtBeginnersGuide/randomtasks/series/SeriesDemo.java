package com.SchildtBeginnersGuide.randomtasks.series;

import java.util.Arrays;

interface DefaultSeries {
    void setStart(int start);
    int getNext();
    void restart();
    default int[] getNextArray(int size) {
        int[] arr = new int[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = getNext();
        }
        return arr;
    }
}

interface DefaultDescription {
    String getSeriesDescription();
    void setSeriesDescription(String description);
}

class PowTwo implements DefaultSeries, DefaultDescription {
    private int start = 1;
    private int current = start;
    private String description;

    public void setSeriesDescription(String description) {
        this.description = description;
    }

    public String getSeriesDescription() {
        return description;
    }

    public void setStart(int start) {
        this.start = this.current = start;
    }

    public int getNext() {
        current = (int) Math.pow(current, 2);
        return current;
    }

    public int getCurrent() {
        return current;
    }

    public int getPrevious() {
        return (int) Math.sqrt(current);
    }

    public void restart() {
        current = start;
    }
}

public class SeriesDemo {
    public static void main(String[] args) {
        PowTwo series = new PowTwo();
        series.setStart(2);
        series.setSeriesDescription("Every subsequent value equals pow by two of previous");
        for (int i = 0; i < 4; i++) {
            System.out.println(series.getNext());
        }
        series.setStart(3);
        series.restart();
        for (int i = 0; i < 3; i++) {
            System.out.println(series.getNext());
        }
        System.out.println(series.getSeriesDescription());
        System.out.println(series.getPrevious());
        System.out.println();
        series.setStart(2);
        System.out.println(Arrays.toString(series.getNextArray(5)));
    }
}
