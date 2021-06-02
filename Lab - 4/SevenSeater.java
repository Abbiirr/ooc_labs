public class SevenSeater extends Trip{

    public SevenSeater(int dist, int minutes, int noPass) {
        super(dist, minutes, noPass);
        this.passLimit = 7;
        this.distLimit = 10;
        this.type = "SEVEN_SEATER";
    }




    public int perHeadFare() {
        int fare = -1;

        if (dist < 10)
            fare = 300 / noPass;
        else
            fare = (dist * 30) / noPass;

        return fare - (fare % 5);
    }

}
