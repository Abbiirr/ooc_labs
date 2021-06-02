public class MotorBike extends Trip{
    public MotorBike(int dist, int minutes, int noPass) {
        super(dist, minutes, noPass);
        this.passLimit = 1;
        this.distLimit = 10;
        this.type = "MOTOR_BIKE";
    }




    public int perHeadFare() {
        int fare = -1;
        fare = Math.max(25, this.dist * 20) / this.noPass;

        return fare - (fare % 5);
    }

}
