package com.zhy.pokemon.item.monster;

import com.zhy.pokemon.item.Item;
import com.zhy.pokemon.item.pokemon.Pokemon;

public abstract class Monster extends Item {

    protected int health;

    protected int attack;

    protected int defense;

    protected int currentHealth;

    public Monster(String name) {
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

    public void resume(){
        currentHealth = health;
    }

    /**
     * 怪物攻击精灵
     * @param pokemon 战斗精灵
     */
    public void attackPokemon(Pokemon pokemon){
        int minusHealth = this.attack * this.attack / pokemon.getDefense();
        if(minusHealth == 0){
            minusHealth = 1;
        }
        else if(minusHealth > pokemon.getCurrentHealth()){
            minusHealth = pokemon.getCurrentHealth();
        }
        int restHealth = pokemon.getCurrentHealth() - minusHealth;
        pokemon.setCurrentHealth(restHealth);
        System.err.println(name + "对" + pokemon.getName() + "发动攻击，造成了" + minusHealth + "伤害");
    }
}
