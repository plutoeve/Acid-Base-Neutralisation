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
    public GridPane pane =  new GridPane();
    public BlueFlaskRotateAnimation blueAnim = new BlueFlaskRotateAnimation();
    public RedFlaskRotateAnimation redAnim = new RedFlaskRotateAnimation();
    public Beaker beaker = new Beaker();

    public Animations() throws FileNotFoundException {
        pane.getChildren().addAll(blueAnim,redAnim,beaker);

        blueAnim.getFlask().setLayoutX(290);
        redAnim.getFlask().setLayoutX(10);

        blueAnim.getFlask().setLayoutY(-400);
        redAnim.getFlask().setLayoutY(-400);

    }
    public static void movePivot(Node node, double x, double y){
        node.getTransforms().add(new Translate(-x,-y));
        node.setTranslateX(x); node.setTranslateY(y);
    }

    public void animateAll(){
        blueAnim.animate();
        redAnim.animate();
        beaker.animate();

    }
}
