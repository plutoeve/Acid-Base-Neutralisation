
package View;
import Acid_Base_Neutralisation.Main;
import Controller.ReactionController;
import Model.MoleculeHolder;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

import java.io.FileNotFoundException;

public class MainView {


        GridPane pane = new GridPane();
        public static Scene scene;
        Button startButton = new Button("START");

        Label label = new Label("Simulation: Acid-Base Neutralisation");
        VBox vbox = new VBox();

    public MainView() {

            scene = new Scene(pane,1000 , 530);
            Main.firstStage.setScene(scene);



            label.getStyleClass().add("outline");
            scene.getStylesheets().addAll(getClass().getResource(
                    "outline.css"
            ).toExternalForm());
            vbox.getChildren().add(label);
            vbox.getChildren().add(startButton);
            vbox.setAlignment(Pos.CENTER);
            vbox.setSpacing(20);

            pane.setAlignment(Pos.CENTER);
            pane.getChildren().add(vbox);
            setButtonStyle(startButton);
            startButton.setScaleX(2);
            startButton.setScaleY(2);
            startButton.setOnAction(start);

            Main.firstStage.setResizable(false);
        }


        public void setButtonStyle(Button button){
        startButton.setStyle("-fx-background-color:\n" +
                "linear-gradient(#f0ff35, #a9ff00),\n" +
                "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                "-fx-background-radius: 6, 5;\n" +
                "-fx-background-insets: 0, 1;\n" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                "-fx-text-fill: #395306;");
        }



        EventHandler start = new EventHandler() {
            @Override
            public void handle(Event event) {
                SimulationView sv = null;
                try {
                    sv = new SimulationView();
                    Main.firstStage.setScene(sv.simulationScene);
                    Main.firstStage.setResizable(true);
                    ReactionController rc = new ReactionController(new MoleculeHolder(), sv);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }

            }
        };
    }

