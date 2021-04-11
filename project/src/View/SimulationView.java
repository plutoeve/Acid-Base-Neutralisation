package View;


import Acid_Base_Neutralisation.Main;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
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

    ToggleGroup option = new ToggleGroup();
    public ToggleButton gramPerLiter = new ToggleButton("g/L");
    public ToggleButton molPerLiter = new ToggleButton("mol/L");


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
            simulationScene.getStylesheets().remove("View/light.css");
            isDark = false;

        });



        darkButton.setOnAction(e->{
            while(!isDark) {
                simulationScene.getStylesheets().add("View/dark.css");
                isDark = true;
            }
        });

        gramPerLiter.setSelected(true);
        gramPerLiter.setToggleGroup(option);
        molPerLiter.setToggleGroup(option);
        HBox hbox = new HBox(gramPerLiter, molPerLiter);
        hbox.setSpacing(15);



        buttonBox.getChildren().addAll(homeButton, darkButton, defaultButton, simulationButton,hbox);



        animation = new Animations();

        GridPane animationPane = animation.pane;
        controlPane.add(animationPane, 10,22);
        controlPane.add(panelView,10,22);
        controlPane.add(buttonBox,11,22);


        buttonBox.setSpacing(20);
        controlPane.setStyle("-fx-background-width: 6px;");

        simulationScene = new Scene(controlPane,830 ,700 );



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
