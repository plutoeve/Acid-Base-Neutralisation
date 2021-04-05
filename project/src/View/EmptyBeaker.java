package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class EmptyBeaker extends BorderPane {
    InputStream stream = new FileInputStream("project/src/Resources/EmptyBeaker.png");
    Image image = new Image(stream);
    ImageView imageView = new ImageView();


    public EmptyBeaker() throws FileNotFoundException {
        imageView.setImage(image);

        imageView.setFitWidth(170);
        imageView.setFitHeight(170);
        imageView.setPreserveRatio(false);
        this.getChildren().add(imageView);
        imageView.setX(150);
        imageView.setY(-180);


    }
}
