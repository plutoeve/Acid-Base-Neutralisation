package View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SimulationView {
    Scene simulationScene;
    GridPane simulationPane = new GridPane();

    public SimulationView(){

        simulationPane.getChildren().add(new ControlPanelView());
        simulationScene = new Scene(simulationPane,700 ,700 );
    }



}
