package View;

import javafx.animation.RotateTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class RedFlaskRotateAnimation extends Pane {
    private final RedFlask flask = new RedFlask();
    private RedLiquidAnim redlq = new RedLiquidAnim();

    public RedFlaskRotateAnimation() throws FileNotFoundException {
        super();
        this.getChildren().addAll(flask,redlq);
    }

    public void animate(){
        RotateTransition rt = new RotateTransition(Duration.millis(3000), flask);
        //Testing translating height of the flask
        TranslateTransition tt = new TranslateTransition(Duration.millis(5000),flask);

        tt.setByY(75);
        tt.play();
        //////////////////////////////////////////////
        rt.setByAngle(90);
        rt.setCycleCount(2);
        rt.setAutoReverse(true);
        rt.play();
        redlq.relocate(35,-350);
        redlq.animatelq();
    }

    public RedFlask getFlask() {
        return this.flask;
    }
}
