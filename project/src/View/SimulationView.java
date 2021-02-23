package View;

import Acid_Base_Neutralisation.Main;
import View.ControlPanelView;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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
            Stage helpStage = new Stage();
            helpStage.setTitle("Help: Formulas, equations, and instructions");
            helpStage.setScene(new Scene(hv, 1000,700));
            helpStage.show();
        });

        simulationPane.getChildren().add(panelView);
        simulationPane.add(resetButton,1,1);
        simulationPane.add(HelpButton, 1,2);
        simulationScene = new Scene(simulationPane,700 ,700 );

    }



}
