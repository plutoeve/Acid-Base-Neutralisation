package View;

import javafx.animation.FadeTransition;
import javafx.animation.TranslateTransition;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class LiquidAnim extends Pane {
    ImageView blue;
  //  InputStream stream = new FileInputStream("src/Resources/water-droplet.png");

    Rectangle rect = new Rectangle(100,40,0,0);

    public LiquidAnim(){
        super();
//        blue = new ImageView(new Image(stream));
        rect.setFill(Color.RED);
        this.getChildren().add(rect);
    }

    public void animate(){
        TranslateTransition tt = new TranslateTransition(Duration.millis(3000),rect);
        tt.setByY(500);
        tt.setCycleCount(10);
        tt.play();

       /* FadeTransition ft = new FadeTransition(Duration.millis(3000), rect);
        ft.setFromValue(1.0);
        ft.setToValue(0);
        ft.play();*/
    }
}
