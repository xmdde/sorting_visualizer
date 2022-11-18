package com.example.sorting_visualizer;

import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Visualizer extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        Button bsortBtn = new Button("Bubble Sort");
        Button genBtn = new Button("Generate");
        Button isortBtn = new Button("Insertion Sort");
        HBox buttons = new HBox(bsortBtn, isortBtn, genBtn);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        BarChart barChart = new BarChart(30);
        hBox.getChildren().addAll(barChart);
        borderPane.setCenter(hBox);
        borderPane.setTop(buttons);
        Scene scene = new Scene(borderPane, 1200, 750);

        bsortBtn.setOnMouseClicked( e -> {
            genBtn.setDisable(true);
            bsortBtn.setDisable(true);
            isortBtn.setDisable(true);
            SequentialTransition sort = barChart.BubbleSort();
            sort.play();
            sort.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    isortBtn.setDisable(false);
                    genBtn.setDisable(false);
                    bsortBtn.setDisable(false);
                }
            });
        });

        isortBtn.setOnMouseClicked( e -> {
            genBtn.setDisable(true);
            bsortBtn.setDisable(true);
            isortBtn.setDisable(true);
            SequentialTransition sort = barChart.insertionSort();
            sort.play();
            sort.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    isortBtn.setDisable(false);
                    genBtn.setDisable(false);
                    bsortBtn.setDisable(false);
                }
            });
        });

        genBtn.setOnMouseClicked( e -> {
            barChart.generateNewValues();
        });

        stage.setTitle("Sorting Visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}