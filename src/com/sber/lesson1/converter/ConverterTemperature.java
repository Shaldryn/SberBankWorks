package com.sber.lesson1.converter;

public class ConverterTemperature {

    public void convertFahrenheit(double temp) {
        double result = (temp * 9 / 5) + 32;
        System.out.printf("%.2f °C", result);
    }

    public void convertKelvin(double temp) {
        double result = temp + 273.15;
        System.out.printf("%.2f K", result);
    }

    public void convertRankine(double temp) {
        double result = (temp * 9 / 5) + 491.67;
        System.out.printf("%.2f °R", result);
    }


    public static void main(String[] args) {
        ConverterTemperature converterTemperature = new ConverterTemperature();
        double temp = 25.6;

        converterTemperature.convertFahrenheit(temp);
        System.out.println();
        converterTemperature.convertKelvin(temp);
        System.out.println();
        converterTemperature.convertRankine(temp);
        System.out.println();

    }
}
