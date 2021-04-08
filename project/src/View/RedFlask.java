package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RedFlask extends BorderPane {
    InputStream stream = new FileInputStream("project/src/Resources/RedFlask.png");
    Image image = new Image(stream);
    ImageView imageView = new ImageView();

    public RedFlask() throws FileNotFoundException {

        imageView.setImage(image);

        imageView.setFitWidth(105);
        imageView.setFitHeight(130);
        imageView.setPreserveRatio(false);
        this.getChildren().add(imageView);


    }
}
