
package View;
import Acid_Base_Neutralisation.Main;
import Controller.ReactionController;
import Model.MoleculeHolder;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.FileNotFoundException;


public class MainView {
        GridPane pane = new GridPane();
        public static Scene scene;
        Button startButton = new Button("START");
        Button helpButton = new Button("HELP");
        Label label = new Label("Simulation: Acid-Base Neutralisation");
        VBox vbox = new VBox();
        SimulationView sv = new SimulationView();




    public MainView() throws FileNotFoundException{

            scene = new Scene(pane,1000 , 530);
            Main.firstStage.setScene(scene);



            label.getStyleClass().add("outline");
            scene.getStylesheets().addAll(getClass().getResource(
                    "outline.css"
            ).toExternalForm());

            vbox.getChildren().add(label);
            vbox.getChildren().add(startButton);
            vbox.getChildren().add(helpButton);
            vbox.setAlignment(Pos.CENTER);


            pane.setAlignment(Pos.CENTER);
            pane.getChildren().add(vbox);

            setStartButtonStyle(startButton);
            startButton.setScaleX(2);
            startButton.setScaleY(2);

            setHelpButtonStyle(helpButton);
            helpButton.setScaleX(2);
            helpButton.setScaleY(2);

            vbox.setSpacing(30);
            startButton.setOnAction(start);

            helpButton.setOnAction(e->{
                Main.click.seek(Duration.ZERO);
                Main.click.play();
                HelpView hv = new HelpView();
                Stage helpStage = new Stage();
                helpStage.setTitle("Help: Formulas, equations, and instructions");
                helpStage.setScene(new Scene(hv, 1000,700));
                helpStage.show();
            });


            Main.firstStage.setResizable(false);
        }


        public void setStartButtonStyle(Button button){
        button.setStyle("-fx-background-color:\n" +
                "linear-gradient(#f0ff35, #a9ff00),\n" +
                "radial-gradient(center 50% -40%, radius 200%, #b8ee36 45%, #80c800 50%);\n" +
                "-fx-background-radius: 6, 5;\n" +
                "-fx-background-insets: 0, 1;\n" +
                "-fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.4) , 5, 0.0 , 0 , 1 );\n" +
                "-fx-text-fill: #395306;");
        }


        public void setHelpButtonStyle(Button helpButton){
        helpButton.setStyle("-fx-background-color: \n" +
                "        linear-gradient(#f2f2f2, #d6d6d6),\n" +
                "        linear-gradient(#fcfcfc 0%, #d9d9d9 20%, #d6d6d6 100%),\n" +
                "        linear-gradient(#dddddd 0%, #f6f6f6 50%);\n" +
                "    -fx-background-radius: 8,7,6;\n" +
                "    -fx-background-insets: 0,1,2;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );");

        }



        EventHandler start = new EventHandler() {
            @Override
            public void handle(Event event) {
                  Main.click.seek(Duration.ZERO);
                  Main.click.play();

                  Main.firstStage.setScene(sv.simulationScene);
                  Main.firstStage.setResizable(true);

                    ReactionController rc = new ReactionController(new MoleculeHolder(), sv);




        };

    };}

