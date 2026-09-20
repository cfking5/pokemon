package com.zhy.pokemon.item;
import com.zhy.pokemon.HP;
import com.zhy.pokemon.util.Tools;

public class Treasure extends Item{

    public Treasure(String name){
        super("name");
    }

    public Item open(){
        return Tools.getRandomItem();
    }

    @Override
    public String getInformation() {
        return discovery ? "✪" : "■";
    }
}
