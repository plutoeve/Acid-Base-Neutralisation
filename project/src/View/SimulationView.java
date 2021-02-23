package View;

import Acid_Base_Neutralisation.Main;
import View.ControlPanelView;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class SimulationView {
    Scene simulationScene;
    GridPane controlPane = new GridPane();
    GridPane simulationPane = new GridPane();
    ControlPanelView panelView = new ControlPanelView();

    VBox buttonBox = new VBox();
    Button resetButton = new Button("Reset");
    Button helpButton = new Button("Help");
    Button darkButton = new Button("Dark");

    public SimulationView(){
        controlPane.setHgap(20);
        controlPane.setVgap(20);
        resetButton.setOnAction(e->{
            panelView.AcidBox.getSelectionModel().clearSelection();
            panelView.BaseBox.getSelectionModel().clearSelection();
            panelView.concentrationAcid.clear();
            panelView.volumeAcid.clear();
            panelView.concentrationBase.clear();
            panelView.volumeBase.clear();
        });

        helpButton.setOnAction(e->{
            HelpView hv = new HelpView();
            Stage helpStage = new Stage();
            helpStage.setTitle("Help: Formulas, equations, and instructions");
            helpStage.setScene(new Scene(hv, 1000,700));
            helpStage.show();
        });

        darkButton.setOnAction(e->{
            simulationScene.getStylesheets().add("View/dark.css");
        });
        buttonBox.getChildren().addAll(resetButton, helpButton, darkButton);
        controlPane.getChildren().add(panelView);
        controlPane.add(buttonBox,1,0);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.setSpacing(30);
        simulationPane.add(controlPane,1,0);
        controlPane.setStyle("-fx-background-radius: 6px;");
        simulationPane.setAlignment(Pos.BOTTOM_CENTER);
        simulationScene = new Scene(simulationPane,700 ,700 );

    }



}
