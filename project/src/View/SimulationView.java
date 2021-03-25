package View;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.FileNotFoundException;

public class SimulationView {
    Scene simulationScene;
    GridPane controlPane = new GridPane();
    ControlPanelView panelView = new ControlPanelView();

    VBox buttonBox = new VBox();
    Button resetButton = new Button("Reset");
    Button darkButton = new Button("Dark");
    Button startButton = new Button("Start simulating!");

    public SimulationView() throws FileNotFoundException {
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


        darkButton.setOnAction(e->{
            simulationScene.getStylesheets().add("View/dark.css");
        });


        buttonBox.getChildren().addAll(resetButton, darkButton, startButton);



        // Testing animation Below

      /*  LiquidAnim la = new LiquidAnim();
        la.animate();
        controlPane.add(la,0,3);*/



        //Testing animation above


        controlPane.getChildren().add(panelView);
        controlPane.add(buttonBox,1,0);


        buttonBox.setSpacing(30);
        controlPane.setStyle("-fx-background-width: 6px;");

        simulationScene = new Scene(controlPane,1000 ,900 );


       controlPane.setAlignment(Pos.BOTTOM_CENTER);
    }

    public Button getStartButton() {
        return startButton;
    }

    public GridPane getControlPane() {
        return controlPane;
    }

    public ControlPanelView getPanelView() {
        return panelView;
    }

    public void setPanelView(ControlPanelView panelView) {
        this.panelView = panelView;
    }
}
