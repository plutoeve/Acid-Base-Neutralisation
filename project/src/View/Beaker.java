package View;

import javafx.animation.FadeTransition;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Beaker extends BorderPane {

    InputStream fullBeakerStream = new FileInputStream("project/src/Resources/Beaker.png");
    Image fullBeakerImage = new Image(fullBeakerStream);
    ImageView fullBeakerImageView= new ImageView();

    InputStream emptyBeakerStream = new FileInputStream("project/src/Resources/EmptyBeaker.png");
    Image emptyBeakerImage = new Image(emptyBeakerStream);
    ImageView emptyBeakerImageView = new ImageView();



    public Beaker() throws FileNotFoundException {


        fullBeakerImageView.setImage(fullBeakerImage);

        fullBeakerImageView.setFitWidth(170);
        fullBeakerImageView.setFitHeight(170);
        fullBeakerImageView.setPreserveRatio(false);

        fullBeakerImageView.setX(125);
        fullBeakerImageView.setY(-200);

        fullBeakerImageView.setOpacity(0);

        emptyBeakerImageView.setImage(emptyBeakerImage);

        emptyBeakerImageView.setFitWidth(170);
        emptyBeakerImageView.setFitHeight(170);
        emptyBeakerImageView.setPreserveRatio(false);

        emptyBeakerImageView.setX(125);
        emptyBeakerImageView.setY(-200);

        this.getChildren().addAll(emptyBeakerImageView,fullBeakerImageView);
    }

    public void animate(){
        FadeTransition ft = new FadeTransition(Duration.millis(3000), emptyBeakerImageView);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.play();

        FadeTransition ft2 = new FadeTransition(Duration.millis(8000), fullBeakerImageView);
        ft2.setFromValue(0);
        ft2.setToValue(1.0);
        ft2.play();



    }

}
