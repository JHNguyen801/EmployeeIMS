package UIFX;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.beans.EventHandler;

public class MenuApp extends Application{

    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Employee IS Menu Demo");
        Label label = new Label();
        label.setFont(new Font("Arial", 20));
        label.setText("Employee Information Management System");
        Button btnAdd = new Button("To Add an Employee Details");
        Button btnView = new Button("To See an Employee Details");
        Button btnSort = new Button("To Sort Employee by Salary");
        Button btnFilter = new Button("To Filter Employee Info");
        Button btnExit = new Button("Exit the EIMS Portal");

        VBox vbox = new VBox(label, btnView, btnSort, btnFilter, btnExit);

        Scene scene = new Scene(vbox, 450, 300);
        primaryStage.setScene(scene);
        primaryStage.show();

//        btnAdd.setOnAction(new EventHandler() {
//
//            public void handle(ActionEvent actionEvent) {
//                //... do something in here.
//            }
//        });

    }


    public static void main(String[] args) {
        Application.launch(args);
    }
}
