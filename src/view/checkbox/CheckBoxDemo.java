package view.checkbox;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by emcc on 2018/6/24.
 */
public class CheckBoxDemo extends Application {
    private static int step = 1;
    @Override
    public void start(Stage stage) throws Exception {
        FlowPane main = new FlowPane();
        main.setVgap(20);
        main.setHgap(20);

        CheckBox cb = new CheckBox("checkbox");
        JFXCheckBox jfxCheckBox = new JFXCheckBox("JFX checkbox");
        JFXCheckBox customJFXCheckBox = new JFXCheckBox("Custom JFX checkbox");
        customJFXCheckBox.getStyleClass().add("custom-jfx-check-box");

        main.getChildren().add(cb);
        main.getChildren().add(jfxCheckBox);
        main.getChildren().add(customJFXCheckBox);

        StackPane pane = new StackPane();
        pane.getChildren().add(main);
        StackPane.setMargin(main, new Insets(100));
        pane.setStyle("-fx-background-color:WHITE");

        final Scene scene = new Scene(pane, 600, 200);
        scene.getStylesheets().add(ClassLoader.getSystemResource("")+"/resources/css/jfoenix-components.css");
        stage.setTitle("JFX checkbox Demo ");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
}
