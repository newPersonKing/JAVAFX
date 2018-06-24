package view;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * Created by emcc on 2018/6/23.
 */
public class HelloJavaFX extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        Button btn=new Button();
        btn.setText("您好啊，世界");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("你好，世界!");
            }
        });
        /*容器*/
        StackPane stackPane=new StackPane();
        stackPane.getChildren().add(btn);
        /*界面*/
        Scene scene=new Scene(stackPane,300,250);
        primaryStage.setTitle("hello world");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
