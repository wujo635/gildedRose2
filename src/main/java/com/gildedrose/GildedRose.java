package com.gildedrose;

class GildedRose {
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
        if (isAgedBrie(item)) {
            updater = new AgedBrieUpdater();
            updater.update(item);
            ItemUpdater.boundCheck(item);
        } else if (isBackstagePass(item)) {
            updater = new BackstagePassUpdater();
            updater.update(item);
            ItemUpdater.boundCheck(item);
        } else if (isSulfuras(item)) {
            updater = new SulfurasUpdater();
            updater.update(item);
        } else {
            updater = new GeneralItemUpdater();
            updater.update(item);
            ItemUpdater.boundCheck(item);
        }
    }

    private boolean isSulfuras(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isAgedBrie(Item item) {
        return item.name.equals("Aged Brie");
    }

    private boolean isBackstagePass(Item item) {
        return item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

}