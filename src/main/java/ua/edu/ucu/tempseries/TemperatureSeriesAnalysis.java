package ua.edu.ucu.tempseries;

import java.util.Arrays;
import java.util.InputMismatchException;

public class TemperatureSeriesAnalysis{

    private double[] temperatureSeries;
    private int temperatureSeriesSize;
    private static final double maxPossTemp = 273;
    private static final double minPossTemp = -273;

    public TemperatureSeriesAnalysis() { }

    public TemperatureSeriesAnalysis(double[] temperatureSeries){
        if (temperatureSeries.length != 0 && checkFalse(temperatureSeries)){
            throw new InputMismatchException();
        }
        this.temperatureSeries = Arrays.copyOf(temperatureSeries,
                temperatureSeries.length);
        temperatureSeriesSize = temperatureSeries.length;
    }

    public boolean checkFalse(double[] temperatureSeries){
        for(double temp: temperatureSeries){
            if (!(temp <= minPossTemp)){
                return false;
            }}
        return true;
    }

    public double sumTemp(double[] temperatureSeries){
        double sumArray = 0;
        for (double temp: temperatureSeries){
            sumArray += temp;
        }
        return sumArray;
    }

    public double average(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        return sumTemp(temperatureSeries)/temperatureSeries.length;
    }

    public double deviation(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double sd = 0;
        for (double temp: temperatureSeries){
            sd += Math.pow(Math.abs(temp - average()), 2);
        }
        return Math.sqrt(sd/temperatureSeries.length);
    }

    public double min(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        return findTempClosestToValue(minPossTemp);
    }

    public double max(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        return findTempClosestToValue(maxPossTemp);
    }

    public double findTempClosestToZero(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        return findTempClosestToValue(0);
    }

    public double findTempClosestToValue(double tempValue){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double result = 0;
        double diff = Double.POSITIVE_INFINITY;
        for (int i = 0; i < temperatureSeriesSize; i++){
            double currentDiff = Math.abs(temperatureSeries[i] - tempValue);
            if (currentDiff < diff){
                result = temperatureSeries[i];
                diff = currentDiff;
            }}
        return result;
    }

    public double[] findTempsLessThen(double tempValue){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] lessTemps = new double[temperatureSeriesSize];
        int idx = 0;
        for (int i = 0; i < temperatureSeriesSize; i++) {
            if (temperatureSeries[i] < tempValue) {
                lessTemps[idx] = temperatureSeries[i];
                idx++;
            }}
        lessTemps = Arrays.copyOf(lessTemps, idx);
        return lessTemps;
    }

    public double[] findTempsGreaterThen(double tempValue){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double[] greaterTemps = new double[temperatureSeriesSize];
        int idx = 0;
        for (int i = 0; i < temperatureSeriesSize; i++){
            if (temperatureSeries[i] > tempValue){
                greaterTemps[idx] = temperatureSeries[i];
                idx++;
            }
        }
        greaterTemps = Arrays.copyOf(greaterTemps, idx);
        return greaterTemps;
    }

    public TempSummaryStatistics summaryStatistics(){
        if (temperatureSeries.length == 0) {
            throw new IllegalArgumentException();
        }
        double avgTemp = average();
        double devTemp = deviation();
        double minTemp = min();
        double maxTemp = max();
        return new TempSummaryStatistics(avgTemp, devTemp, minTemp, maxTemp);
    }

    public int addTemps(double... temps){
        if (checkFalse(temps)){
            throw new InputMismatchException();
        }
        for (double temp : temps){
            if (temperatureSeries.length == temperatureSeriesSize) {
                temperatureSeries = Arrays.copyOf(temperatureSeries,
                        temperatureSeries.length * 2);
            }
            temperatureSeries[temperatureSeriesSize] = temp;
            temperatureSeriesSize++;
        }
        double result = sumTemp(temperatureSeries);
        return (int)result;
    }
}
