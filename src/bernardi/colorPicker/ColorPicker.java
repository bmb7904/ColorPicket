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
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

import java.util.concurrent.ThreadLocalRandom;

/**
 * A JavaFX application that will allow the user to select a color and display that
 * color using some JavaFX GUI elements.
 */

public class ColorPicker extends Application {

    private static Color shownColor;
    private static double redComponent;
    private static double greenComponent;
    private static double blueComponent;
    private static String redValue;
    private static String greenValue;
    private static String blueValue;

    @Override
    public void start(Stage primaryStage) {
        BorderPane root = new BorderPane();
        root.setStyle("-fx-background-color: LIGHTGRAY;");
        Scene scene = new Scene(root);

        String styleBackground = "-fx-background-color: ";
        String styleFont = "-fx-font-weight: BOLD; -fx-font-size: 16px; -fx-text-fill: ";

        FlowPane leftPane = new FlowPane(Orientation.VERTICAL);
        leftPane.setVgap(10);
        leftPane.setAlignment(Pos.CENTER);
        FlowPane rightPane = new FlowPane(Orientation.VERTICAL);
        rightPane.setVgap(10);
        rightPane.setAlignment(Pos.CENTER);
        FlowPane bottomPane = new FlowPane();
        bottomPane.setAlignment(Pos.CENTER);

        Rectangle rect = new Rectangle(400,270);
        shownColor = Color.BLUE;
        rect.setFill(shownColor);

        CheckBox redCheckBox = new CheckBox();
        redCheckBox.setStyle(styleBackground + "RED;");
        CheckBox greenCheckBox = new CheckBox();
        greenCheckBox.setStyle(styleBackground + "GREEN;");
        CheckBox blueCheckBox = new CheckBox();
        blueCheckBox.setStyle(styleBackground + "BLUE;");

        Label redLabel = new Label("0.58");
        redLabel.setStyle(styleFont + "RED;");
        Label greenLabel = new Label("0049");
        greenLabel.setStyle(styleFont + "GREEN;");
        Label blueLabel = new Label("99.4");
        blueLabel.setStyle(styleFont + "BLUE");

        Button randomizeButton = new Button("Randomize");
        randomizeButton.setStyle("-fx-border-width: 1; -fx-border-color: BLUE;");

        leftPane.getChildren().addAll(redCheckBox,greenCheckBox,blueCheckBox);
        leftPane.setPadding(new Insets(0,20,0,10));
        leftPane.setVgap(15);
        rightPane.getChildren().addAll(redLabel,greenLabel,blueLabel);
        rightPane.setVgap(15);
        rightPane.setPadding(new Insets(8));
        bottomPane.getChildren().add(randomizeButton);
        bottomPane.setPadding(new Insets(0,0,10,0));

        root.setCenter(rect);
        root.setLeft(leftPane);
        root.setRight(rightPane);
        root.setBottom(bottomPane);

        ThreadLocalRandom rand = ThreadLocalRandom.current();

        randomizeButton.setOnAction(event -> {

        });

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
