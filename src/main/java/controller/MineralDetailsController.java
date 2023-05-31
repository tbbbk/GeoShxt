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
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.support.PagedListHolder;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MineralDetailsController implements Initializable {
    public static String mineralName;

    @FXML // fx:id="Dispersion"
    private TextField Dispersion; // Value injected by FXMLLoader

    @FXML // fx:id="Match"
    private TextField Match; // Value injected by FXMLLoader

    @FXML // fx:id="Rotation"
    private TextField Rotation; // Value injected by FXMLLoader

    @FXML // fx:id="doubleReflection"
    private TextField doubleReflection; // Value injected by FXMLLoader

    @FXML // fx:id="heter"
    private VBox heter; // Value injected by FXMLLoader

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

    @FXML // fx:id="reflectionRotationAngle"
    private TextField reflectionRotationAngle; // Value injected by FXMLLoader

    @FXML // fx:id="vickersHardness"
    private TextField vickersHardness; // Value injected by FXMLLoader

    @FXML // fx:id="visualClassificationOfReflectivity"
    private TextField visualClassificationOfReflectivity; // Value injected by FXMLLoader

    @FXML // fx:id="info"
    private TextArea info; // Value injected by FXMLLoader

    @FXML // fx:id="play"
    private Button play; // Value injected by FXMLLoader

    @FXML // fx:id="showImg"
    private Button showImg; // Value injected by FXMLLoader
    @FXML
    void playVideo(ActionEvent event) {
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                try {
                    AnchorPane root = FXMLLoader.load(MineralDetailsController.class.getResource("/ui/Video.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root, 601, 455));
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        thread.start();
    }

    @FXML
    void showImage(ActionEvent event) {
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                try {
                    AnchorPane root = FXMLLoader.load(MineralDetailsController.class.getResource("/ui/Image.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root, 600, 400));
                    stage.setResizable(false);
                    stage.show();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            });
        });
        thread.start();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Platform.runLater(() -> {
            String type = (String) MineralListController.pattern[1];
            if (type.equals("HeterogeneousMineral")) {
                HeterogeneousMineral heterogeneousMineral = (HeterogeneousMineral) MineralListController.pattern[0];
                name.setText(heterogeneousMineral.getName());
                mineralName = heterogeneousMineral.getName();
                homoheter.setText(heterogeneousMineral.getHomoOrHeter());
                reflectanceVisualInspectionLevel.setText(heterogeneousMineral.getReflectanceVisualInspectionLevel());
                visualClassificationOfReflectivity.setText(heterogeneousMineral.getVisualClassificationOfReflectivity());
                doubleReflection.setText(heterogeneousMineral.getDoubleReflection());
                internalReflection.setText(heterogeneousMineral.getInternalReflection());
                markHardness.setText(heterogeneousMineral.getMarkHardness());
                mohsHardness.setText(heterogeneousMineral.getMohsHardness());
                vickersHardness.setText(heterogeneousMineral.getVickersHardness());
                Rotation.setText(heterogeneousMineral.getRotation());
                Match.setText(heterogeneousMineral.getMatch());
                lightSymbol.setText(heterogeneousMineral.getLightSymbol());
                non_HomogeneousViewRotationAngle.setText(heterogeneousMineral.getNon_HomogeneousViewRotationAngle());
                Dispersion.setText(heterogeneousMineral.getDispersion());
                non_HomogeneousVisualRotationColor.setText(heterogeneousMineral.getNon_HomogeneousVisualRotationColor());
                info.setText(heterogeneousMineral.getInfo());
                System.out.println(heterogeneousMineral + "fuck");
            } else if (type.equals("HomogeneousMineral")) {
                HomogeneousMineral homogeneousMineral = (HomogeneousMineral) MineralListController.pattern[0];
                name.setText(homogeneousMineral.getName());
                mineralName = homogeneousMineral.getName();
                homoheter.setText(homogeneousMineral.getHeterOrHomo());
                reflectanceVisualInspectionLevel.setText(homogeneousMineral.getReflectanceVisualInspectionLevel());
                visualClassificationOfReflectivity.setText(homogeneousMineral.getVisualClassificationOfReflectivity());
                doubleReflection.setText(homogeneousMineral.getDoubleReflection());
                internalReflection.setText(homogeneousMineral.getInternalReflection());
                markHardness.setText(homogeneousMineral.getMarkHardness());
                mohsHardness.setText(homogeneousMineral.getMohsHardness());
                vickersHardness.setText(homogeneousMineral.getVickersHardness());
                reflectionRotationAngle.setText(homogeneousMineral.getReflectionRotationAngle());
                Dispersion.setText(homogeneousMineral.getDispersion());
                info.setText(homogeneousMineral.getInfo());
                System.out.println(homogeneousMineral + "fuck");
            }
        });
    }
}
