package ca.durhamcollege;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.control.Label;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.scene.control.TextField;

import java.io.FileInputStream;

public class Main extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        //Create image
        FileInputStream path = new FileInputStream("src/image/bmi.PNG");
        Image bmiImage = new Image(path);
        ImageView bmiImageView = new ImageView(bmiImage);
        bmiImageView.setFitWidth(200);
        bmiImageView.setPreserveRatio(true);

        //Set window title and font
        primaryStage.setTitle("Java Lab 5");
        Font font = Font.font("Consolas",20);

        //Label for height, weight, BMI and BMI Value
        Label lblHeight = new Label("My Height");
        lblHeight.setFont(font);
        Label lblWeight = new Label("My Weight");
        lblWeight.setFont(font);
        Label lblBMI = new Label("BMI:");
        lblBMI.setFont(font);
        Label lblBMIValue = new Label();

        //Height and weight text input
        TextField txtHeight = new TextField();
        TextField txtWeight = new TextField();

        Button btnCalculate = new Button("Calculate");
        btnCalculate.setFont(font);


        GridPane gridPane = new GridPane();
        gridPane.setStyle("-fx-border-color: black; -fx-font-family: Consolas");
        HBox hBoxHeight = new HBox(10, lblHeight, txtHeight);
        HBox hBoxWeight = new HBox(10, lblWeight, txtWeight);

        hBoxHeight.setAlignment(Pos.CENTER);
        hBoxWeight.setAlignment(Pos.CENTER);

        gridPane.add(lblHeight,1,1);
        gridPane.add(txtHeight,1,5);

        gridPane.add(lblWeight,1,10);
        gridPane.add(txtWeight,1,20);


        gridPane.add(btnCalculate, 1,40);
        gridPane.add(bmiImageView,1,60);
        gridPane.add(lblBMI,1,80);
        gridPane.add(lblBMIValue,1,100);



        //gridPane.add(label, 1,1);
        Scene scene = new Scene(gridPane, 320, 480);
        primaryStage.setScene(scene);
        primaryStage.show();

        btnCalculate.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                double inputWeight = 0;
                double inputHeight = 0;
                double BMI = 0;
                lblBMIValue.setText("CLICKED FAM");
                BMI = (inputWeight * 703) / (inputHeight * inputHeight);
            }
        });


        }

    public static void main(String[] args) {
        launch(args);
    }
}
