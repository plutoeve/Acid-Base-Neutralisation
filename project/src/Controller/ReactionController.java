package Controller;
import View.*;
import Model.*;
import javafx.event.Event;
import javafx.event.EventHandler;



public class ReactionController {
    boolean baseAllEmpty;
    boolean acidAllEmpty;
    String BaseVolume, AcidVolume, BaseConcentration, AcidConcentration;
    int bvolume, avolume, bconcentration, aconcentration;

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
                                AcidVolume = BaseVolume;
                                int acidConcentration = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(BaseVolume));

                            }else{}
                            break;

                    case 3: switch(WhatIsMissing()){
                            case "base concentration": bconcentration = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseVolume));

                            case "acid concentration":aconcentration = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(AcidVolume));

                            case "base volume": bvolume = Calculations.calculateFourth(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseConcentration));

                            case "acid volume": avolume = Calculations.calculateFourth(Integer.parseInt(BaseConcentration),Integer.parseInt(BaseVolume),Integer.parseInt(AcidVolume));
                            }
                            break;

                    case 4:
                        boolean balanced = Calculations.calculate(Integer.parseInt(AcidConcentration),Integer.parseInt(AcidVolume),Integer.parseInt(BaseVolume),Integer.parseInt(BaseVolume));
                            if(balanced){
                                System.out.println("yeah it is good");
                            }else{
                                System.out.println("try to make it balanced...or leave one or two Textfield blank"); }
                            break;
                    default: System.out.println("nothing is there... please input something");
                            break;
                    }
            }
        };

      simulationView.getStartButton().setOnAction(startHandler);



    }

   int PickCase(ControlPanelView controlPanelView){
       int c = 4;

           BaseVolume = controlPanelView.getVolumeBase().getText();
           AcidVolume = controlPanelView.getVolumeAcid().getText();
           BaseConcentration = controlPanelView.getConcentrationBase().getText();
           AcidConcentration = controlPanelView.getConcentrationAcid().getText();
           String[] Parameters = {AcidConcentration, BaseConcentration, AcidVolume, BaseVolume};
           if (BaseConcentration.isEmpty() && BaseVolume.isEmpty()) {
               baseAllEmpty = true;
           }
           if (AcidConcentration.isEmpty() && AcidVolume.isEmpty()) {
               acidAllEmpty = true;
           }

           for (String str : Parameters) {
               if (str.isEmpty()) {
                   c--;
               }
           }
           return c;
       }

    public String WhatIsMissing(){
        int c = 0;
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




