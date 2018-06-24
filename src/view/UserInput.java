package view;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Created by emcc on 2018/6/23.
 */
public class UserInput extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        /*网格布局*/
        GridPane gridPane=new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        /*水平间距*/
        gridPane.setHgap(10);
        /*垂直间距*/
         gridPane.setVgap(10);
         gridPane.setPadding(new Insets(25,25,25,25));

         /*新建场景*/
        Scene scene=new Scene(gridPane,300,275);
        primaryStage.setScene(scene);

        /*添加标题*/
        Text scenetitle=new Text("welcome");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        gridPane.add(scenetitle, 0, 0, 2, 1);

        //添加标签及文本框
        Label userName = new Label("用户名:");
        gridPane.add(userName, 0, 1);

        TextField userTextField = new TextField();
        gridPane.add(userTextField, 1, 1);
        //添加标签及密码框
        Label pw = new Label("密码:");
        gridPane.add(pw, 0, 2);

        PasswordField pwBox = new PasswordField();
        gridPane.add(pwBox, 1, 2);
        //添加提交按钮
        Button btn = new Button("登录");
        HBox hbBtn = new HBox(5);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        gridPane.add(hbBtn, 1, 4);
        //提交文本提示
        final Text actiontarget = new Text();
        gridPane.add(actiontarget, 1, 6);
        btn.setOnAction(event -> {
            actiontarget.setFill(Color.FIREBRICK);
            actiontarget.setText("已经登录");
        });

        primaryStage.setTitle("JavaFX Welcome");
        primaryStage.show();

    }
}
