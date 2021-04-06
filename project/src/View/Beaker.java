package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class Beaker extends BorderPane {

    InputStream stream = new FileInputStream("project/src/Resources/Beaker.png");
    Image image = new Image(stream);
    ImageView imageView = new ImageView();

    public Beaker() throws FileNotFoundException {

        imageView.setImage(image);

        imageView.setFitWidth(160);
        imageView.setFitHeight(160);
        imageView.setPreserveRatio(true);
        this.getChildren().add(imageView);
        this.setCenter(imageView);

    }




}
