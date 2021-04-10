package View;


import Acid_Base_Neutralisation.Main;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class SimulationView {

    Scene simulationScene;
    public static Animations animation;
    public static GridPane controlPane = new GridPane();
    public static ControlPanelView panelView = new ControlPanelView();


    InputStream imgStream = new FileInputStream("project/src/Resources/Home.png");
    Image img = new Image(imgStream);
    ImageView imgView= new ImageView(img);

    VBox buttonBox = new VBox();
    Button homeButton = new Button("Home");
    Button darkButton = new Button("Dark");
    Button defaultButton = new Button("Default");
    public Button simulationButton = new Button("Start simulating!");
    boolean isDark;


    public SimulationView() throws FileNotFoundException {
        controlPane.setMinSize(300,300);
        controlPane.setHgap(20);
        controlPane.setVgap(20);

        imgView.setFitHeight(25);
        imgView.setFitWidth(25);

        homeButton.setGraphic(imgView);

        homeButton.setOnAction(e->{

            Main.firstStage.setScene(MainView.scene);
        });



        defaultButton.setOnAction(e->{
            simulationScene.getStylesheets().remove("View/dark.css");
            isDark = false;

        });



        darkButton.setOnAction(e->{
            while(!isDark) {
                simulationScene.getStylesheets().add("View/dark.css");
                isDark = true;
            }
        });





        buttonBox.getChildren().addAll(homeButton, darkButton, defaultButton, simulationButton);



        animation = new Animations();

        GridPane animationPane = animation.pane;
        controlPane.add(animationPane, 10,22);
        controlPane.add(panelView,10,22);
        controlPane.add(buttonBox,11,22);


        buttonBox.setSpacing(20);
        controlPane.setStyle("-fx-background-width: 6px;");

        simulationScene = new Scene(controlPane,830 ,700 );



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
        return simulationButton;
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
