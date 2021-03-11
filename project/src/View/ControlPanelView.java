package View;

import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ControlPanelView extends GridPane {

    ComboBox AcidBox = new ComboBox();
    ComboBox BaseBox = new ComboBox();
    TextField concentrationAcid = new TextField();
    TextField concentrationBase = new TextField();
    TextField volumeAcid = new TextField();
    TextField volumeBase = new TextField();

    public ControlPanelView(){

        Text acid = new Text("Acid");
        add(acid,0,0);

        Text base = new Text("Base");
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

        concentrationAcid.setPromptText("Please input acid concentration");
        concentrationBase.setPromptText("Please input base concentration");
        volumeAcid.setPromptText("Please input acid volume");
        volumeBase.setPromptText("Please input base volume");
        add(concentrationAcid, 0,2);
        add(concentrationBase,1,2);
        add(volumeAcid, 0, 3);
        add(volumeBase, 1,3);

        this.setHgap(30);
        this.setVgap(30);
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