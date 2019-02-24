package com.asmarasoftwaresolutions.domain_layer.computations;

public class ComputationsInterfaceImpl implements ComputationsInterface{

    private double mCentimeterInchConstant = 2.54;
    private double mlbKgConstant = 2.205;

    @Override
    public double celsiusToFrenheit(String celcius) {
        double arg;
        try{
            arg = Double.parseDouble(celcius);
            return (arg * 9/5) + 32;
        }catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }
        return 0;
    }

    @Override
    public double frenheitToCelcius(String frenheit) {
        double arg;
        try{
            arg = Double.parseDouble(frenheit);
            return (arg - 32) * 5/9;
        }catch(IllegalArgumentException iae){
            iae.printStackTrace();
        }
        return 0;
    }

    @Override
    public double centimeterToInches(String centimeter) {
        try {
            double arg = Double.parseDouble(centimeter);
            return arg * mCentimeterInchConstant;
        }catch (IllegalArgumentException ea){
            ea.printStackTrace();
        }
        return 0;
    }

    @Override
    public double inchesToCentimeter(String inches) {
        try {
            double arg = Double.parseDouble(inches);
            return arg / mCentimeterInchConstant;
        }catch (IllegalArgumentException ea){
            ea.printStackTrace();
        }
        return 0;
    }

    @Override
    public double kgToLb(String kg) {
        try{
            double arg = Double.parseDouble(kg);
            return arg / mlbKgConstant;
        }catch (IllegalArgumentException ea){
            ea.printStackTrace();
        }
        return 0;
    }

    @Override
    public double lbToKg(String lb) {
        try{
            double arg = Double.parseDouble(lb);
            return arg * mlbKgConstant;
        }catch (IllegalArgumentException ea){
            ea.printStackTrace();
        }
        return 0;
    }
}
