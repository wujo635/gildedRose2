package com.gildedrose;

public class SulfurasUpdater implements ItemUpdater {
    @Override
    public void update(Item item) {
        item.quality = 80;
    }
}
