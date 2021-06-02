
public abstract class Trip {
    public int dist;
    public int minutes;
    public int noPass;
    public int passLimit;
    public int distLimit;
    public String type;

    public Trip(int dist,
                int minutes,
                int noPass) {
        this.dist = dist;
        this.minutes = minutes;
        this.noPass = noPass;
    }


    public int perHeadFare() {
        int fare = -1;

        return -1;
    }

}