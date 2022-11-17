module com.example.sorting_visualizer {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.sorting_visualizer to javafx.fxml;
    exports com.example.sorting_visualizer;
}