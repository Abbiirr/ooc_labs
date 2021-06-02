public class Sedan extends Trip{
    public Sedan(int dist, int minutes, int noPass) {
        super(dist, minutes, noPass);
        this.passLimit = 4;
        this.distLimit = 25;
        this.type = "SEDAN";
    }


    public int perHeadFare() {
        int fare = -1;

        fare = (50 + dist * 30 + minutes * 2) / noPass;

        return fare - (fare % 5);
    }


}
