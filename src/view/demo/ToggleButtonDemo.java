package view.demo;


import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ToggleButton;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.toggle.JFXToggleButton;
import view.toggle.JFXToggleNode;

public class ToggleButtonDemo extends Application {

    @Override
    public void start(Stage stage) throws Exception {

        final VBox pane = new VBox();
        pane.setSpacing(30);
        pane.setStyle("-fx-background-color:#EEE; -fx-padding: 40;");

        ToggleButton button = new ToggleButton("JavaFx Toggle");
        pane.getChildren().add(button);

        JFXToggleButton toggleButton = new JFXToggleButton();
        toggleButton.setText("New Skin");
        pane.getChildren().add(toggleButton);

        JFXToggleNode node = new JFXToggleNode();
      /*  final GlyphIcon heartIcon = GlyphsBuilder.create(FontAwesomeIconView.class)
            .glyph(FontAwesomeIcon.HEART)
            .build();
        heartIcon.setStyle("-fx-padding: 10");
        node.setGraphic(heartIcon);*/

        pane.getChildren().add(node);


        final Scene scene = new Scene(pane, 600, 400, Color.valueOf("#EEE"));
        stage.setTitle("JFX Toggle Button Demo ");
        scene.getStylesheets()
            .add(

                    ClassLoader.getSystemResource("")+"/resources/css/jfoenix-components.css");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();


    }

    public static void main(String[] args) {
        launch(args);
    }

}
