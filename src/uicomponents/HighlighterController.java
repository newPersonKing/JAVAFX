package uicomponents;


import javafx.fxml.FXML;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import view.JFXHighlighter;
import view.JFXNodeUtils;
import view.Text.JFXTextField;
import view.popu.JFXDepthManager;

import javax.annotation.PostConstruct;


public class HighlighterController {

    @FXML
    private JFXTextField searchField;
    @FXML
    private Pane content;

    private JFXHighlighter highlighter = new JFXHighlighter();

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {
        JFXDepthManager.setDepth(content, 1);
        JFXNodeUtils.addDelayedEventHandler(searchField, Duration.millis(400),
            KeyEvent.KEY_PRESSED, event -> highlighter.highlight(content, searchField.getText()));
    }
}
