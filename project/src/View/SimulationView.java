package View;

import Acid_Base_Neutralisation.Main;
import View.ControlPanelView;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public class SimulationView {
    Scene simulationScene;
    GridPane simulationPane = new GridPane();
    Button resetButton = new Button("RESET");
    ControlPanelView panelView = new ControlPanelView();
    Button HelpButton = new Button("Help");

    public SimulationView(){
        simulationPane.setAlignment(Pos.CENTER);
        resetButton.setOnAction(e->{
            panelView.AcidBox.getSelectionModel().clearSelection();
            panelView.BaseBox.getSelectionModel().clearSelection();
            panelView.concentrationAcid.clear();
            panelView.volumeAcid.clear();
            panelView.concentrationBase.clear();
            panelView.volumeBase.clear();
        });

        HelpButton.setOnAction(e->{
            HelpView hv = new HelpView();
            Main.firstStage.setScene(hv.HelpScene);
        });

        simulationPane.getChildren().add(panelView);
        simulationPane.add(resetButton,1,1);
        simulationPane.add(HelpButton, 1,2);
        simulationScene = new Scene(simulationPane,700 ,700 );

    }



}
