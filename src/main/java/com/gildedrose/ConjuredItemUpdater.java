package com.gildedrose;

public class ConjuredItemUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.quality -= 2;
        item.sellIn--;
        ItemUpdater.boundCheck(item);
    }
}
