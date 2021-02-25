package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelpView extends VBox {

        File file;
        Scanner scan;

        {
                try {
                        new File("Help.txt");
                        scan = new Scanner(file);
                } catch (FileNotFoundException e) {
                        e.printStackTrace();
                }
        }


        public HelpView(){

                Text text = new Text(scan.nextLine());
                this.getChildren().addAll(text);


        }

}
