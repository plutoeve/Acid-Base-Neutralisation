package View;

import javafx.scene.control.ComboBox;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class ControlPanelView extends GridPane {

    ComboBox AcidBox = new ComboBox();
    ComboBox BaseBox = new ComboBox();

    public ControlPanelView(){
        super();
        Text acid = new Text("Acid");
        add(acid,0,0);

        Text base = new Text("Base");
        add(base,1,0);

        //list of acids

        AcidBox.getItems().addAll(
                "hydrochloric acid (HCl)",
                "hydrobromic acid (HBr)",
                "hydroiodic acid (HI)",
                "sulfuric acid (H2SO4", //only the first proton is considered strongly acidic)
                "nitric acid (HNO3)",
                "perchloric acid (HClO4)"
        );

        AcidBox.setPromptText("Pick Acid");

        //list of bases

        BaseBox.getItems().addAll(
                "sodium hydroxide (NaOH)",
                "potassium hydroxide (KOH)",
                "lithium hydroxide (LiOH)",
                "rubidium hydroxide (RbOH)",
                "cesium hydroxide (CsOH)",
                "calcium hydroxide (Ca(OH)2)"
        );

        BaseBox.setPromptText("Pick Base");

        //add combo to pane

        add(AcidBox,0,1);
        add(BaseBox,1,1);

    }
}