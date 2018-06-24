package uicomponents;

import javafx.fxml.FXML;
import view.Text.JFXPasswordField;
import view.Text.JFXTextArea;
import view.Text.JFXTextField;

import javax.annotation.PostConstruct;

public class TextFieldController {

    @FXML
    private JFXTextField validatedText;
    @FXML
    private JFXPasswordField validatedPassowrd;
    @FXML
    private JFXTextArea jfxTextArea;

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {
        validatedText.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatedText.validate();
            }
        });
        validatedPassowrd.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                validatedPassowrd.validate();
            }
        });
        jfxTextArea.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                jfxTextArea.validate();
            }
        });
    }

}
