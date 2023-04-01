public class SpecPack extends Pack implements Comparable<Pack> {
    private int time;
    private static final int LOW_TIME=9, HIGH_TIME=16, DEFAULT_TIME=9;
    public SpecPack() {
        super();
        setTime(DEFAULT_TIME);
    }

    public SpecPack(String newReceiver, String newZone, Date newDate, int newWeight, int newVolume, int newTime) {
        super(newReceiver, newZone, newDate, newWeight, newVolume);
        setTime(newTime);
    }

    public int getTime() { return time;}

    public void setTime(int newTime) {
        if (newTime>=LOW_TIME && newTime<=HIGH_TIME) time=newTime;

        else time=DEFAULT_TIME;

    }

    public String toString() {

        return super.toString()+" Time:"+time;

    }

}