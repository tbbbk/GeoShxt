/**
 * Sample Skeleton for 'NewHeterMineral.fxml' Controller Class
 */

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
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HeterogeneousMineralService;
import service.HomogeneousMineralService;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class NewHeterMineralController implements Initializable {

    @FXML // fx:id="Dispersion"
    private TextField Dispersion; // Value injected by FXMLLoader

    @FXML // fx:id="Match"
    private TextField Match; // Value injected by FXMLLoader

    @FXML // fx:id="Rotation"
    private TextField Rotation; // Value injected by FXMLLoader

    @FXML // fx:id="back"
    private Button back; // Value injected by FXMLLoader

    @FXML // fx:id="clear"
    private Button clear; // Value injected by FXMLLoader

    @FXML // fx:id="doubleReflection"
    private TextField doubleReflection; // Value injected by FXMLLoader

    @FXML // fx:id="homoheter"
    private TextField homoheter; // Value injected by FXMLLoader

    @FXML // fx:id="internalReflection"
    private TextField internalReflection; // Value injected by FXMLLoader

    @FXML // fx:id="lightSymbol"
    private TextField lightSymbol; // Value injected by FXMLLoader

    @FXML // fx:id="markHardness"
    private TextField markHardness; // Value injected by FXMLLoader

    @FXML // fx:id="mohsHardness"
    private TextField mohsHardness; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private TextField name; // Value injected by FXMLLoader

    @FXML // fx:id="non_HomogeneousViewRotationAngle"
    private TextField non_HomogeneousViewRotationAngle; // Value injected by FXMLLoader

    @FXML // fx:id="non_HomogeneousVisualRotationColor"
    private TextField non_HomogeneousVisualRotationColor; // Value injected by FXMLLoader

    @FXML // fx:id="reflectanceVisualInspectionLevel"
    private TextField reflectanceVisualInspectionLevel; // Value injected by FXMLLoader

    @FXML // fx:id="submit"
    private Button submit; // Value injected by FXMLLoader

    @FXML // fx:id="vickersHardness"
    private TextField vickersHardness; // Value injected by FXMLLoader

    @FXML // fx:id="visualClassificationOfReflectivity"
    private TextField visualClassificationOfReflectivity; // Value injected by FXMLLoader

    /**
     * 返回上一页面
     *
     * @param event
     */
    @FXML
    void back(ActionEvent event) {
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                try {
                    Stage stage = (Stage) this.back.getScene().getWindow();
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

    /**
     * 清空数据
     *
     * @param event
     */
    @FXML
    void clear(ActionEvent event) {
        Thread thread = new Thread(() -> {
            name.clear();
            homoheter.clear();
            reflectanceVisualInspectionLevel.clear();
            visualClassificationOfReflectivity.clear();
            doubleReflection.clear();
            internalReflection.clear();
            markHardness.clear();
            mohsHardness.clear();
            vickersHardness.clear();
            Rotation.clear();
            Match.clear();
            lightSymbol.clear();
            non_HomogeneousViewRotationAngle.clear();
            Dispersion.clear();
            non_HomogeneousVisualRotationColor.clear();
        });
        thread.start();
    }

    /**
     * 检测并添加
     *
     * @param event
     */
    @FXML
    void submit(ActionEvent event) {
        Thread thread = new Thread(() -> {
            String[] arg = {
                    name.getText(),
                    homoheter.getText(),
                    reflectanceVisualInspectionLevel.getText(),
                    visualClassificationOfReflectivity.getText(),
                    doubleReflection.getText(),
                    internalReflection.getText(),
                    markHardness.getText(),
                    mohsHardness.getText(),
                    vickersHardness.getText(),
                    Rotation.getText(),
                    Match.getText(),
                    lightSymbol.getText(),
                    non_HomogeneousViewRotationAngle.getText(),
                    Dispersion.getText(),
                    non_HomogeneousVisualRotationColor.getText()
            };
            if (arg[0].equals("")) {
                show("IncompleteAlert");
            } else {
                HeterogeneousMineral heterogeneousMineral = new HeterogeneousMineral(arg[0], arg[1], arg[2], arg[3], arg[4], arg[5], arg[6], arg[7], arg[8], arg[9], arg[10], arg[11], arg[12], arg[13], arg[14]);
                ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringConfig.xml");
                HeterogeneousMineralService heterogeneousMineralService = (HeterogeneousMineralService) context.getBean("heterogeneousMineralService");
                int result = 0;
                try {
                    result = heterogeneousMineralService.insert(heterogeneousMineral);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (result != 1) {
                    show("Failure");
                    this.clear(event);
                } else {
                    show("Success");
                    this.clear(event);
                }
            }
        });
        thread.start();
    }

    public void show(String s) {
        Platform.runLater(() -> {
            try {
                AnchorPane root = FXMLLoader.load(getClass().getResource("/ui/" + s + ".fxml"));
                Stage stage = new Stage();
                stage.setScene(new Scene(root, 200, 200));
                stage.setResizable(false);
                stage.show();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        });
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
