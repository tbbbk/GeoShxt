package controller;

import entity.HeterogeneousMineral;
import entity.HomogeneousMineral;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;
import org.springframework.core.io.FileSystemResource;
import service.HeterogeneousMineralService;
import service.HomogeneousMineralService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MainController implements Initializable {
    static String basePath = System.getProperty("user.dir"); // 获取当前工作目录的路径
    static String filePath = basePath + "\\src\\main\\resources\\SpringConfig.xml"; // 构建绝对路径
    static FileSystemResource configFile = new FileSystemResource(filePath);
    private static final ApplicationContext context = new FileSystemXmlApplicationContext(configFile.getPath());
//    private static final ApplicationContext context = new ClassPathXmlApplicationContext("SpringConfig.xml");

    private static final HeterogeneousMineralService heterogeneousMineralService = (HeterogeneousMineralService) context.getBean("heterogeneousMineralService");

    private static final HomogeneousMineralService homogeneousMineralService = (HomogeneousMineralService) context.getBean("homogeneousMineralService");

    @FXML
    private Button create;


    @FXML // fx:id="search"
    private TextField search; // Value injected by FXMLLoader

    @FXML
    private Button list;

    @FXML
    void enterSearch(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            List<HomogeneousMineral> homogeneousMinerals = homogeneousMineralService.selectByCondition(new HomogeneousMineral(search.getText()));
            List<HeterogeneousMineral> heterogeneousMinerals = heterogeneousMineralService.selectByCondition(new HeterogeneousMineral(search.getText()));
            if (!homogeneousMinerals.isEmpty()) {
                int id = homogeneousMinerals.get(0).getId();
                MineralListController.mineralNewWindow("HomogeneousMineral", id);
            } else if (!heterogeneousMinerals.isEmpty()) {
                int id = heterogeneousMinerals.get(0).getId();
                MineralListController.mineralNewWindow("HeterogeneousMineral", id);
            } else {
                NewHeterMineralController.show("Failure");
            }
        }
    }

    @FXML
    void create(ActionEvent event) throws Exception {
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
