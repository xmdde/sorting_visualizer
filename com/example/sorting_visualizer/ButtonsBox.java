package com.example.sorting_visualizer;

import javafx.scene.control.Button;
import javafx.scene.layout.HBox;

public class ButtonsBox extends HBox {

    Button bsortBtn;
    Button genBtn;
    Button isortBtn;
    Button selBtn;

    public ButtonsBox() {
        this.bsortBtn = new Button("Bubble Sort");
        this.genBtn = new Button("Generate");
        this.isortBtn = new Button("Insertion Sort");
        this.selBtn = new Button("Selection Sort");
        this.getChildren().addAll(genBtn, bsortBtn, isortBtn, selBtn);
    }

    public void buttonsAble() {
        this.bsortBtn.setDisable(false);
        this.genBtn.setDisable(false);
        this.isortBtn.setDisable(false);
        this.selBtn.setDisable(false);
    }

    public void buttonsDisable() {
        this.bsortBtn.setDisable(true);
        this.genBtn.setDisable(true);
        this.isortBtn.setDisable(true);
        this.selBtn.setDisable(true);
    }

}
