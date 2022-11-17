package com.example.sorting_visualizer;

import java.util.ArrayList;
import java.util.Collections;

public class BarChart extends ArrayList<Bar> {

    double[] values;
    int numOfBars;

    public BarChart(int n) {
        this.numOfBars = n;
        this.values = new double[n];
        for (int i = 0; i < n; i++) {
            Bar bar = new Bar();
            this.add(bar);
            values[i] = bar.getHeight();
        }
    }

    public void SwapIndex(int i, int j) {
        Collections.swap(this, i, j);
    }

    public double getValueOf(int index) {
        return values[index];
    }

    public void SwapValues(int i, int j) {
        double tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

}
