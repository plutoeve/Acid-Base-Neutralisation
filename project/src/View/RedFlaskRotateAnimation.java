package View;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class RedFlaskRotateAnimation extends Pane {
    public final RedFlask flask = new RedFlask();
    public RotateTransition rt = new RotateTransition(Duration.millis(3000), flask);

    public RedFlaskRotateAnimation(String str) throws FileNotFoundException {
        super();
        this.getChildren().addAll(flask);
        Animations.movePivot(flask, 80,40);
        flask.setTxt(str);
    }

    public void animate(){

        rt.setByAngle(90);
        rt.setCycleCount(2);
        rt.setAutoReverse(true);
        rt.play();

    }

    public void animateDroplet() throws FileNotFoundException {
        RedLiquidAnim redlq = new RedLiquidAnim();
        this.getChildren().add(redlq);
        redlq.relocate(150,-350);
        redlq.animatelq();


    }

    public RedFlask getFlask() {
        return this.flask;
    }

}
