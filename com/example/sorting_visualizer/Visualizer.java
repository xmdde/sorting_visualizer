package com.example.sorting_visualizer;

import javafx.animation.SequentialTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.io.IOException;

public class Visualizer extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        ButtonsBox buttons = new ButtonsBox();
        BarChart barChart = new BarChart(36);
        hBox.getChildren().addAll(barChart);
        borderPane.setCenter(hBox);
        borderPane.setTop(buttons);
        Scene scene = new Scene(borderPane, 1200, 750);

        buttons.bsortBtn.setOnMouseClicked( e -> {
            buttons.buttonsDisable();
            SequentialTransition sort = barChart.BubbleSort();
            sort.play();
            sort.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    buttons.buttonsAble();
                }
            });
        });

        buttons.isortBtn.setOnMouseClicked( e -> {
            buttons.buttonsDisable();
            SequentialTransition sort = barChart.insertionSort();
            sort.play();
            sort.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    buttons.buttonsAble();
                }
            });
        });

        buttons.selBtn.setOnMouseClicked( e -> {
            buttons.buttonsDisable();
            SequentialTransition sort = barChart.selectionSort();
            sort.play();
            sort.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    buttons.buttonsAble();
                }
            });
        });

        buttons.genBtn.setOnMouseClicked( e -> {
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