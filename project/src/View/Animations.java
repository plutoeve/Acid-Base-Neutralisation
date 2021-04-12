package View;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.transform.Translate;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.stream.Stream;

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

    public void toDark() throws FileNotFoundException{
        blueAnim.flask.imageView.setImage(new Image(new FileInputStream("project/src/Resources/darkBlueFlask.png")));
        redAnim.flask.imageView.setImage(new Image(new FileInputStream("project/src/Resources/darkRedFlask.png")));
        beaker.emptyBeakerImageView.setImage(new Image(new FileInputStream("project/src/Resources/darkEmptyBeaker.png")));
        beaker.fullBeakerImageView.setImage(new Image(new FileInputStream("project/src/Resources/darkBeaker.png")));

        blueAnim.flask.text.setFill(Color.WHITE);
        redAnim.flask.text.setFill(Color.WHITE);

    }

    public void toLight() throws FileNotFoundException{
        blueAnim.flask.imageView.setImage(new Image(new FileInputStream("project/src/Resources/BlueFlask.png")));
        redAnim.flask.imageView.setImage(new Image(new FileInputStream("project/src/Resources/RedFlask.png")));
        beaker.emptyBeakerImageView.setImage(new Image(new FileInputStream("project/src/Resources/EmptyBeaker.png")));
        beaker.fullBeakerImageView.setImage(new Image(new FileInputStream("project/src/Resources/Beaker.png")));
        blueAnim.flask.text.setFill(Color.BLACK);
        redAnim.flask.text.setFill(Color.BLACK);
    }
}
