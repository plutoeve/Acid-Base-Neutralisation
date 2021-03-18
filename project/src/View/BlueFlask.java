package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlueFlask extends BorderPane {
    InputStream stream = new FileInputStream("project/src/Resources/BlueFlask.png");
    Image image = new Image(stream);
    ImageView imageView = new ImageView();
    LiquidAnim liquid = new LiquidAnim();

    public BlueFlask() throws FileNotFoundException {

        imageView.setImage(image);

        imageView.setFitWidth(130);
        imageView.setFitHeight(160);
        imageView.setPreserveRatio(false);
        liquid.animate();

        System.out.println("PRE SEQUEL");

        this.getChildren().addAll(imageView,liquid);


    }


}
