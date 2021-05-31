import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.*;
import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

public class _99BottlesSongTest {
    _99BottlesSong song1;
    String expected = "";
    String found = "";
    int numberOfBottles = -1;
    @BeforeEach
    public void shouldRunBeforeEachTest() {
        song1 = new _99BottlesSong();
    }


    @Test
    @DisplayName("Tests song method.")
    public void songTest() {
        song1 = new _99BottlesSong();
        if(numberOfBottles == 1)
        {
            expected += "1 bottle of milk on the wall, 1 bottle of milk.\nTake it down and pass it around, no more bottles of milk on the wall.";
            Assertions.assertEquals("1 bottle of milk on the wall, 1 bottle of milk.\n", song1.firstLine(numberOfBottles));
        }
        else if(numberOfBottles > 2)
        {
            expected += "" + numberOfBottles + " bottles of milk on the wall, " +numberOfBottles+ " bottles of milk.\n";
            numberOfBottles--;
            expected += "Take one down and pass it around, " + numberOfBottles +" bottles of milk on the wall.";
            Assertions.assertEquals(expected, song1.song(numberOfBottles+1));
        }
        else if(numberOfBottles == 2)
        {
            expected += "" + numberOfBottles + " bottles of milk on the wall, " +numberOfBottles+ " bottles of milk.\n";
            numberOfBottles--;
            expected += "Take one down and pass it around, " + numberOfBottles +" bottle of milk on the wall.";
            Assertions.assertEquals(expected, song1.song(numberOfBottles+1));
        }
        else if(numberOfBottles == 0)
        {
            expected += "No more bottles of milk on the wall, no more bottles of milk.\nGo to the store and buy some more, 99 bottles of milk on the wall.";
            Assertions.assertEquals(expected, song1.firstLine(numberOfBottles));
        }
    }

    @Test
    @DisplayName("Tests firstLine method.")
    public void firstLineTest() {
        song1 = new _99BottlesSong();
        if(numberOfBottles == 1)
        {
            expected += "" + numberOfBottles + " bottles of milk on the wall, " +numberOfBottles+ " bottle of milk.\n";
            Assertions.assertEquals("1 bottle of milk on the wall, 1 bottle of milk.\n", song1.firstLine(numberOfBottles));
        }
        else if(numberOfBottles > 1)
        {
            expected += "" + numberOfBottles + " bottles of milk on the wall, " +numberOfBottles+ " bottles of milk.\n";
            Assertions.assertEquals(expected, song1.firstLine(numberOfBottles));
        }
        else if(numberOfBottles == 0)
        {
            expected += "No more bottles of milk on the wall, no more bottles of milk.\nGo to the store and buy some more, 99 bottles of milk on the wall.";
            Assertions.assertEquals(expected, song1.firstLine(numberOfBottles));
        }
    }

    @Test
    @DisplayName("Tests takeDown method.")
    public void takeDownTest() {
        song1 = new _99BottlesSong();
        numberOfBottles--;
        if(numberOfBottles == 1)
        {
            expected += "1 bottle of milk on the wall, 1 bottle of milk.\n";
            Assertions.assertEquals("1 bottle of milk on the wall, 1 bottle of milk.\n", song1.firstLine(numberOfBottles));
        }
        else if(numberOfBottles > 1)
        {
            expected += "Take one down and pass it around, " + numberOfBottles +" bottles of milk on the wall.";
            Assertions.assertEquals(expected, song1.takeOneDown(numberOfBottles));
        }

    }

}