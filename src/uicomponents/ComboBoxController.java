package uicomponents;



import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.util.StringConverter;
import view.Base.ValidationFacade;
import view.combox.JFXComboBox;

import javax.annotation.PostConstruct;

public class ComboBoxController {

    @FXML
    private JFXComboBox<Label> jfxComboBox;
    @FXML
    private JFXComboBox<Label> jfxEditableComboBox;

    /**
     * init fxml when loaded.
     */
    @PostConstruct
    public void init() {

        jfxComboBox.focusedProperty().addListener((o, oldVal, newVal) -> {
            if (!newVal) {
                ValidationFacade.validate(jfxComboBox);
            }
        });

        ChangeListener<? super Boolean> comboBoxFocus = (o, oldVal, newVal) -> {
            if (!newVal) {
                ValidationFacade.validate(jfxEditableComboBox);
            }
        };
        jfxEditableComboBox.focusedProperty().addListener(comboBoxFocus);
        jfxEditableComboBox.getEditor().focusedProperty().addListener(comboBoxFocus);
        jfxEditableComboBox.setConverter(new StringConverter<Label>() {
            @Override
            public String toString(Label object) {
                return object==null? "" : object.getText();
            }
            @Override
            public Label fromString(String string) {
                return string == null || string.isEmpty() ? null : new Label(string);
            }
        });
    }

}
