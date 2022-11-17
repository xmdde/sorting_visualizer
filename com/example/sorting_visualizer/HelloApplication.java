package com.example.sorting_visualizer;

import javafx.animation.ParallelTransition;
import javafx.animation.SequentialTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;

public class HelloApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {

        BorderPane borderPane = new BorderPane();
        HBox hBox = new HBox();
        Button sortBtn = new Button("Sort");
        Button genBtn = new Button("Generate");
        HBox buttons = new HBox(sortBtn,genBtn);
        hBox.setAlignment(Pos.BOTTOM_CENTER);
        BarChart barChart = new BarChart(30);
        hBox.getChildren().addAll(barChart);
        borderPane.setCenter(hBox);
        borderPane.setTop(buttons);

        Scene scene = new Scene(borderPane, 1200, 750);
        BubbleSort(barChart).play();

        stage.setTitle("Bubble Sort Visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    private ParallelTransition SwapBars (int indexOfBar1, int indexOfBar2, BarChart barList) {
        double speed = 100;
        Bar bar1 = barList.get(indexOfBar1);
        Bar bar2 = barList.get(indexOfBar2);
        TranslateTransition transition1 = new TranslateTransition(Duration.millis(speed), bar1);
        TranslateTransition transition2 = new TranslateTransition(Duration.millis(speed), bar2);
        ParallelTransition parallelTransition = new ParallelTransition();
        transition1.setByX(31);
        transition2.setByX(-31);
        parallelTransition.getChildren().addAll(transition1,transition2);
        barList.SwapIndex(indexOfBar1, indexOfBar2);
        return parallelTransition;
    }

    private SequentialTransition BubbleSort (BarChart barChart) {
        SequentialTransition sequentialTransition = new SequentialTransition();
        int num = barChart.size();
        for (int i = 0; i < num ; i++) {
            for (int j = 0; j < num - i - 1; j++ ) {
                if (barChart.getValueOf(j) > barChart.getValueOf(j+1)) {
                    barChart.SwapValues(j, j+1);
                    ParallelTransition swap = SwapBars(j, j+1, barChart);
                    sequentialTransition.getChildren().add(swap);
                }
            }
        }
        return sequentialTransition;
    }

}