package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EmptyBeaker extends BorderPane {
    InputStream stream = new FileInputStream("src/Resources/Beaker.jpg");
    Image image = new Image(stream);
    ImageView imageView = new ImageView();


    public EmptyBeaker() throws FileNotFoundException {
        imageView.setImage(image);

        imageView.setFitWidth(160);
        imageView.setFitHeight(160);
        imageView.setPreserveRatio(true);
        this.getChildren().add(imageView);
        this.setCenter(imageView);

    }
}
