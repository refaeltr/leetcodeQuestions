package FindThePointWhereMaximumIntervalsOverlap;

public class Time {
    public int time;
    public int entry;

    public Time(int time, int entry) {
        this.time = time;
        this.entry = entry;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getEntry() {
        return entry;
    }

    public void setEntry(int entry) {
        this.entry = entry;
    }

    @Override
    public String toString() {
        return "Time{" +
                "time=" + time +
                ", entry=" + entry +
                '}';
    }
}
