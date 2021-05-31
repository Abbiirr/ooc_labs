import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


public class InventoryTest {
    int expectedValue;
    Item[] items;
    Inventory app;
    int i = 4;  //just change value of this variable to test different items. Within 0 <-> 4

    @Test
    @DisplayName("Run for Aged Brie")
    @BeforeEach
    void initInventory() {
        items = new Item[] { new Item("Aged Brie", 3, 25) ,
                new Item("Backstage passes to a TAFKAL80ETC concert", 3, 25),
                new Item("Sulfuras, Hand of Ragnaros", 3, 12),
                new Item("A", -1, 5),
                new Item("B", 3, 12)
        };
        app = new Inventory(items);
    }

    @Test
    @DisplayName("Checks if the given name is valid or not")
    void testIfNameValid() {

        //System.out.println(app.items[i].name);

        assertNotEquals("", app.items[i].name, "You must give a name to an item.");
    }

   @Test
   @DisplayName("Checks if the given quality is valid except for Sulfuras.")
    void testIfQualityValid() {
        if(!app.items[i].name.equals("Sulfuras, Hand of Ragnaros"))
        {
            //System.out.println(app.items[i].quality);

            assertTrue(app.items[i].quality > 0 && app.items[i].quality < 51, "Quality can never be less than 0 or more than 50 except for Sulfuras.");
        }

    }

    @Test
    @DisplayName("Checks if the given quality is valid for Sulfuras.")
    void qualityNotValidSulfuras() {
        if(app.items[i].name.equals("Sulfuras, Hand of Ragnaros"))
        {
            //System.out.println(app.items[i].quality);

            assertTrue(app.items[i].quality > 0 && app.items[i].quality < 81, "Quality can never be more than 80 or less than 0.");
        }

    }


    @Test
    @DisplayName("Test name and quality for Aged Brie")
    void testQualityAgedBrie() {    //checks the quality of Aged Brie

        expectedValue = items[i].quality;
        if(app.items[i].name.equals("Aged Brie") && expectedValue < 50)  //if quality is less than 50
        {
            expectedValue++;    //than it should increase by 1
            app.updateQuality();

            System.out.println(expectedValue);
            System.out.println(app.items[i].quality);

            assertEquals(expectedValue, app.items[i].quality, "Quality should increase by 1.");
        }

    }

    @Test
    @DisplayName("Test BackstagePass at least 11 days before sellIn")
    void testQualityBackstagePass() {

        expectedValue = items[i].quality;
        if(app.items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") &&
                expectedValue < 50 && (app.items[i].sellIn > 10 || app.items[i].sellIn < 1))  //if quality is less than 50 && sellIn more than 10 or less than 1
        {
            expectedValue++;    //than it should increase by 1
            app.updateQuality();

            if(app.items[i].sellIn <=0)
                expectedValue =0;

            System.out.println(expectedValue);
            System.out.println(app.items[i].quality);

            assertEquals(expectedValue, app.items[i].quality, "Quality should increase by 1.");
        }

    }

    //Need to know how enable a test within a range
    @Test
    @DisplayName("Test BackstagePass within 10 to 6 days before sellIn")

    void testQualityBackstagePassBefore10To6Days() {


        expectedValue = items[i].quality;
        if(app.items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") &&
                expectedValue < 50 && app.items[i].sellIn > 5 && app.items[i].sellIn < 11)  //if quality is less than 50 && sellIn more than 5 and less than 11
        {
            expectedValue += 2;    //than it should increase by 2
            app.updateQuality();

            System.out.println(expectedValue);
            System.out.println(app.items[i].quality);

            assertEquals(expectedValue, app.items[i].quality, "Quality should increase by 2.");
        }

    }

    @Test
    @DisplayName("Test BackstagePass within 5 to 1 day before sellIn")
    void testQualityBackstagePassBefore5To1Day() {


        expectedValue = items[i].quality;
        if(app.items[i].name.equals("Backstage passes to a TAFKAL80ETC concert") &&
                expectedValue < 50 && app.items[i].sellIn > 0 && app.items[i].sellIn < 6)  //if quality is less than 50 && sellIn more than 0 and less than 6
        {
            expectedValue += 3;    //than it should increase by 2
            app.updateQuality();

            System.out.println(expectedValue);
            System.out.println(app.items[i].quality);

            assertEquals(expectedValue, app.items[i].quality, "Quality should increase by 3");
        }

    }

    @Test
    @DisplayName("Test Sulfuras, quality should be always 80")
    void testQualitySulfuras() {

        if(app.items[i].name.equals("Sulfuras, Hand of Ragnaros"))
        {
            app.updateQuality();

            //System.out.println(app.items[i].quality);

            assertEquals(80, app.items[i].quality, "Quality of Sulfuras should always be 80.");
        }

    }

    @Test
    @DisplayName("Only runs if item is not special item and before sellIn")
    void testQualityOrdinaryItemsBeforeSellIn() {

        expectedValue = items[i].quality;
        if(!app.items[i].name.equals("Sulfuras, Hand of Ragnaros") && !app.items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !app.items[i].name.equals("Aged Brie") && expectedValue > 0 && app.items[i].sellIn >0)     //if quality is greater than 0
        {
            expectedValue--;    //than it should decrease by 1
            app.updateQuality();

            //System.out.println(app.items[i].quality);

            assertEquals(expectedValue, app.items[i].quality, "Any ordinary item should decrease quality by 1");
        }

    }

    @Test
    @DisplayName("Only runs if item is not special item and after sellIn date")
    void testQualityOrdinaryItemsAfterSellIn() {

        expectedValue = items[i].quality;
        if(!app.items[i].name.equals("Sulfuras, Hand of Ragnaros") && !app.items[i].name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !app.items[i].name.equals("Aged Brie") && expectedValue > 0 && app.items[i].sellIn <= 0)     //if quality is greater than 0
        {
            expectedValue -= 2;    //than it should decrease by 1
            app.updateQuality();

            //System.out.println(app.items[i].quality);

            assertEquals(expectedValue, app.items[i].quality, "Any ordinary item should decrease quality by 1");
        }

    }

}