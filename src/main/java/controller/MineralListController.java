/**
 * Sample Skeleton for 'MineralList.fxml' Controller Class
 */

package controller;

import entity.HeterogeneousMineral;
import entity.HomogeneousMineral;
import javafx.application.Platform;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import service.HeterogeneousMineralService;
import service.HomogeneousMineralService;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MineralListController implements Initializable {
    private static final ApplicationContext context = new ClassPathXmlApplicationContext("classpath:SpringConfig.xml");

    private static final HeterogeneousMineralService heterogeneousMineralService = (HeterogeneousMineralService) context.getBean("heterogeneousMineralService");

    private static final HomogeneousMineralService homogeneousMineralService = (HomogeneousMineralService) context.getBean("homogeneousMineralService");

    public static Object[] pattern = new Object[2];

    @FXML // fx:id="Dispersion"
    private TextField Dispersion; // Value injected by FXMLLoader

    @FXML // fx:id="Match"
    private TextField Match; // Value injected by FXMLLoader

    @FXML // fx:id="Rotation"
    private TextField Rotation; // Value injected by FXMLLoader

    @FXML // fx:id="choice"
    private ChoiceBox<?> choice; // Value injected by FXMLLoader

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

    @FXML // fx:id="mineralList"
    private AnchorPane mineralList; // Value injected by FXMLLoader

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

    @FXML // fx:id="reset"
    private Button reset; // Value injected by FXMLLoader

    @FXML // fx:id="confirm"
    private Button confirm; // Value injected by FXMLLoader

    @FXML // fx:id="back"
    private Button back; // Value injected by FXMLLoader

    @FXML // fx:id="resultHeteroList"
    private TableView<HeterogeneousMineral> resultHeteroList; // Value injected by FXMLLoader

    @FXML // fx:id="resultHomoList"
    private TableView<HomogeneousMineral> resultHomoList; // Value injected by FXMLLoader

    @FXML
    void back(ActionEvent event) {
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
    void confirm(ActionEvent event) {
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                String h2 = (String) choice.getValue();
                if (h2.equals("非均质")) {
                    HeterogeneousMineral heterogeneousMineral = new HeterogeneousMineral();
                    heterogeneousMineral.setName(name.getText().equals("") ? null : name.getText());
                    heterogeneousMineral.setHomoOrHeter(homoheter.getText().equals("") ? null : homoheter.getText());
                    heterogeneousMineral.setReflectanceVisualInspectionLevel(reflectanceVisualInspectionLevel.getText().equals("") ? null : reflectanceVisualInspectionLevel.getText());
                    heterogeneousMineral.setVisualClassificationOfReflectivity(visualClassificationOfReflectivity.getText().equals("") ? null : visualClassificationOfReflectivity.getText());
                    heterogeneousMineral.setDoubleReflection(doubleReflection.getText().equals("") ? null : doubleReflection.getText());
                    heterogeneousMineral.setInternalReflection(internalReflection.getText().equals("") ? null : internalReflection.getText());
                    heterogeneousMineral.setMarkHardness(markHardness.getText().equals("") ? null : markHardness.getText());
                    heterogeneousMineral.setMohsHardness(mohsHardness.getText().equals("") ? null : mohsHardness.getText());
                    heterogeneousMineral.setVickersHardness(vickersHardness.getText().equals("") ? null : vickersHardness.getText());
                    heterogeneousMineral.setRotation(Rotation.getText().equals("") ? null : Rotation.getText());
                    heterogeneousMineral.setMatch(Match.getText().equals("") ? null : Match.getText());
                    heterogeneousMineral.setLightSymbol(lightSymbol.getText().equals("") ? null : lightSymbol.getText());
                    heterogeneousMineral.setNon_HomogeneousViewRotationAngle(non_HomogeneousViewRotationAngle.getText().equals("") ? null : non_HomogeneousViewRotationAngle.getText());
                    heterogeneousMineral.setDispersion(Dispersion.getText().equals("") ? null : Dispersion.getText());
                    heterogeneousMineral.setNon_HomogeneousVisualRotationColor(non_HomogeneousVisualRotationColor.getText().equals("") ? null : non_HomogeneousVisualRotationColor.getText());
                    //开始查询
                    List<HeterogeneousMineral> heterogeneousMineralList = heterogeneousMineralService.selectByCondition(heterogeneousMineral);
                    //添加数据 绑定数据
                    resultHeteroList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
                    resultHeteroList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
                    ObservableList<HeterogeneousMineral> data = FXCollections.observableArrayList();
                    data.addAll(heterogeneousMineralList);
                    resultHeteroList.setItems(data);
                    //*********************************
                    resultHeteroList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    resultHeteroList.getSelectionModel().getSelectedCells().addListener(new InvalidationListener() {
                        @Override
                        public void invalidated(Observable observable) {
                            TablePosition tablePosition = ((ObservableList<TablePosition>) observable).get(0);
                            //获取选择ID
                            Integer id = resultHeteroList.getItems().get(tablePosition.getRow()).getId();
                            System.out.println(id);
                            //获取点击对象
                            System.out.println(heterogeneousMineralService.selectByCondition(new HeterogeneousMineral(id)).get(0));
                            mineralNewWindow("HeterogeneousMineral", id);
                        }
                    });
                } else if (h2.equals("均质")) {
                    HomogeneousMineral homogeneousMineral = new HomogeneousMineral();
                    homogeneousMineral.setName(name.getText().equals("") ? null : name.getText());
                    homogeneousMineral.setHeterOrHomo(homoheter.getText().equals("") ? null : homoheter.getText());
                    homogeneousMineral.setReflectanceVisualInspectionLevel(reflectanceVisualInspectionLevel.getText().equals("") ? null : reflectanceVisualInspectionLevel.getText());
                    homogeneousMineral.setVisualClassificationOfReflectivity(visualClassificationOfReflectivity.getText().equals("") ? null : visualClassificationOfReflectivity.getText());
                    homogeneousMineral.setDoubleReflection(doubleReflection.getText().equals("") ? null : doubleReflection.getText());
                    homogeneousMineral.setInternalReflection(internalReflection.getText().equals("") ? null : internalReflection.getText());
                    homogeneousMineral.setMarkHardness(markHardness.getText().equals("") ? null : markHardness.getText());
                    homogeneousMineral.setMohsHardness(mohsHardness.getText().equals("") ? null : mohsHardness.getText());
                    homogeneousMineral.setVickersHardness(vickersHardness.getText().equals("") ? null : vickersHardness.getText());
                    homogeneousMineral.setReflectionRotationAngle(reflectionRotationAngle.getText().equals("") ? null : reflectionRotationAngle.getText());
                    homogeneousMineral.setDispersion(Dispersion.getText().equals("") ? null : Dispersion.getText());
                    //开始查询
                    List<HomogeneousMineral> homogeneousMineralList = homogeneousMineralService.selectByCondition(homogeneousMineral);
                    //添加数据 绑定数据
                    resultHomoList.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
                    resultHomoList.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
                    ObservableList<HomogeneousMineral> data = FXCollections.observableArrayList();
                    data.addAll(homogeneousMineralList);
                    resultHomoList.setItems(data);
                    //打开详情页
                    resultHomoList.getSelectionModel().setSelectionMode(SelectionMode.SINGLE);
                    resultHomoList.getSelectionModel().getSelectedCells().addListener(new InvalidationListener() {
                        @Override
                        public void invalidated(Observable observable) {
                            TablePosition tablePosition = ((ObservableList<TablePosition>) observable).get(0);
                            //获取选择ID
                            Integer id = resultHomoList.getItems().get(tablePosition.getRow()).getId();
                            System.out.println(id);
                            //获取点击对象
                            System.out.println(homogeneousMineralService.selectByCondition(new HomogeneousMineral(id)).get(0));
                            mineralNewWindow("HomogeneousMineral", id);
                        }
                    });
                }
            });
        });
        thread.start();
    }

    @FXML
    void reset(ActionEvent event) {
        Platform.runLater(() -> {
            name.clear();
            homoheter.clear();
            reflectanceVisualInspectionLevel.clear();
            visualClassificationOfReflectivity.clear();
            doubleReflection.clear();
            internalReflection.clear();
            markHardness.clear();
            mohsHardness.clear();
            vickersHardness.clear();
            reflectionRotationAngle.clear();
            Dispersion.clear();
            Rotation.clear();
            Match.clear();
            lightSymbol.clear();
            non_HomogeneousViewRotationAngle.clear();
            non_HomogeneousVisualRotationColor.clear();
        });
    }

    /**
     * 显示矿物详情
     */
    public void mineralNewWindow(String mineralDetails, int id) {
        Object mineral;
        if (mineralDetails.equals("HeterogeneousMineral")) {
            mineral = heterogeneousMineralService.selectByCondition(new HeterogeneousMineral(id)).get(0);
        } else if (mineralDetails.equals("HomogeneousMineral")) {
            mineral = homogeneousMineralService.selectByCondition(new HomogeneousMineral(id)).get(0);
        } else {
            mineral = null;
        }
        Thread thread = new Thread(() -> {
            Platform.runLater(() -> {
                try {
                    pattern[0] = mineral;
                    pattern[1] = mineralDetails;
                    AnchorPane root = FXMLLoader.load(getClass().getResource("/ui/MineralDetails.fxml"));
                    Stage stage = new Stage();
                    stage.setScene(new Scene(root, 701, 446));
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
        //初始化
        Platform.runLater(() -> {
            name.setVisible(false);
            homoheter.setVisible(false);
            reflectanceVisualInspectionLevel.setVisible(false);
            visualClassificationOfReflectivity.setVisible(false);
            doubleReflection.setVisible(false);
            internalReflection.setVisible(false);
            markHardness.setVisible(false);
            mohsHardness.setVisible(false);
            vickersHardness.setVisible(false);
            reflectionRotationAngle.setVisible(false);
            Dispersion.setVisible(false);
            Rotation.setVisible(false);
            Match.setVisible(false);
            lightSymbol.setVisible(false);
            non_HomogeneousViewRotationAngle.setVisible(false);
            non_HomogeneousVisualRotationColor.setVisible(false);
        });
        //多选框切换操作
        choice.getSelectionModel().selectedItemProperty().addListener(new ChangeListener() {
            public void changed(ObservableValue observable, Object oldValue, Object newValue) {
                Thread thread = new Thread(() -> {
                    Platform.runLater(() -> {
                        if (newValue.equals("均质")) {
                            resultHomoList.setVisible(true);
                            resultHeteroList.setVisible(false);
                            name.setVisible(true);
                            homoheter.setVisible(true);
                            reflectanceVisualInspectionLevel.setVisible(true);
                            visualClassificationOfReflectivity.setVisible(true);
                            doubleReflection.setVisible(true);
                            internalReflection.setVisible(true);
                            markHardness.setVisible(true);
                            mohsHardness.setVisible(true);
                            vickersHardness.setVisible(true);
                            reflectionRotationAngle.setVisible(true);
                            Dispersion.setVisible(true);
                            Rotation.setVisible(false);
                            Match.setVisible(false);
                            lightSymbol.setVisible(false);
                            non_HomogeneousViewRotationAngle.setVisible(false);
                            non_HomogeneousVisualRotationColor.setVisible(false);
                        } else if (newValue.equals("非均质")) {
                            resultHomoList.setVisible(false);
                            resultHeteroList.setVisible(true);
                            name.setVisible(true);
                            homoheter.setVisible(true);
                            reflectanceVisualInspectionLevel.setVisible(true);
                            visualClassificationOfReflectivity.setVisible(true);
                            doubleReflection.setVisible(true);
                            internalReflection.setVisible(true);
                            markHardness.setVisible(true);
                            mohsHardness.setVisible(true);
                            vickersHardness.setVisible(true);
                            reflectionRotationAngle.setVisible(false);
                            Dispersion.setVisible(true);
                            Rotation.setVisible(true);
                            Match.setVisible(true);
                            lightSymbol.setVisible(true);
                            non_HomogeneousViewRotationAngle.setVisible(true);
                            non_HomogeneousVisualRotationColor.setVisible(true);
                        }
                    });
                });
                thread.start();
            }
        });
    }
}
