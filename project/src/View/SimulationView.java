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
    Button helpButton = new Button("Help");
    Button darkButton = new Button("Dark");

    BlueFlaskRotateAnimation anim1 = new BlueFlaskRotateAnimation();
    RedFlaskRotateAnimation anim2 = new RedFlaskRotateAnimation();

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



        // Testing animation Below

        LiquidAnim la = new LiquidAnim();
        controlPane.add(la,0,3);
        la.animate();

        //Testing animation above


        controlPane.getChildren().add(panelView);
        controlPane.add(buttonBox,1,0);

        //buttonBox.setAlignment(Pos.CENTER);  this doesnt work
        buttonBox.setSpacing(30);
        controlPane.setStyle("-fx-background-width: 6px;");
        //controlPane.getChildren().add(animation);
        simulationScene = new Scene(controlPane,1000 ,900 );

        controlPane.getChildren().addAll(anim1,anim2);


        anim1.getFlask().setLayoutX(500);
        anim2.getFlask().setLayoutX(10);

        anim1.getFlask().setLayoutY(-300);
        anim2.getFlask().setLayoutY(-300);

        anim1.animate();
        anim2.animate();


/*
        controlPane.getChildren().add(anim1);
        anim1.getFlask().setLayoutX(500);            *******Works, will put this stuff with the start/animate****
        anim1.animate();                              ******button so it doesnt mess up the controlPane*********

*/

       controlPane.setAlignment(Pos.BOTTOM_CENTER);
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
