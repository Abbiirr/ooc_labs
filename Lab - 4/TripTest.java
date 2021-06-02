

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;

import static org.junit.jupiter.api.Assertions.*;
class MotorBikeTest {
    TripUtility trip;

    @Test
    public void fareLessThan25() {
        trip = new TripUtility (new MotorBike(1, 2, 1));
        double actual = trip.calculateFare();

        Assertions.assertEquals(25, actual);
    }

    @Test
    public void MotorBike_MoreThan25() {
        trip = new TripUtility (new MotorBike(5, 15, 1));
        double actual = trip.calculateFare();
        Assertions.assertEquals(100, actual);
    }


    @Test
    public void requestTripMotorBike() {
        trip =new TripUtility(new MotorBike(5, 200, 1));
        String actual = trip.requestTrip();
        Assertions.assertEquals("== Ride Swift in Bike ==\n" +
                "5 KM\n" +
                "200 Minutes\n" +
                "100 Taka Per Person", actual);
    }

    @Test
    public void canGoOrNotMotorBike() {
        trip = new TripUtility (new MotorBike(1, 2, 1));
        boolean actual = trip.canTakeTrip();
        Assertions.assertTrue( actual);
    }
}

class SedanTest {

    TripUtility trip;

    @Test
    public void Sedan() {
        trip = new TripUtility (new Sedan(10, 10, 3));
        double actual = trip.calculateFare();
        Assertions.assertEquals(120, actual);
    }


    @Test
    public void requestTripSedan() {
        trip = new TripUtility (new Sedan(25, 200, 4));
        String actual = trip.requestTrip();
        Assertions.assertEquals("== Ride Swift in Bike ==\n" +
                "25 KM\n" +
                "200 Minutes\n" +
                "300 Taka Per Person", actual);
    }

    @Test
    public void canGoOrNotSedan() {
        trip = new TripUtility (new Sedan(1, 2, 1));
        boolean actual = trip.canTakeTrip();
        Assertions.assertTrue( actual);
    }

}
class SevenSeaterTest {
    TripUtility trip;


    @Test
    public void SevenSeater_LessThan10KM() {
        trip = new TripUtility (new SevenSeater(1, 2, 7));
        double actual = trip.calculateFare();
        Assertions.assertEquals(40, actual);
    }

    @Test
    public void SevenSeater_MoreThan2KM() {
        trip = new TripUtility (new SevenSeater(100, 200, 6));
        double actual = trip.calculateFare();
        Assertions.assertEquals(500, actual);
    }

    @Test
    public void requestTripSevenSeater() {
        trip = new TripUtility (new SevenSeater(100, 200, 6));
        String actual = trip.requestTrip();
        Assertions.assertEquals("== Ride Swift in Bike ==\n" +
                "100 KM\n" +
                "200 Minutes\n" +
                "500 Taka Per Person", actual);
    }


    @Test
    public void canGoOrNotSevenSeater() {
        trip = new TripUtility (new SevenSeater(11, 2, 1));
        boolean actual = trip.canTakeTrip();
        Assertions.assertTrue(actual);
    }

}

class TripTest {

    TripUtility trip;

    //do not yet know how to run all the test classes at once.

}