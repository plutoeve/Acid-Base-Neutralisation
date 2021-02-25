package View;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

public class Animation extends GridPane {
    public Animation() {
        Circle cir = new Circle(2, 2, 2, Color.RED);

        // change circle.translateXProperty from it's current value to 200
        KeyValue keyValue = new KeyValue(cir.translateXProperty(), 200);

        // over the course of 5 seconds
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(10), keyValue);
        Timeline timeline = new Timeline(keyFrame);

        timeline.play();
    }


}
