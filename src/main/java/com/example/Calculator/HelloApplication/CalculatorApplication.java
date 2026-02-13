package com.example.calculator;
/*This code is copied from https://www.w3resource.com/java-exercises/javafx/javafx-basic-exercise-7.php
* I have no intention of claiming it as my own work. This is strictly for my own learning purposes*/

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CalculatorApplication extends Application{

        private TextField num1Field; //Create the Field for the First Number
        private TextField num2Field; //Create the Field for the Second Number
        private Label resultLabel; //Create the Label for the Result

        public static void main(String[] args) {
            launch(args); //Nothing happens when commented out
            //Use unknown
        }

        @Override
        public void start(Stage primaryStage) {
            primaryStage.setTitle("Basic Calculator"); //Sets the Title of the Tab

            GridPane grid = new GridPane(); //Creates grid to organize UI elements
            grid.setHgap(10);//Sets Horizontal Distance between UI elements
            grid.setVgap(10); //Sets Vertical Distance between UI elements
            grid.setPadding(new Insets(10, 10, 10, 10)); //Distance from edge of open tab (V3 is left side)

            num1Field = new TextField(); //Creates a textfield
            num1Field.setPromptText("Enter first number"); //Puts a prompt in textfield
            GridPane.setConstraints(num1Field, 0, 0); //Sets its positon accourding to the padded grid (I is x direction) (I1 is y direction)

            num2Field = new TextField();
            num2Field.setPromptText("Enter second number");
            GridPane.setConstraints(num2Field, 0, 1); //I/I1 cannot be negative

            resultLabel = new Label("Result: ");
            GridPane.setConstraints(resultLabel, 0, 2);

            Button addButton = new Button("Add"); //Creates button
            addButton.setOnAction(e -> performOperation('+')); //Assigns a action to when that button is clicked
            GridPane.setConstraints(addButton, 1, 0); //Sets position of the button

            Button subtractButton = new Button("Subtract");
            subtractButton.setOnAction(e -> performOperation('-'));
            GridPane.setConstraints(subtractButton, 2, 0);

            Button multiplyButton = new Button("Multiply");
            multiplyButton.setOnAction(e -> performOperation('*'));
            GridPane.setConstraints(multiplyButton, 1, 1);

            Button divideButton = new Button("Divide");
            divideButton.setOnAction(e -> performOperation('/'));
            GridPane.setConstraints(divideButton, 2, 1);

            grid.getChildren().addAll(num1Field, num2Field, resultLabel, addButton, subtractButton, multiplyButton, divideButton); //Adds UI elements to the grid

            Scene scene = new Scene(grid, 300, 200); //Creates Tab size
            primaryStage.setScene(scene);
            primaryStage.show(); //Show the window
        }

        //The function for the buttons
        private void performOperation(char operator) {
            String num1Text = num1Field.getText();
            String num2Text = num2Field.getText();

            if (isValidNumber(num1Text) && isValidNumber(num2Text)) {
                double num1 = Double.parseDouble(num1Text);
                double num2 = Double.parseDouble(num2Text);
                double result = 0.0;

                switch (operator) {
                    case '+':
                        result = num1 + num2;
                        break;
                    case '-':
                        result = num1 - num2;
                        break;
                    case '*':
                        result = num1 * num2;
                        break;
                    case '/':
                        if (num2 != 0) {
                            result = num1 / num2;
                        } else {
                            resultLabel.setText("Result: Error (Division by zero)");
                            return;
                        }
                        break;
                    default:
                        break;
                }

                resultLabel.setText("Result: " + result);
            } else {
                resultLabel.setText("Result: Invalid Input");
            }
        }

        //Checks if the button works
        private boolean isValidNumber(String text) {
            return text.matches("-?\\d*\\.?\\d+");
        }
    }
