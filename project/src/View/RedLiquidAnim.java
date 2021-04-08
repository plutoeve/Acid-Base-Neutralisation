package View;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RedLiquidAnim extends Pane {
    InputStream stream = new FileInputStream("project/src/Resources/Red-Drop.png");
    Image image = new Image(stream);
    ImageView red = new ImageView();
    public TranslateTransition tt = new TranslateTransition(Duration.millis(1500),red);
    public TranslateTransition tt2 = new TranslateTransition(Duration.millis(1),red);
    public FadeTransition fade = new FadeTransition(Duration.millis(1),red);

    public RedLiquidAnim() throws FileNotFoundException{
        super();
        red.setImage(image);
        red.setFitWidth(25);
        red.setFitHeight(30);
        red.setPreserveRatio(false);
        this.getChildren().add(red);

    }

    public void animatelq(){
        fade.setToValue(1.0);
        fade.play();
        tt.setByY(280);
        tt.setCycleCount(4);
        tt.play();
        tt.setOnFinished(e -> {
            fade.setToValue(0.0);
            tt2.setByY(-300);
            tt2.play();
            fade.play();});

    }

}
