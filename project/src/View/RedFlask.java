package View;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class RedFlask extends BorderPane {
    InputStream stream = new FileInputStream("project/src/Resources/RedFlask.png");
    Image image = new Image(stream);
    ImageView imageView = new ImageView();
    Text text = new Text();

    public RedFlask() throws FileNotFoundException {

        imageView.setImage(image);
        text.setFont(Font.font("verdana", FontWeight.BOLD, FontPosture.REGULAR, 18));
        text.setLayoutY(160);
        imageView.setFitWidth(105);
        imageView.setFitHeight(130);
        imageView.setPreserveRatio(false);
        this.getChildren().addAll(imageView,text);


    }

    public void setTxt(String txt){
        this.text.setText(txt);
    }
}
