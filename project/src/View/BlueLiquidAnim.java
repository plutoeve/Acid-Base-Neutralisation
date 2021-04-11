package View;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlueLiquidAnim extends Pane {

    private InputStream stream = new FileInputStream("project/src/Resources/water-droplet.png");
    private Image image = new Image(stream);
    private ImageView blue = new ImageView();
    public TranslateTransition tt = new TranslateTransition(Duration.millis(1500),blue);
    public TranslateTransition tt2 = new TranslateTransition(Duration.millis(1),blue);
    public FadeTransition fade = new FadeTransition(Duration.millis(1),blue);

    public BlueLiquidAnim() throws FileNotFoundException{

        super();
        blue.setImage(image);
        blue.setFitWidth(20);
        blue.setFitHeight(30);
        blue.setPreserveRatio(false);
        this.getChildren().add(blue);
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

