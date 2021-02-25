package View;

import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.Scene;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HelpView extends VBox {



        public HelpView(){

                try {
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
                }


        }

}
