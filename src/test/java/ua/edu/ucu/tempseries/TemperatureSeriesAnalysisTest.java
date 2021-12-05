package ua.edu.ucu.tempseries;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.InputMismatchException;

public class TemperatureSeriesAnalysisTest {

    @Test(expected = InputMismatchException.class)
    public void testCheckFalse(){
        double[] temperatureSeries = {-1000};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.checkFalse(temperatureSeries);
    }

    @Test
    public void testAverageWithOneElementArray() {
        // setup input data and expected result
        double[] temperatureSeries = {-1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = -1.0;

        // call tested method
        double actualResult = seriesAnalysis.average();

        // compare expected result with actual result
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAverageWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);

        // expect exception here
        seriesAnalysis.average();
    }

    @Test
    public void testAverage() {
        double[] temperatureSeries = {3.0, -5.0, 1.0, 5.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double expResult = 1.0;

        double actualResult = seriesAnalysis.average();
        
        assertEquals(expResult, actualResult, 0.00001);
    }

    @Test
    public void testSum() {
        double[] temperatureSeries = {3.5, 0.5, 2.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(6.3, seriesAnalysis.sumTemp(temperatureSeries), 0.00001);
    }

    @Test
    public void testDeviation() {
        double[] temperatureSeries = {3.5, 0.5, 2.3};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(1.232882801, seriesAnalysis.deviation(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testDeviationWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.deviation();
    }

    @Test
    public void testMin() {
        double[] temperatureSeries = {-1.3, 4.5, -200.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(-200.4, seriesAnalysis.min(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMinWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.min();
    }

    @Test
    public void testMax() {
        double[] temperatureSeries = {-1.3, 4.5, -200.4};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(4.5, seriesAnalysis.max(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMaxWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.max();
    }

    @Test
    public void testTempClosestToValue() {
        double[] temperatureSeries = {2.5, 3.5, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(3.5, seriesAnalysis.findTempClosestToValue(4.5), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTempClosestToValueWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToValue(2.5);
    }

    @Test
    public void testTempClosestToZero() {
        double[] temperatureSeries = {2.5, 3.5, 1.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(1.0, seriesAnalysis.findTempClosestToZero(), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testTempClosestToZeroWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempClosestToZero();
    }

    @Test
    public void testFindTempLessThan() {
        double[] temperatureSeries = {2.5, 5.2, 200.5, -25.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expect = new double[] {2.5, 5.2, -25.5};
        assertArrayEquals(expect, seriesAnalysis.findTempsLessThen(10), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempLessThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsLessThen(5.1);
    }

    @Test
    public void testFindTempGreaterThan() {
        double[] temperatureSeries = {2.5, 5.2, 200.5, -25.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        double[] expect = new double[] {5.2, 200.5};
        assertArrayEquals(expect, seriesAnalysis.findTempsGreaterThen(5), 0.00001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFindTempGreaterThanWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.findTempsGreaterThen(5.1);
    }

    @Test
    public void testSummaryStatistics() {
        double[] temperatureSeries = {1.0, 2.0, -5.0, 15.0};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(new TempSummaryStatistics(3.25, 7.292976072907411, -5.0, 15.0).toString(),
                seriesAnalysis.summaryStatistics().toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSummaryStatisticsWithEmptyArray() {
        double[] temperatureSeries = {};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        seriesAnalysis.summaryStatistics();
    }

    @Test
    public void testAddTemps() {
        double[] temperatureSeries = {1.0};
        double[] temps = {2.5, 3.5};
        TemperatureSeriesAnalysis seriesAnalysis = new TemperatureSeriesAnalysis(temperatureSeries);
        assertEquals(7, seriesAnalysis.addTemps(temps));
    }

}
