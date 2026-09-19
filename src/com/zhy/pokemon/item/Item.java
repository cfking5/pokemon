package com.zhy.pokemon.item;

import com.zhy.pokemon.DisplayItem;

/**
 * 物品
 */
public abstract class Item implements DisplayItem {
    /**
     * 物品名称
     */
    protected String name;

    /**
     * 是否被探索过
     */
    protected boolean discovery;

    public Item(String name){
        this.name=name;
    }

    public void setDiscovery(boolean discovery) {
        this.discovery = discovery;
    }

    public String getName() {
        return name;
    }
}
