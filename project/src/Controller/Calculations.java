package Controller;

public class Calculations {

    //balance equation

    //if there is 4 input parameters
    static Boolean calculate(int c1, int v1, int c2, int v2){
        if(c1*v1==c2*v2) return true;
        else return false;
    }

    //if there is 3 input parameters
    static int calculateFourth(int c1, int v1, int value2){
        return (c1*v1/value2);
    }


}
