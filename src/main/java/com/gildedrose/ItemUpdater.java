package com.gildedrose;

public interface ItemUpdater {

    void update(Item item);

    static void boundCheck(Item item) {
        item.quality = Math.max(0, Math.min(item.quality, 50));
    }

}
