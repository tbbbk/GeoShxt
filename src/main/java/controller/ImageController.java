package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.Media;
import javafx.scene.text.Text;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class ImageController implements Initializable {
    int idx = 1;
    String mineralName = MineralDetailsController.mineralName;

    @FXML // fx:id="image"
    private ImageView image; // Value injected by FXMLLoader

    @FXML // fx:id="img1"
    private Button img1; // Value injected by FXMLLoader

    @FXML // fx:id="img2"
    private Button img2; // Value injected by FXMLLoader

    @FXML // fx:id="img3"
    private Button img3; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private Text name; // Value injected by FXMLLoader

    @FXML
    void changeImg(ActionEvent event) {
        String buttonName = ((Button)event.getSource()).getId();
        if (buttonName.equals("img1")) { // 照手标本图片
            name.setText(mineralName + "照手标本图片");
            File file = new File("src/main/resources/image/main_1.jpg");
            image.setImage(new Image(file.toURI().toString()));
        } else if (buttonName.equals("img2")) { // 单偏光镜下图片
            name.setText(mineralName + "单偏光镜下图片");
            File file = new File("src/main/resources/image/main_2.jpg");
            image.setImage(new Image(file.toURI().toString()));
        } else if (buttonName.equals("img3")) { // 正交光镜下图片
            name.setText(mineralName + "正交光镜下图片");
            File file = new File("src/main/resources/image/main_3.jpg");
            image.setImage(new Image(file.toURI().toString()));
        }
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
