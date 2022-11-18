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
        Button sortBtn = new Button("Bubble Sort");
        Button genBtn = new Button("Generate");
        HBox buttons = new HBox(sortBtn,genBtn);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        BarChart barChart = new BarChart(30);
        hBox.getChildren().addAll(barChart);
        borderPane.setCenter(hBox);
        borderPane.setTop(buttons);
        Scene scene = new Scene(borderPane, 1200, 750);

        sortBtn.setOnMouseClicked( e -> {
            genBtn.setDisable(true);
            sortBtn.setDisable(true);
            SequentialTransition sort = barChart.BubbleSort();
            sort.play();
            sort.setOnFinished(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    genBtn.setDisable(false);
                    sortBtn.setDisable(false);
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