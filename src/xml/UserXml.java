package xml;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by emcc on 2018/6/23.
 */
public class UserXml extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root= FXMLLoader.load(getClass().getResource("Gridpane.fxml"));
        Scene scene = new Scene(root, 300, 275);
        primaryStage.setTitle("使用FXML");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
