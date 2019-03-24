package com.gildedrose;

import java.util.HashMap;
import java.util.Map;

class GildedRose {

    private static Map<String, ItemUpdater> itemUpdaterMap;
    static {
        itemUpdaterMap = new HashMap<>();
        itemUpdaterMap.put("Aged Brie", new AgedBrieUpdater());
        itemUpdaterMap.put("Backstage passes to a TAFKAL80ETC concert", new BackstagePassUpdater());
        itemUpdaterMap.put("Sulfuras, Hand of Ragnaros", new SulfurasUpdater());
        itemUpdaterMap.put("Conjured Item", new ConjuredItemUpdater());
    }

    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (Item item : items) {
            updateItem(item);
        }
    }

    private void updateItem(Item item) {
        ItemUpdater updater;
        if (itemUpdaterMap.containsKey(item.name)) {
            updater = itemUpdaterMap.get(item.name);
        } else {
            updater = new GeneralItemUpdater();
        }
        updater.update(item);
    }

}