
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
        Button startButton = new Button("Start");
        Button helpButton = new Button("Help");
        Label label = new Label("Acid-Base Neutralisation Simulator V1.1.0");
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
            startButton.setScaleX(1.9);
            startButton.setScaleY(1.9);

            setHelpButtonStyle(helpButton);
            helpButton.setScaleX(1.5);
            helpButton.setScaleY(1.5);

            vbox.setSpacing(50);
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
        startButton.setId("bt");
        startButton.getStylesheets().add(getClass().getResource("ButtonStyles.css").toExternalForm());
        }


        public void setHelpButtonStyle(Button helpButton){
            helpButton.setId("bt");
            helpButton.getStylesheets().add(getClass().getResource("ButtonStyles.css").toExternalForm());
        };








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

