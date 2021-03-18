package View;

import javafx.animation.RotateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileNotFoundException;

public class BlueFlaskRotateAnimation extends Pane {

    private BlueFlask flask = new BlueFlask();

    public BlueFlaskRotateAnimation() throws FileNotFoundException {
        super();
        this.getChildren().add(flask);
    }

    public void animate(){
        RotateTransition rt = new RotateTransition(Duration.millis(3000), flask);
        rt.setByAngle(-90);
        rt.setCycleCount(2);
        rt.setAutoReverse(true);
        rt.play();
    }

    public BlueFlask getFlask() {
        return this.flask;
    }

}
