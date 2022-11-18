package com.example.sorting_visualizer;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class BarChart extends ArrayList<Bar> {

    private final Random random = new Random();
    private double[] values;
    final int numOfBars;

    public BarChart(final int n) {
        this.numOfBars = n;
        this.values = new double[n];
        for (int i = 0; i < n; i++) {
            Bar bar = new Bar();
            this.add(bar);
            values[i] = bar.getHeight();
        }
    }

    public void swapIndex(final int i, final int j) {
        Collections.swap(this, i, j);
    }

    public double getValueOf(final int index) {
        return values[index];
    }

    public void SwapValues(final int i, final int j) {
        double tmp = values[i];
        values[i] = values[j];
        values[j] = tmp;
    }

    public ParallelTransition SwapBars(final int indexOfBar1, final int indexOfBar2) {
        double speed = 70;
        Bar bar1 = this.get(indexOfBar1);
        Bar bar2 = this.get(indexOfBar2);
        TranslateTransition transition1 = new TranslateTransition(Duration.millis(speed), bar1);
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(speed), bar2);
        ParallelTransition parallelTransition = new ParallelTransition();
        transition1.setByX(31);
        transition2.setByX(-31);
        parallelTransition.getChildren().addAll(transition1, transition2);
        this.swapIndex(indexOfBar1, indexOfBar2);
        return parallelTransition;
    }

    public SequentialTransition BubbleSort() {
        SequentialTransition sequentialTransition = new SequentialTransition();
        for (int i = 0; i < numOfBars ; i++) {
            for (int j = 0; j < numOfBars - i - 1; j++ ) {
                if (this.getValueOf(j) > this.getValueOf(j+1)) {
                    this.SwapValues(j, j+1);
                    ParallelTransition swap = SwapBars(j, j+1);
                    sequentialTransition.getChildren().add(swap);
                }
            }
        }
        return sequentialTransition;
    }

    void generateNewValues() {
        for (int i = 0; i < numOfBars; i++) {
            Bar bar = this.get(i);
            int newHeight = random.nextInt(710)+20;
            bar.setHeight(newHeight);
            values[i] = newHeight;
        }
    }
}
