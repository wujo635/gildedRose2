package com.gildedrose;

import org.junit.Test;

import static org.junit.Assert.*;

public class GenericItemTest {

    private GildedRose app;
    private Item[] items;

    @Test
    public void shouldDecreaseSellInBy1OnUpdate() {
        this.items = new Item[]{new Item("Generic item", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].sellIn);
    }

    @Test
    public void shouldDecreaseQualityBy1OnUpdate() {
        this.items = new Item[]{new Item("Generic item", 1, 1)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }

    @Test
    public void shouldDecreaseQualityBy2WhenSellInLessThanZero() {
        this.items = new Item[]{new Item("Generic item", -1, 3)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(1, app.items[0].quality);
    }
}
