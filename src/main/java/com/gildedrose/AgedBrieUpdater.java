package com.gildedrose;

public class AgedBrieUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.quality++;
        item.sellIn--;
        ItemUpdater.boundCheck(item);
    }
}
