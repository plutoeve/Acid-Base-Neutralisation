package View;

import javafx.animation.Animation;
import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlueLiquidAnim extends Pane {

    InputStream stream = new FileInputStream("project/src/Resources/water-droplet.png");
    Image image = new Image(stream);
    ImageView blue = new ImageView();
    public TranslateTransition tt = new TranslateTransition(Duration.millis(1500),blue);

    public BlueLiquidAnim() throws FileNotFoundException{

        super();
        blue.setImage(image);
        blue.setFitWidth(20);
        blue.setFitHeight(30);
        blue.setPreserveRatio(false);
        this.getChildren().add(blue);
    }

    public void animatelq(){

        tt.setByY(300);
        tt.setCycleCount(4);
        tt.play();

    }
}
