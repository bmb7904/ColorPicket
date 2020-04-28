package bernardi.colorPicker;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A JavaFX application that will allow the user to select a color and display that
 * color using some JavaFX GUI elements.
 */

public class ColorPicker extends Application {

    private static double redComponent;
    private static double greenComponent;
    private static double blueComponent;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: LIGHTGRAY;");
        Scene scene = new Scene(root);

        // Sets the font and color for check boxes
        String styleBackground = "-fx-color: ";
        String styleFont = "-fx-font-family: sans-serif; -fx-font-weight: BOLDER; " +
                "-fx-font-size: 15px; -fx-text-fill: ";


        VBox leftPane = new VBox();
        VBox rightPane = new VBox();
        HBox bottomPane = new HBox();
        Rectangle rect = new Rectangle(400,250);

        leftPane.setAlignment(Pos.CENTER);
        rightPane.setAlignment(Pos.CENTER);
        bottomPane.setAlignment(Pos.CENTER);

        rect.setFill(Color.WHITE);

        CheckBox redCheckBox = new CheckBox();
        redCheckBox.setStyle(styleBackground + "RED;");
        CheckBox greenCheckBox = new CheckBox();
        greenCheckBox.setStyle(styleBackground + "GREEN;");
        CheckBox blueCheckBox = new CheckBox();
        blueCheckBox.setStyle(styleBackground + "BLUE;");

        Label redLabel = new Label("0.00");
        redLabel.setStyle(styleFont + "RED;");
        Label greenLabel = new Label("0.00");
        greenLabel.setStyle(styleFont + "GREEN;");
        Label blueLabel = new Label("0.00");
        blueLabel.setStyle(styleFont + "BLUE");

        Button randomizeButton = new Button("Randomize");
        randomizeButton.setStyle("-fx-border-width: 1; -fx-border-color: BLUE; " +
                "-fx-font-weight: BOLD; -fx-background-color: LIGHTGRAY");

        leftPane.getChildren().addAll(redCheckBox,greenCheckBox,blueCheckBox);
        rightPane.getChildren().addAll(redLabel,greenLabel,blueLabel);
        bottomPane.getChildren().add(randomizeButton);

        leftPane.setPadding(new Insets(10,13,0,15));
        leftPane.setSpacing(20);
        rightPane.setPadding(new Insets(10,10,0,10));
        rightPane.setSpacing(20);
        bottomPane.setPadding(new Insets(10));
        root.setPadding(new Insets(20,0,0,0));


        root.setCenter(rect);
        root.setLeft(leftPane);
        root.setRight(rightPane);
        root.setBottom(bottomPane);

        ThreadLocalRandom rand = ThreadLocalRandom.current();

        randomizeButton.setOnAction(event -> {
            if(redCheckBox.isSelected()) {
                redComponent = rand.nextDouble(1.0);
            }
            else
            {
                redComponent = 0.00;
            }
            if(greenCheckBox.isSelected()) {
                greenComponent = rand.nextDouble(1.0);
            }
            else
            {
                greenComponent = 0;
            }
            if(blueCheckBox.isSelected()) {
                blueComponent = rand.nextDouble(1.0);
            }
            else
            {
                blueComponent = 0;
            }
            rect.setFill(Color.color(redComponent,greenComponent,blueComponent,1.0));
            redLabel.setText(String.format("%.2f", redComponent));
            greenLabel.setText(String.format("%.2f", greenComponent));
            blueLabel.setText(String.format("%.2f", blueComponent));
        });

        primaryStage.setScene(scene);
        primaryStage.setAlwaysOnTop(true);
        primaryStage.setResizable(false);
        primaryStage.setTitle("Color Picker");
        primaryStage.show();

    }
    public static void main(String[] args) {
        launch(args);
    }
}
