package com.gildedrose;

import org.junit.Test;
import static org.junit.Assert.*;

public class SulfurasTest {

    private GildedRose app;
    private Item[] items;
    private String name = "Sulfuras, Hand of Ragnaros";

    @Test
    public void shouldAlwaysHaveQuality80() {
        this.items = new Item[]{new Item(name, 1,0)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(80, app.items[0].quality);
    }

    @Test
    public void shouldDisallowSellInChanges() {
        this.items = new Item[]{new Item(name, 1,0)};
        this.app = new GildedRose(items);
        this.app.updateQuality();
        assertEquals(1, app.items[0].sellIn);
    }
}
