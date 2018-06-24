package uicomponents;


import javafx.fxml.FXML;
import javafx.scene.layout.StackPane;
import view.TimePicker.JFXDatePicker;
import view.TimePicker.JFXTimePicker;

import javax.annotation.PostConstruct;

public class PickersController {

    @FXML
    private StackPane root;
    @FXML
    private JFXDatePicker dateOverlay;
    @FXML
    private JFXTimePicker timeOverlay;

    @PostConstruct
    public void init() {
        dateOverlay.setDialogParent(root);
        timeOverlay.setDialogParent(root);
    }
}
