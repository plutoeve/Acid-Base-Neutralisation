package Controller;
import View.*;
import Model.*;
import javafx.event.Event;
import javafx.event.EventHandler;

import java.util.ArrayList;


public class ReactionController {
    ArrayList values;
    boolean baseAllEmpty;
    boolean acidAllEmpty;
    String BaseVolume, AcidVolume, BaseConcentration, AcidConcentration;

    public ReactionController(MoleculeHolder moleculeHolder, SimulationView simulationView) {
        ControlPanelView cpv = simulationView.getPanelView();
        //get the name of the chosen reactants
        String chosenAcid = cpv.getAcidBox().getSelectionModel().toString();
        String chosenBase = cpv.getBaseBox().getSelectionModel().toString();
        //to be done
        AcidModel acid = (AcidModel) moleculeHolder.getHashMap().get(chosenAcid);
        BaseModel base = (BaseModel) moleculeHolder.getHashMap().get(chosenBase);

        EventHandler startHandler =  new EventHandler() {

            @Override
            public void handle(Event event) {
                switch(PickCase(cpv)) {

                    case 1: System.out.println("please input more than 1 parameter for it to work");
                            break;

                    case 2: if(baseAllEmpty){
                                int baseConcentration = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(AcidVolume));
                                AcidVolume = BaseVolume;
                                BaseConcentration = Integer.toString(baseConcentration);
                            }else if(acidAllEmpty){
                                int acidConcentration = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(BaseVolume));
                                AcidVolume = BaseVolume;
                                AcidConcentration = Integer.toString(acidConcentration);
                            }else{}
                            break;

                    case 3: switch(WhatIsMissing()){
                            case "base concentration": int baseConcentration = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseVolume));
                                                       BaseConcentration = Integer.toString(baseConcentration);

                            case "acid concentration":int acidConcentration = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(AcidVolume));
                                                       AcidConcentration = Integer.toString(acidConcentration);

                            case "base volume":int baseVolume = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseConcentration));
                                                       BaseVolume = Integer.toString(baseVolume);
                            case "acid volume":  int acidVolume = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(AcidVolume));
                                                       AcidVolume = Integer.toString(acidVolume);
                            }
                            break;

                    case 4:
                        boolean balanced = Calculations.calculate(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseVolume),Integer.parseInt(BaseVolume));
                            if(balanced){
                                System.out.println("yeah it is good");
                            }else{
                                System.out.println("try to make it balanced...or leave one or two Textfield blank"); };
                            break;
                    default: System.out.println("nothing is there... please input something");
                            break;
                    }
            }
        };

        simulationView.getStartButton().setOnAction(startHandler);



    }

   int PickCase(ControlPanelView controlPanelView) {

        values = new ArrayList<Integer>();
        BaseVolume = controlPanelView.getVolumeBase().getText();
        AcidVolume = controlPanelView.getVolumeBase().getText();
        BaseConcentration = controlPanelView.getConcentrationBase().getText();
        AcidConcentration = controlPanelView.getConcentrationAcid().getText();
        String[] Parameters = {AcidConcentration, BaseConcentration, AcidVolume, BaseVolume};
        if((BaseConcentration.isEmpty()&&BaseVolume.isEmpty())){
            baseAllEmpty = true;
        }
        if((AcidConcentration.isEmpty()&&AcidVolume.isEmpty())){
            acidAllEmpty = true;
        }
        int c = 4;
        for (String str : Parameters) {
            if(str.isEmpty() == true){ c--;}
            else{values.add(Integer.parseInt(str));}
        }
        return c;
    }

    public String WhatIsMissing(){
        if(BaseConcentration.isEmpty()){
            return"base concentration";
        }
        else if(BaseVolume.isEmpty()){
                return"base volume";
        }
        else if(AcidConcentration.isEmpty()) {
            return "acid concentration";
        }else {
            return "acid volume";

        }
        }
    }




