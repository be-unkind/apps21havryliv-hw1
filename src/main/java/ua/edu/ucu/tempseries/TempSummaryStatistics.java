package ua.edu.ucu.tempseries;

public class TempSummaryStatistics {
    private final double avgTemp;
    private final double devTemp;
    private final double minTemp;
    private final double maxTemp;


    public TempSummaryStatistics(double avgTemp, double devTemp,
                                 double minTemp, double maxTemp) {
        this.avgTemp = avgTemp;
        this.devTemp = devTemp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        return "TempSummaryStatistics{"
                + "avgTemp=" + avgTemp
                + ", devTemp=" + devTemp
                + ", minTemp=" + minTemp
                + ", maxTemp=" + maxTemp
                + '}';
    }
}
