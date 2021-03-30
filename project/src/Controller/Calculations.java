package Controller;

public class Calculations {

    //balance equation

    //if there is 4 input parameters
    static Boolean calculate(double c1, double v1, double c2, double v2){
        System.out.println(c1+" "+v1+" "+c2+" "+v2);
        boolean b = false;
        if(c1*v1 == c2*v2){ b = true;}
        return b;
    }

    //if there is 3 input parameters
    static double calculateFourth(double c1, double v1, double value2){
        return (c1*v1/value2);
    }


}
