package FindMaxBandwidth_Q;

import java.time.LocalTime;

public class st {
    private LocalTime Time;
    private int Bandwidth;

    public st(LocalTime time, int bandwidth) {
        Time = time;
        Bandwidth = bandwidth;
    }

    public LocalTime getTime() {
        return Time;
    }

    public void setTime(LocalTime time) {
        Time = time;
    }

    public int getBandwidth() {
        return Bandwidth;
    }

    public void setBandwidth(int bandwidth) {
        Bandwidth = bandwidth;
    }

    @Override
    public String toString() {
        return "FindMaxBandwidth_Q.st{" +
                "Time=" + Time +
                ", Bandwidth=" + Bandwidth +
                '}';
    }




}

