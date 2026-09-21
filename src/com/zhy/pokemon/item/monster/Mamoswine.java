package com.zhy.pokemon.item.monster;

import com.zhy.pokemon.util.Tools;

public class Mamoswine extends Monster {
    public Mamoswine() {
        super("象牙猪");
        this.attack = Tools.getRandomNumber(45, 55);
        this.defense = Tools.getRandomNumber(35, 45);
        this.health = Tools.getRandomNumber(600, 800);
        this.currentHealth = this.health;
    }

    @Override
    public String getInformation() {
        return name + "：攻击=" + getAttack() + " 防御=" + getDefense() + " 生命值=" + getHealth();
    }
}
