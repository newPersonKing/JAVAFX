
package view.demo;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import view.slider.JFXSlider;

public class SliderDemo extends Application {

    @Override
    public void start(Stage stage) {
        JFXSlider horLeftSlider = new JFXSlider();
        horLeftSlider.setMinWidth(500);

        JFXSlider horRightSlider = new JFXSlider();
        horRightSlider.setMinWidth(500);
        horRightSlider.setIndicatorPosition(JFXSlider.IndicatorPosition.RIGHT);

        JFXSlider verLeftSlider = new JFXSlider();
        verLeftSlider.setMinHeight(500);
        verLeftSlider.setOrientation(Orientation.VERTICAL);

        JFXSlider verRightSlider = new JFXSlider();
        verRightSlider.setMinHeight(500);
        verRightSlider.setOrientation(Orientation.VERTICAL);
        verRightSlider.setIndicatorPosition(JFXSlider.IndicatorPosition.RIGHT);

        HBox hbox = new HBox();
        hbox.setSpacing(450);
        hbox.getChildren().addAll(verRightSlider, verLeftSlider);

        VBox vbox = new VBox();
        vbox.getChildren().addAll(horRightSlider, horLeftSlider, hbox);
        vbox.setSpacing(100);
        vbox.setPadding(new Insets(100, 50, 50, 150));

        Scene scene = new Scene(new Group());
        ((Group) scene.getRoot()).getChildren().add(vbox);
        scene.getStylesheets().add(

                ClassLoader.getSystemResource("")+"/resources/css/jfoenix-components.css");
        stage.setScene(scene);
        stage.setWidth(900);
        stage.setHeight(900);
        stage.show();
        stage.setTitle("JFX Slider Demo");

    }

    public static void main(String[] args) {
        launch(args);
    }
}
