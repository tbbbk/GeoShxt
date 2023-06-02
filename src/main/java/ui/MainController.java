package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.media.Media;

import java.io.File;

public class MainController extends Application {
    public static void main(String[] args) {
        Application.launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        String basePath = System.getProperty("user.dir"); // 获取当前工作目录的路径
        String filePath = basePath + "\\src\\main\\resources\\ui\\Main.fxml"; // 构建绝对路径
        FXMLLoader fxmlLoader = new FXMLLoader((new File(filePath)).toURI().toURL());
//        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/ui/Main.fxml"));
        Pane root = fxmlLoader.load();
        Scene scene = new Scene(root, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
