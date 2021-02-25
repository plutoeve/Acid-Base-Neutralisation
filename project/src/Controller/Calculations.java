package Controller;

public class Calculations {

    //balance equation
    static Boolean calculate(int c1, int v1, int c2, int v2){
        if(c1*v1==c2*v2) return true;
        else return false;
    }
    static int calculate(int c1, int v1, int value2){
        return (c1*v1/value2);
    }

    static int calculateConcentration(int c1, int v1){
        return c1;
    }

}
