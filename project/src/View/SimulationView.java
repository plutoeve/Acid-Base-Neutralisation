package View;


import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileNotFoundException;

public class SimulationView {
    //Animations animations = new Animations();
    Scene simulationScene;
    public static Animations animation;
    public static GridPane controlPane = new GridPane();
    static ControlPanelView panelView = new ControlPanelView();

    VBox buttonBox = new VBox();
    Button resetButton = new Button("Reset");
    Button darkButton = new Button("Dark");
    Button defaultButton = new Button("Default");
    Button startButton = new Button("Start simulating!");


    public SimulationView() throws FileNotFoundException {
        controlPane.setMinSize(300,300);
        controlPane.setHgap(20);
        controlPane.setVgap(20);

        setDefaultButtonColor(startButton);

        resetButton.setOnAction(e->{


            panelView.AcidBox.getSelectionModel().clearSelection();
            panelView.BaseBox.getSelectionModel().clearSelection();

            panelView.concentrationAcid.clear();
            panelView.volumeAcid.clear();
            panelView.concentrationBase.clear();
            panelView.volumeBase.clear();
        });

        setDefaultButtonColor(resetButton);

        defaultButton.setOnAction(e->{
            simulationScene.getStylesheets().remove("View/dark.css");

        });

        setDefaultButtonColor(defaultButton);

        darkButton.setOnAction(e->{
            simulationScene.getStylesheets().add("View/dark.css");
        });

        setDarkButtonColor(darkButton);


        buttonBox.getChildren().addAll(resetButton, darkButton, defaultButton, startButton);


       // controlPane.getChildren().add(animations.pane);
        animation = new Animations();
        Pane animationPane = animation.pane;
        controlPane.add(animationPane, 0,1);
        controlPane.add(panelView,2,1);
        controlPane.add(buttonBox,1,1);


        buttonBox.setSpacing(20);
        controlPane.setStyle("-fx-background-width: 6px;");

        simulationScene = new Scene(controlPane,1300 ,1000 );



    }

    public void setDefaultButtonColor(Button defaultButtonColor){
        defaultButtonColor.setStyle(" -fx-background-color: \n" +
                "        #c3c4c4,\n" +
                "        linear-gradient(#d6d6d6 50%, white 100%),\n" +
                "        radial-gradient(center 50% -40%, radius 200%, #e6e6e6 45%, rgba(230,230,230,0) 50%);\n" +
                "    -fx-background-radius: 30;\n" +
                "    -fx-background-insets: 0,1,1;\n" +
                "    -fx-text-fill: black;\n" +
                "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 3, 0.0 , 0 , 1 );");
    }

    public void setDarkButtonColor(Button darkButtonColor){
        darkButtonColor.setStyle(" -fx-background-color: \n" +
                        "        #090a0c,\n" +
                        "        linear-gradient(#38424b 0%, #1f2429 20%, #191d22 100%),\n" +
                        "        linear-gradient(#20262b, #191d22),\n" +
                        "        radial-gradient(center 50% 0%, radius 100%, rgba(114,131,148,0.9), rgba(255,255,255,0));\n" +
                        "    -fx-background-radius: 5,4,3,5;\n" +
                        "    -fx-background-insets: 0,1,2,0;\n" +
                        "    -fx-text-fill: white;\n" +
                        "    -fx-effect: dropshadow( three-pass-box , rgba(0,0,0,0.6) , 5, 0.0 , 0 , 1 );\n" +
                        "    -fx-font-family: \"Arial\";\n" +
                        "    -fx-text-fill: linear-gradient(white, #d0d0d0);\n" +
                        "    -fx-font-size: 12px;\n" +
                        "    -fx-padding: 10 20 10 20;");
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
