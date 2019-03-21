package com.gildedrose;

import org.junit.Ignore;
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

    @Test
    public void shouldIncreaseQualityBy1IfSellInGreaterThan10() {
        this.items = new Item[]{new Item(name, 11, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseQualityBy2IfSellInBetween6And10() {
        this.items = new Item[]{new Item(name, 10, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(3, app.items[0].quality);
    }

    @Test
    public void shouldIncreaseQualityBy3IfSellInLessThan5() {
        this.items = new Item[]{new Item(name, 5, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseSellInOnUpdate() {
        this.items = new Item[]{new Item(name, 5, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(4, app.items[0].sellIn);
    }

    @Test
    public void shouldHaveQualityZeroAfterSellIn() {
        this.items = new Item[]{new Item(name, 0, 10)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

}
