package View;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class ControlPanelView extends GridPane {

    public static ComboBox AcidBox = new ComboBox();
    public static ComboBox BaseBox = new ComboBox();
    TextField concentrationAcid = new TextField();
    TextField concentrationBase = new TextField();
    TextField volumeAcid = new TextField();
    TextField volumeBase = new TextField();

    public ControlPanelView(){
        this.prefHeightProperty().bind(SimulationView.controlPane.prefHeightProperty());
        this.prefWidthProperty().bind(SimulationView.controlPane.prefWidthProperty());
        Label acid = new Label("Acid");
        acid.setFont(Font.font(15));
        add(acid,0,0);



        Label base = new Label("Base");
        base.setFont(Font.font(15));
        add(base,1,0);

        //list of acids

        AcidBox.getItems().addAll(
                "HCl",
                "HBr",
                "HI",
                "H2SO4", //only the first proton is considered strongly acidic)
                "HNO3",
                "HClO4"
        );

        AcidBox.setPromptText("Pick Acid");

        //list of bases

        BaseBox.getItems().addAll(
                "NaOH",
                "KOH",
                "LiOH",
                "RbOH",
                "CsOH",
                "Ca(OH)2"
        );

        BaseBox.setPromptText("Pick Base");

        //add combo to pane
        add(AcidBox,0,1);
        add(BaseBox,1,1);

        EventHandler combo = new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {

            }
        };

        concentrationAcid.setPromptText("Input acid concentration");
        concentrationBase.setPromptText("Input base concentration");
        volumeAcid.setPromptText("Input acid volume(L)");
        volumeBase.setPromptText("Input base volume(L)");
        add(concentrationAcid, 0,2);
        add(concentrationBase,1,2);
        add(volumeAcid, 0, 3);
        add(volumeBase, 1,3);

        this.setHgap(40);
        this.setVgap(40);
    }

    public ComboBox getAcidBox() {
        return AcidBox;
    }

    public ComboBox getBaseBox() {
        return BaseBox;
    }

    public TextField getConcentrationAcid() {
        return concentrationAcid;
    }

    public TextField getConcentrationBase() {
        return concentrationBase;
    }

    public TextField getVolumeAcid() {
        return volumeAcid;
    }

    public TextField getVolumeBase() {
        return volumeBase;
    }

}