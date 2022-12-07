package FindMaxBandwidth_Q;

import java.time.LocalTime;

public class Show {
    private int channel;
    private LocalTime ShowStartTime;
    private LocalTime ShowEndTime;
    private int BandwidthRequired;

    public Show(int channel, LocalTime showStartTime, LocalTime showEndTime, int bandwidthRequired) {
        this.channel = channel;
        ShowStartTime = showStartTime;
        ShowEndTime = showEndTime;
        BandwidthRequired = bandwidthRequired;
    }

    public int getChannel() {
        return channel;
    }

    public void setChannel(int channel) {
        this.channel = channel;
    }

    public LocalTime getShowStartTime() {
        return ShowStartTime;
    }

    public void setShowStartTime(LocalTime showStartTime) {
        ShowStartTime = showStartTime;
    }

    public LocalTime getShowEndTime() {
        return ShowEndTime;
    }

    public void setShowEndTime(LocalTime showEndTime) {
        ShowEndTime = showEndTime;
    }

    public int getBandwidthRequired() {
        return BandwidthRequired;
    }

    public void setBandwidthRequired(int bandwidthRequired) {
        BandwidthRequired = bandwidthRequired;
    }

    @Override
    public String toString() {
        return "FindMaxBandwidth_Q.Show{" +
                "channel=" + channel +
                ", ShowStartTime=" + ShowStartTime +
                ", ShowEndTime=" + ShowEndTime +
                ", BandwidthRequired=" + BandwidthRequired +
                '}';
    }
}

