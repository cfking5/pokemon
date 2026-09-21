package com.zhy.pokemon.item.pokemon;

import com.zhy.pokemon.item.Item;
import com.zhy.pokemon.item.monster.Monster;

public abstract class Pokemon extends Item {


    protected int health;

    protected int attack;

    protected int defense;

    protected int currentHealth;

    protected int star;

    public Pokemon(String name) {
        super(name);
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    @Override
    public String getInformation() {
        return name + "：攻击=" + getAttack() + " 防御=" + getDefense() + " 生命值=" + getHealth();
    }

    /**
     * 融合精灵升星
     * @param other 要被吞噬的精灵
     */
    public void merge(Pokemon other) {
        if(star == 10){
            System.out.println(name + "星级已满，无法再融合升星");
        } else {
            this.attack += (other.attack >> 1);
            this.defense += (other.defense >> 1);
            this.health += (other.health >> 1);
            star += 1;
            System.out.println("融合成功");
            System.out.println(getInformation());
        }
    }

    public void attackMonster(Monster monster) {
        int minusHealth = this.attack * this.attack / monster.getDefense();
        if(minusHealth == 0) minusHealth = 1;
        else if(minusHealth > monster.getCurrentHealth()) minusHealth = monster.getCurrentHealth();
        int restHealth = monster.getCurrentHealth() - minusHealth;
        monster.setCurrentHealth(restHealth);
        System.err.println(name + "对" + monster.getName() + "发动攻击，造成了" + minusHealth + "伤害");
    }
}
