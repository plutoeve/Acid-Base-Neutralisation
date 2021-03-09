package Controller;
import View.*;
import Model.*;

import java.util.Base64;
import java.util.HashMap;

public class ReactionController {

    public ReactionController(MoleculeHolder moleculeHolder, SimulationView simulationView) {
        ControlPanelView cpv = simulationView.getPanelView();
        //get the name of the chosen reactants
        String chosenAcid = cpv.getAcidBox().getSelectionModel().toString();
        String chosenBase = cpv.getBaseBox().getSelectionModel().toString();

        AcidModel acid = (AcidModel) moleculeHolder.getHashMap().get(chosenAcid);
        BaseModel base = (BaseModel) moleculeHolder.getHashMap().get(chosenBase);

        int baseVolume = Integer.parseInt(cpv.getVolumeBase().getText());
        int acidVolume = Integer.parseInt(cpv.getVolumeAcid().getText());
        int acidConcentration = Integer.parseInt(cpv.getConcentrationAcid().getText());
        int baseConcentration = Integer.parseInt(cpv.getConcentrationBase().getText());
        if (cpv.getVolumeBase().getText().isEmpty()) {
            if (cpv.getConcentrationBase().getText().isEmpty()) {
            }

        }
    }
}
