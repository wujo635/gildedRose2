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
        if (!isAgedBrie(item) && !isBackstagePass(item)) {
            item.quality--;
        } else {
            item.quality++;
        }
        if (isBackstagePass(item)) {
            if (item.sellIn < 6) {
                item.quality += 2;
            } else if (item.sellIn < 11) {
                item.quality++;
            }
        }
        if (!isSulfuras(item)) {
            item.sellIn--;
        }

        if (item.sellIn < 0) {
            if (!isAgedBrie(item)) {
                if (!isBackstagePass(item)) {
                    item.quality--;
                } else {
                    item.quality = 0;
                }
            } else {
                item.quality++;
            }
        }
        correctQualityBounds(item);
        if (isSulfuras(item)) {
            item.quality = 80;
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

    private void correctQualityBounds(Item item) {
        if (item.quality > 50) {
            item.quality = 50;
        } else if (item.quality < 0) {
            item.quality = 0;
        }
    }
}