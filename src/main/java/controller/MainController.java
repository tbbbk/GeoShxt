package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button create;

    @FXML
    private Button list;

    @FXML
    void create(ActionEvent event)  throws Exception{
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                try {
                    Stage stage = (Stage) this.create.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/CreateChoice.fxml"));
                    Pane root = fxmlLoader.load();
                    stage.setScene(new Scene(root, 500, 500));
                    stage.show();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        });
        thread.start();
    }

    @FXML
    void list(ActionEvent event) {
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                try {
                Stage stage = (Stage) this.create.getScene().getWindow();
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/MineralList.fxml"));
                Pane root = fxmlLoader.load();
                stage.setScene(new Scene(root, 646, 467));
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            });
        });
        thread.start();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
