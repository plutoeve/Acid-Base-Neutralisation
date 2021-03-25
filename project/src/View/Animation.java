package View;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class Animation extends GridPane {

    BlueFlaskRotateAnimation anim1 = new BlueFlaskRotateAnimation();
    RedFlaskRotateAnimation anim2 = new RedFlaskRotateAnimation();

    public Animation() throws FileNotFoundException {
        this.getChildren().addAll(anim1,anim2);
        anim1.getFlask().setLayoutX(500);
        anim2.getFlask().setLayoutX(10);

        anim1.getFlask().setLayoutY(-300);
        anim2.getFlask().setLayoutY(-375);

        anim1.animate();
        anim2.animate();

    }


}
