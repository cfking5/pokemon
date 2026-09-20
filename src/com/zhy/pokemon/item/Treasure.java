package com.zhy.pokemon.item;

public class Treasure extends Item{

    public Treasure(String name){
        super("name");
    }



    @Override
    public String getInformation() {
        return discovery ? "✪" : "■";
    }
}
