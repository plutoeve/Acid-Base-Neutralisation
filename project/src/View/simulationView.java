package View;

import javafx.scene.Scene;
import javafx.scene.layout.GridPane;

public class simulationView {
    Scene simulationScene = new Scene(new GridPane(), 500, 500);
    GridPane simulationPane = new GridPane();

    public simulationView(){

        simulationPane.getChildren().add(new ControlPanelView());
    }



}
