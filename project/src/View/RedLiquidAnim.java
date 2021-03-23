package View;

import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RedLiquidAnim extends Pane {
    InputStream stream = new FileInputStream("project/src/Resources/Red-Drop.jpg");
    Image image = new Image(stream);
    ImageView red = new ImageView();

    public RedLiquidAnim() throws FileNotFoundException{
        super();
        red.setImage(image);
        red.setFitWidth(20);
        red.setFitHeight(30);
        red.setPreserveRatio(false);
        this.getChildren().add(red);

    }

    public void animatelq(){
        TranslateTransition tt = new TranslateTransition(Duration.millis(1500),red);
        tt.setByY(300);
        tt.setCycleCount(3);
        tt.play();
    }

}
