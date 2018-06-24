package view.button;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

/**
 * Created by emcc on 2018/6/24.
 */
public class ButtonMain extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FlowPane main = new FlowPane();
        main.setVgap(20);
        main.setHgap(20);

        main.getChildren().add(new Button("Java Button"));
        JFXButton jfoenixButton = new JFXButton("JFoenix Button");
        main.getChildren().add(jfoenixButton);

        JFXButton button = new JFXButton("RAISED BUTTON");
        button.getStyleClass().add("button-raised");
        main.getChildren().add(button);

        JFXButton button1 = new JFXButton("DISABLED");
        button1.setDisable(true);
        main.getChildren().add(button1);

        StackPane pane = new StackPane();
        pane.getChildren().add(main);
        StackPane.setMargin(main, new Insets(100));
        pane.setStyle("-fx-background-color:WHITE");

        final Scene scene = new Scene(pane, 800, 200);
        /*这里加载所有的样式*/
        scene.getStylesheets().add(ClassLoader.getSystemResource("")+"/resources/css/jfoenix-components.css");
        primaryStage.setTitle("JFX Button Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
