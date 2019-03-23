package com.gildedrose;

public class GeneralItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        if (item.sellIn < 0) {
            item.quality -= 2;
        } else {
            item.quality--;
        }
        item.sellIn--;
    }
}
