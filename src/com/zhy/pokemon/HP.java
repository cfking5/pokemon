package com.zhy.pokemon;

import com.zhy.pokemon.item.Item;

public class HP extends Item{

    private int count;

    public HP (int count){
        super("天山雪莲");
        this.count = count;
    }

    public int getCount(){
        return count;
    }

    /**
     * 增加药品数量
     * @param count 要增加的数量
     */
    public void addCount(int count){
        this.count += count;
    }

    /**
     * 使用增加血量
     * @return 增加的血量
     */
    public int use(){
        count--;
        return 500;
    }

    @Override
    public String getInformation() {
        return name;
    }
}
