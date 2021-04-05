package View;

import javafx.animation.Animation;
import javafx.animation.RotateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class BlueFlaskRotateAnimation extends Pane {

    public BlueFlask flask = new BlueFlask();
    public BlueLiquidAnim bluelq = new BlueLiquidAnim();
    public RotateTransition rt = new RotateTransition(Duration.millis(3000), flask);

    public BlueFlaskRotateAnimation() throws FileNotFoundException {
        super();
        this.getChildren().addAll(flask,bluelq);
    }

    public void animate(){

        rt.setByAngle(-90);
        rt.setCycleCount(2);
        rt.setAutoReverse(true);
        Animations.movePivot(flask, 50, 10);
        rt.play();
        bluelq.relocate(290,-350);
        bluelq.animatelq();

    }

    public BlueFlask getFlask() {
        return this.flask;
    }

}
