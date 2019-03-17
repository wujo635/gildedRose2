package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AgedBrieTest {

    private GildedRose app;
    private Item[] items;

    @Test
    public void shouldIncreaseQualityOnUpdate() {
        this.items = new Item[]{new Item("Aged Brie", 1, 1)};
        this.app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void shouldDisallowQualityUpdateGreaterThan50() {
        this.items = new Item[]{new Item("Aged Brie", 1, 50)};
        this.app = new GildedRose(items);
        app.updateQuality();
        assertEquals(50, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseSellInOnUpdate() {
        this.items = new Item[]{new Item("Aged Brie", 1, 1)};
        this.app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void shouldDisallowNegativeQuality() {
        this.items = new Item[]{new Item("Aged Brie", 1, -2)};
        this.app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
