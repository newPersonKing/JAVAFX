package uicomponents;


import javafx.fxml.FXML;
import view.button.JFXButton;
import view.list.JFXNodesList;


public class NodesListController {

    @FXML
    JFXNodesList nodesList;

    @FXML
    JFXButton newButton;
    @FXML
    JFXButton fileButton;
    @FXML
    JFXButton commentButton;
    @FXML
    JFXButton filterButton;

    @FXML
    public void onNewFile() {
        System.out.println("New File");
        //Close list
        nodesList.animateList(false);
    }

    @FXML
    public void onNewComment() {
        System.out.println("New Comment");
        //Close list
        nodesList.animateList(false);
    }

    @FXML
    public void onNewFilter() {
        System.out.println("New Filter");
        //Close list
        nodesList.animateList(false);
    }

}
