package View;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class Animations {

    GridPane pane =  new GridPane();
    BlueFlaskRotateAnimation blueAnim = new BlueFlaskRotateAnimation();
    RedFlaskRotateAnimation redAnim = new RedFlaskRotateAnimation();

    public Animations() throws FileNotFoundException {
        pane.getChildren().addAll(blueAnim,redAnim);
        blueAnim.getFlask().setLayoutX(300);
        redAnim.getFlask().setLayoutX(10);

        blueAnim.getFlask().setLayoutY(-300);
        redAnim.getFlask().setLayoutY(-300);

        blueAnim.animate();
        redAnim.animate();

    }
    public static void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }

}
