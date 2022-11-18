package com.example.sorting_visualizer;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.Random;

public class Bar extends Rectangle {

    public Bar() {
        this.setWidth(30);
        Random random = new Random();
        this.setHeight(random.nextInt(710)+20);
        this.setStroke(Color.BLACK);
        this.setFill(Color.LIGHTBLUE);
    }

}
