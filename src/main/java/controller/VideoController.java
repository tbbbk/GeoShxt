package controller;

import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Slider;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class VideoController implements Initializable {
    String mineralName = MineralDetailsController.mineralName;
    int idx;
    MediaPlayer mediaPlayer;

    @FXML // fx:id="media"
    private MediaView media; // Value injected by FXMLLoader

    @FXML // fx:id="pauseVideo"
    private Button pauseVideo; // Value injected by FXMLLoader

    @FXML // fx:id="playVideo"
    private Button playVideo; // Value injected by FXMLLoader

    @FXML // fx:id="slider"
    private Slider slider; // Value injected by FXMLLoader

    @FXML // fx:id="next"
    private Button next; // Value injected by FXMLLoader

    @FXML // fx:id="name"
    private Text name; // Value injected by FXMLLoader

    @FXML
    void playNext(ActionEvent event) {
        mediaPlayer.stop();
        if (idx == 4) { // 单偏光镜下视频 @TODO
            File file = new File("src/main/resources/video/happycat.mp4");
            Media m = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(m);
            media.setMediaPlayer(mediaPlayer);
            name.setText(mineralName + "单偏光镜下视频");
            idx = 5;
        } else if (idx == 5) { //正交光镜下视频 @TODO
            File file = new File("src/main/resources/video/bananacat.mp4");
            Media m = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(m);
            media.setMediaPlayer(mediaPlayer);
            name.setText(mineralName + "正交光镜下视频");
            idx = 4;
        }
    }

    @FXML
    void playVideo(MouseEvent event) {
        if (mediaPlayer.getStatus() != MediaPlayer.Status.PLAYING) {
            mediaPlayer.play();
        }
        Stage stage = (Stage) pauseVideo.getScene().getWindow();
        stage.setOnCloseRequest(e -> {
            e.consume(); // 阻止默认的关闭操作
            mediaPlayer.stop();
            stage.close();
        });
    }

    @FXML
    void pauseVideo(MouseEvent event) {
        if (mediaPlayer.getStatus() == MediaPlayer.Status.PLAYING) {
            mediaPlayer.pause();
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        File file = new File("src/main/resources/video/happycat.mp4");
        Media m = new Media(file.toURI().toString());
        mediaPlayer = new MediaPlayer(m);
        mediaPlayer.setOnEndOfMedia(() -> {
            mediaPlayer.seek(mediaPlayer.getStartTime()); // 将播放头设置回起始位置
            mediaPlayer.play(); // 重新开始播放
        });
        media.setMediaPlayer(mediaPlayer);

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (slider.isValueChanging()) {
                mediaPlayer.seek(mediaPlayer.getMedia().getDuration().multiply(newValue.doubleValue() / 100.0));
            }
        });

        // 监听媒体播放的进度，更新进度条的值
        mediaPlayer.currentTimeProperty().addListener(new InvalidationListener() {
            @Override
            public void invalidated(Observable observable) {
                if (mediaPlayer.getTotalDuration().toSeconds() > 0) {
                    double newValue = mediaPlayer.getCurrentTime().toSeconds() / mediaPlayer.getTotalDuration().toSeconds() * 100.0;
                    slider.setValue(newValue);
                }
            }
        });
        idx = 4;
        name.setText("单偏光镜下视频");
    }
}
