package View;

import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;


public class HelpView extends VBox {

        private ScrollPane scroll = new ScrollPane();
        private InputStream stream = new FileInputStream("project/src/Resources/ProgramAcidBase.png");
        private Image image = new Image(stream);
        private ImageView imageView = new ImageView();



        public HelpView() throws FileNotFoundException {
                imageView.setImage(image);
                scroll.setContent(imageView);

                this.getChildren().add(scroll);

        }

}


