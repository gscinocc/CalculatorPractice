package com.example.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;

import static javafx.application.Application.launch;
public class HelloApplication extends Application {
    //Create number field
    private TextField num1Field;
    private TextField num2Field;
    private Label resultLabel;

    public static void main(String[] args) {
        launch(args);
    }

    //@Override
    public void start(@org.jetbrains.annotations.NotNull Stage primaryStage) throws IOException {
        primaryStage.setTitle("Basic Calculator"); //Sets the Window Title

        GridPane grid = new GridPane(); //Creates the grid for organizing
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(10, 10, 10, 10));

        num1Field = new TextField();
        num1Field.setPromptText("Enter first number");
        GridPane.setConstraints(num1Field, 0, 0);

        num2Field = new TextField();
        num2Field.setPromptText("Enter second number");
        GridPane.setConstraints(num2Field, 0, 1);

        resultLabel = new Label("Result: ");
        GridPane.setConstraints(resultLabel, 0, 2);

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> performOperation('+'));

        Button subtractButton = new Button("Subtract");
        subtractButton.setOnAction(e -> performOperation('-'));

        grid.getChildren().addAll(num1Field, num2Field, addButton, subtractButton);

        //FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(grid, 300, 200);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void performOperation(char operator) {
        String num1Text = num1Field.getText();
        String num2Text = num2Field.getText();

        if (isValidNumber(num1Text) && isValidNumber(num2Text)) {
            double num1 = Double.parseDouble(num1Text);
            double num2 = Double.parseDouble(num2Text);
            double result = 0.0;

            if (operator == '+') {
                result = num1 + num2;
            } else if (operator == '-') {
                result = num1 - num2;
            }

            resultLabel.setText("Result: " + result);
        } else {
            resultLabel.setText("Result: Invalid Input");
        }
    }

    private boolean isValidNumber(String text) {
        return text.matches("-?//d+");
    }
}
