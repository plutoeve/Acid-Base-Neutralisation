package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;

public class HelpView extends VBox {

        Scene HelpScene;


        public HelpView(){

                Text text = new Text("Welcome to our program on Acid-Base Titration! The following information is used" +
                        "for our program.");
                this.getChildren().addAll(text);

                HelpScene = new Scene(this,1000,700);
        }

}
