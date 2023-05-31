package controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class CreateChoiceController {

    @FXML
    private Button back;

    @FXML
    private ComboBox<?> choice;

    @FXML
    private Button confirm;

    @FXML
    void back2Home(ActionEvent event) {
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                try {
                    Stage stage = (Stage) this.back.getScene().getWindow();
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/Main.fxml"));
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
    void confirm(MouseEvent event) {
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                String result = (String) choice.getValue();
                if (result.equals("均质")) {
                    Thread thread_1 = new Thread(() -> {
                        Platform.runLater(() -> {
                            try {
                                Stage stage = (Stage) this.back.getScene().getWindow();
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/NewHomoMineral.fxml"));
                                Pane root = fxmlLoader.load();
                                stage.setScene(new Scene(root, 600, 500));
                                stage.show();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    });
                    thread_1.start();
                } else if (result.equals("非均质")) {
                    Thread thread_2 = new Thread(() -> {
                        Platform.runLater(() -> {
                            try {
                                Stage stage = (Stage) this.back.getScene().getWindow();
                                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/NewHeterMineral.fxml"));
                                Pane root = fxmlLoader.load();
                                stage.setScene(new Scene(root, 600, 600));
                                stage.show();
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        });
                    });
                    thread_2.start();
                }
            });
        });
        thread.start();
    }

}
