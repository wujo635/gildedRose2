package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BackstagePassTest {

    private GildedRose app;
    private Item[] items;
    private String name = "Backstage passes to a TAFKAL80ETC concert";


    @Test
    public void shouldDisallowNegativeQuality() {
        this.items = new Item[]{new Item(name, 1, -1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void shouldDisallowQualityGreaterThan50() {
        this.items = new Item[]{new Item(name, 1, 51)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

}
