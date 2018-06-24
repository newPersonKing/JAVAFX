package xml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.text.Text;

/**
 * Created by emcc on 2018/6/23.
 */
public class GripaneController {

    @FXML
    private Text hintText;
    @FXML
    private PasswordField passwordField;

    @FXML
    protected void showPasswordButton(ActionEvent event) {
        hintText.setText("显示密码:" + passwordField.getText());
    }
}
