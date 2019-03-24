package com.gildedrose;

import static org.junit.Assert.*;

import com.gildedrose.GildedRose;
import com.gildedrose.Item;
import org.junit.Test;

public class GildedRoseTest {

    @Test
    public void foo() {
        Item[] items = new Item[]{new Item("foo", 0, 0)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals("foo", app.items[0].name);
    }

    @Test
    public void shouldUpdateAgedBrie() {
        Item[] items = new Item[]{new Item("Aged Brie", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(2, app.items[0].quality);
    }

    @Test
    public void shouldUpdateBackstagePass() {
        Item[] items = new Item[]{new Item("Backstage passes to a TAFKAL80ETC concert", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(4, app.items[0].quality);
    }

    @Test
    public void shouldUpdateSulfuras() {
        Item[] items = new Item[]{new Item("Sulfuras, Hand of Ragnaros", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void shouldUpdateGeneralItem() {
        Item[] items = new Item[]{new Item("Item", 1, 1)};
        GildedRose app = new GildedRose(items);
        app.updateQuality();
        assertEquals(0, app.items[0].quality);
    }
}