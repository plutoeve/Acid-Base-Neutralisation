package View;

import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class simulationView {
    Scene simulationScene;
    GridPane simulationPane = new GridPane();

    public simulationView(){

        simulationPane.getChildren().add(new ControlPanelView());
        simulationScene = new Scene(simulationPane,700 ,700 );
    }



}
