package uicomponents;

import javafx.fxml.FXML;
import javafx.scene.control.ScrollPane;
import javafx.scene.paint.Color;
import view.button.JFXButton;
import view.list.JFXListView;
import view.scroll.JFXScrollPane;
import view.svg.SVGGlyph;

import javax.annotation.PostConstruct;

public class ScrollPaneController {

    @FXML
    private JFXListView<String> contentList;
    @FXML
    private JFXButton backButton;
    @FXML
    private JFXScrollPane scroll;

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {

        for (int i = 0; i < 100; i++) {
            contentList.getItems().add("Item " + i);
        }
        contentList.setMaxHeight(3400);

        JFXScrollPane.smoothScrolling((ScrollPane) scroll.getChildren().get(0));

        SVGGlyph arrow = new SVGGlyph(0,
            "FULLSCREEN",
            "M402.746 877.254l-320-320c-24.994-24.992-24.994-65.516 0-90.51l320-320c24.994-24.992 65.516-24.992 90.51 0 24.994 24.994 "
            + "24.994 65.516 0 90.51l-210.746 210.746h613.49c35.346 0 64 28.654 64 64s-28.654 64-64 64h-613.49l210.746 210.746c12.496 "
            + "12.496 18.744 28.876 18.744 45.254s-6.248 32.758-18.744 45.254c-24.994 24.994-65.516 24.994-90.51 0z",
            Color.WHITE);
        arrow.setSize(20, 16);
        backButton.setGraphic(arrow);
        backButton.setRipplerFill(Color.WHITE);
    }
}


