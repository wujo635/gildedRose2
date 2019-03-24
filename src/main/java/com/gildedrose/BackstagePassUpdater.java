package com.gildedrose;

public class BackstagePassUpdater implements ItemUpdater {

    @Override
    public void update(Item item) {
        if (item.sellIn > 10) {
            item.quality++;
        } else if (item.sellIn > 5) {
            item.quality += 2;
        } else if (item.sellIn > 0) {
            item.quality += 3;
        } else {
            item.quality = 0;
        }
        item.sellIn--;
        ItemUpdater.boundCheck(item);
    }
}
