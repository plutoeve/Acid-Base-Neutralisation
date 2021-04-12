package View;

import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

public class HelpView extends VBox {

        ScrollPane scroll = new ScrollPane();
        InputStream stream = new FileInputStream("project/src/Resources/ProgramAcidBase.png");
        Image image = new Image(stream);
        ImageView imageView = new ImageView();



        public HelpView() throws FileNotFoundException {
                imageView.setImage(image);
                scroll.setContent(imageView);

                this.getChildren().add(scroll);


         /*       try {
                        File file = new File("project/src/View/unicorn.txt");
                        Scanner scan = new Scanner(file);
                        String message = "";
                        while(scan.hasNextLine()){
                                message = message + scan.nextLine()+("\n");
                        }
                        Text help = new Text(message);
                        this.getChildren().add(help);
                } catch (FileNotFoundException e) {
                        System.out.println("file not found");;
                }*/


        }

}


