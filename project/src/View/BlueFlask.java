package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class BlueFlask extends BorderPane {
    InputStream stream = new FileInputStream("src/Resources/BlueFlask.png");
    Image image = new Image(stream);
    ImageView imageView = new ImageView();

    public BlueFlask() throws FileNotFoundException {

        imageView.setImage(image);

        imageView.setFitWidth(160);
        imageView.setFitHeight(160);
        imageView.setPreserveRatio(false);

        imageView.rotateProperty().setValue(90);

        this.getChildren().add(imageView);


    }


}
