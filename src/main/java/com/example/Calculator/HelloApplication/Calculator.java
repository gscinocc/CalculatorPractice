package com.example.Calculator.HelloApplication;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

import java.io.IOException;

public class Calculator extends Application {
    private String term1 = "";
    private String term2 = "";
    private char operator = ' ';
    private Label resultLabel = new Label("Result");
    private javafx.scene.control.Label display = new javafx.scene.control.Label();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Calculator.class.getResource("/com/example/Calculator/HelloApplication/calculator.fxml"));
        GridPane grid = new GridPane(); //Creates grid to organize UI elements
        Scene scene = new Scene(grid, 400, 400);
        stage.setTitle("Calculator");

        grid.setHgap(10);//Sets Horizontal Distance between UI elements
        grid.setVgap(10); //Sets Vertical Distance between UI elements
        grid.setPadding(new Insets(10, 10, 10, 10)); //Distance from edge of open tab (V3 is left side)

        //Add the display label to the top
        GridPane.setConstraints(display, 1, 4, 3, 1);
        grid.getChildren().add(display);

        //Create number buttons
        Button num1 = new Button("1");
        num1.setOnAction(e->getNumber("1"));
        GridPane.setConstraints(num1, 1, 1);

        Button num2 = new Button("2");
        num2.setOnAction(e->getNumber("2"));
        GridPane.setConstraints(num2, 2, 1);

        Button num3 = new Button("3");
        num3.setOnAction(e->getNumber("3"));
        GridPane.setConstraints(num3, 3, 1);

        Button num4 = new Button("4");
        num4.setOnAction(e->getNumber("4"));
        GridPane.setConstraints(num4, 1, 2);

        Button num5 = new Button("5");
        num5.setOnAction(e->getNumber("5"));
        GridPane.setConstraints(num5, 2, 2);

        Button num6 = new Button("6");
        num6.setOnAction(e->getNumber("6"));
        GridPane.setConstraints(num6, 3, 2);

        Button num7 = new Button("7");
        num7.setOnAction(e->getNumber("7"));
        GridPane.setConstraints(num7, 1, 3);

        Button num8 = new Button("8");
        num8.setOnAction(e->getNumber("8"));
        GridPane.setConstraints(num8, 2, 3);

        Button num9 = new Button("9");
        num9.setOnAction(e->getNumber("9"));
        GridPane.setConstraints(num9, 3, 3);

        Button num0 = new Button("0");
        num0.setOnAction(e->getNumber("0"));
        GridPane.setConstraints(num0, 2, 4);

        //Create Operator Buttons
        Button add = new Button("+");
        add.setOnAction(e->getOperator('+'));
        GridPane.setConstraints(add, 4, 1);

        Button subtract = new Button("-");
        subtract.setOnAction(e->getOperator('-'));
        GridPane.setConstraints(subtract, 4, 2);

        Button multiply = new Button("*");
        multiply.setOnAction(e->getOperator('*'));
        GridPane.setConstraints(multiply, 4, 3);

        Button divide = new Button("/");
        divide.setOnAction(e->getOperator('/'));
        GridPane.setConstraints(divide, 4, 4);

        Button equal = new Button("=");
        equal.setOnAction(e->performOperation('='));
        GridPane.setConstraints(equal, 3, 4);

        //Create Clear Button
        Button AC = new Button("AC");
        add.setOnAction(e->clear('A'));
        GridPane.setConstraints(AC, 0, 4);

        GridPane.setConstraints(resultLabel, 0, 0);

        grid.getChildren().addAll(num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, add, subtract, multiply, divide, equal, resultLabel, AC);
        stage.setScene(scene);
        stage.show();
    }

    public void getNumber(String num){
        if (operator == ' '){
            term1 += num;
        }
        else if (operator == '='){
            //Do the result
        }
        else{
            term2 +=num;
        }
    }

    public void getOperator(char op){
        if (op == '+'){
            //add
            operator = op;
        }
        else if (op == '-'){
            //subtract
            operator = op;
        }
        else if(op == '*'){
            operator = op;
        }
        else if (op == '/'){
            operator = op;
        }
    }

    public void performOperation(char eq){
        double num1 = Double.parseDouble(term1);
        double num2 = Double.parseDouble(term2);
        double result = 0;
        if (eq == '='){
            if (operator == '+'){
                //add
                result = num1+num2;
            }
            else if (operator == '-'){
                //subtract
                result = num1-num2;
            }
            else if(operator == '*'){
                //Multiply
                result = num1*num2;
            }
            else if (operator == '/'){
                //Divide
                result = num1+num2;
            }
        }
        resultLabel.setText(String.valueOf(result));

    }
    public void clear(char AC){
        term1 = "";
        term2 = "";
        resultLabel.setText("Result");
    }
}

