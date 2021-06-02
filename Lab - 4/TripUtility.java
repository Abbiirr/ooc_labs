import java.util.function.IntBinaryOperator;

public class TripUtility {
    protected Trip trip;

    public TripUtility (Trip trip) {
        this.trip = trip;
    }



    public String requestTrip() {
        String output = "";
        System.out.println("== Ride Swift in Bike ==");
        output += "== Ride Swift in Bike ==\n";
        if (canTakeTrip()) {
            System.out.println(trip.dist + " KM");
            System.out.println(trip.minutes + " Minutes");
            System.out.println(trip.perHeadFare() + " Taka Per Person");

            output += trip.dist + " KM\n";
            output += trip.minutes + " Minutes\n";
            output += trip.perHeadFare() + " Taka Per Person";
        } else {
            System.out.println("Invalid Trip Request");

            output += "Invalid Trip Request";
        }

        return output;
    }

    public boolean checkIfMoreThanMinPass() {
        if (trip.noPass < 1)
        {
            System.out.println("Number of passengers must be at least 1.\n");
            return false;
        }
        return true;
    }

    public boolean checkIfNotMoreThanMaxPass() {
        if(trip.noPass > trip.passLimit )
        {
            System.out.println("Trip exceedes passenger.");
            return false;
        }
        return true;

    }

    public boolean checkIfNotMoreThanMaxDist() {
        if(!trip.type.equals("SEVEN_SEATER") &&  trip.dist > trip.distLimit)
        {
            System.out.println("Trip exceedes distance limit.");
            return false;
        }
        return true;

    }

    public boolean checkIfNotMoreThanMaxDistSevenSeater() {
        if(trip.type.equals("SEVEN_SEATER") && trip.dist < trip.distLimit)
        {
            System.out.println("Trip is less than minimum distance limit.");
            return false;
        }
        return true;

    }


    public boolean canTakeTrip() {
        return checkIfMoreThanMinPass() && checkIfNotMoreThanMaxPass() && checkIfNotMoreThanMaxDist() && checkIfNotMoreThanMaxDistSevenSeater();

    }

    public double calculateFare() {
        return trip.perHeadFare();

    }
}
