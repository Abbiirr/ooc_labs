class Inventory {
    Item[] items;
    int i=0;

    public Inventory(Item[] items) { this.items = items; }

    public int updateQualityAgedBrie(Item item) {
        if(item.name.equals("Aged Brie") && item.quality <50)
        {
            //System.out.println("Aged Brie.");

            ++item.quality;
        }

        return item.quality;
    }

    public int updateQualityBackstagePassWithinLimit(Item item, int higherLimit) {
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.quality <50 && item.sellIn > 0 && item.sellIn < higherLimit)
        {
            ++item.quality;

            //System.out.println("Backstage pass" + 0 + " " + higherLimit);
            //System.out.println(item.quality);
        }

        return item.quality;
    }

    public int updateQualityBackstagePassBeforeSellIn(Item item) {
        if(item.name.equals("Backstage Pass") && item.quality <50 && item.sellIn > 0)
        {
            ++item.quality;
        }

        return item.quality;
    }

    public int updateQualityBackstagePass(Item item) {
        if(item.name.equals("Backstage passes to a TAFKAL80ETC concert") && item.quality <50 && item.sellIn <= 0)
        {
            return 0;
        }
        item.quality = updateQualityBackstagePassWithinLimit(item,11);
        item.quality = updateQualityBackstagePassWithinLimit(item,6);
        item.quality = updateQualityBackstagePassWithinLimit(item, Integer.MAX_VALUE);

        return item.quality;
    }


    public int updateQualitySulfuras(Item item) {
        if(item.name.equals("Sulfuras, Hand of Ragnaros"))
        {
            //System.out.println("Sulfuras");
            item.quality = 80;
        }

        return item.quality;
    }

    public int updateQualityOrdinaryItemsBeforeSellIn(Item item) {
        if(!item.name.equals("Sulfuras, Hand of Ragnaros") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Aged Brie") && item.quality > 0 && item.sellIn > 0)
        {
            //System.out.println("Ordinary item found.");
            --item.quality;
        }

        return item.quality;
    }

    public int updateQualityOrdinaryItemsAfterSellIn(Item item) {
        if(!item.name.equals("Sulfuras, Hand of Ragnaros") && !item.name.equals("Backstage passes to a TAFKAL80ETC concert")
                && !item.name.equals("Aged Brie") && item.quality > 0 && item.sellIn <=0)
        {
            //System.out.println("Ordinary item found.");
            item.quality -= 2;
        }

        return item.quality;
    }

    //After refactoring

    public void updateQuality() {   //this method updates the quality for one day
        for (Item item : items) {
            //System.out.println(i);

            item.quality = updateQualityAgedBrie(item);
            item.quality = updateQualityBackstagePass(item);
            item.quality = updateQualitySulfuras(item);
            item.quality = updateQualityOrdinaryItemsBeforeSellIn(item);
            item.quality = updateQualityOrdinaryItemsAfterSellIn(item);

            //i++;
        }




    }
}