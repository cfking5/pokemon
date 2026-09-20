package com.zhy.pokemon;

import com.zhy.pokemon.level.LevelMap;
import com.zhy.pokemon.pokemon.Bikachu;
import com.zhy.pokemon.pokemon.Pokemon;
import com.zhy.pokemon.util.Tools;
import com.zhy.pokemon.item.Item;
import com.zhy.pokemon.item.Treasure;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Adventurer implements DisplayItem {

    /**
     * 药物背包
     */
    private HP[] medicines = {
            new HP(5)
    };

    /**
     * 宠物背包
     */
    private Pokemon[] pokemons ={
            new Bikachu()
    };

    /**
     *总背包
     */
    private Item[][] pakageItems={
        medicines,
        pokemons
    };

    public void start(){
        LevelMap levelmap = new LevelMap();

        levelmap.addAdventurer(this);
        while(true){
               // System.out.println(levelmap.getCurrentRow() + "和" + levelmap.getCurrentCol());
                levelmap.show();
                System.out.println("请选择移动方向：W(上)、A(左)、S(下)、D(右)、E(退出)");
                 char direct = Character.toUpperCase(Tools.getInputChar());
                if(direct == 'E'){
                    System.out.println("你确定要退出吗？ Y/N");
                    char quit = Character.toUpperCase(Tools.getInputChar());
                    if(quit == 'Y'){
                        System.out.println("感谢使用小精灵冒险");
                        break;
                    }
                }
                else{
                    Item item = (Item)levelmap.getPositionInformation(direct);
                    if(item != null){
                        item.setDiscovery(true);
                        levelmap.show();

                    }
                    if(item instanceof Treasure){
                        processTreasure(levelmap,direct,(Treasure)item);
                    }
                    else {
                        levelmap.move(direct);
                    }
                }

        }
    }

    /**
     * 包装move，实际是添加一个转大写功能，实现大小写
     * @param map 地图
     * @param direct 方向按键
     */
    private void move(LevelMap map,char direct){
        map.getMap().move(Character.toUpperCase(direct));
    }

    /**
     * 处理获得宝箱
     * @param map 当前地图
     * @param direct 方向
     */
    private void processTreasure(LevelMap map,char direct,Treasure treasure){
        System.out.println("发现宝箱，是否打开?Y/N");
        char open = Tools.getInputChar();
        if(Character.toUpperCase(open) == 'Y'){
            Item item  = treasure.open();
            System.out.println("获得" + item.getInformation());
            processItem(item);
            map.move(direct);
        }
    }
//    public Item discovery(char direct){
//
//    }

    private void processItem(Item item){
        //药品
        if(item instanceof HP){
            for(HP hp : medicines){
                if(hp.getInformation() == item.getInformation()){
                    hp.addCount(((HP) item).getCount());
                    break;
                }
            }
        }
        //宠物
        else if(item instanceof Pokemon){
            int index = -1;
            for(int i = 0;i < pokemons.length;i++){
                if(item.getClass() == pokemons[i].getClass()){
                    index = i;
                }
            }
            //不存在同种类型精灵
            if(index == -1){
                pokemons = Arrays.copyOf(pokemons, pokemons.length + 1);
                pokemons[pokemons.length-1] = (Pokemon) item;
            }
            //存在同种类型精灵考虑是否融合
            else{
                System.out.println("发现可融合宠物小精灵，是否融合？ Y/N");
                char merge =Character.toUpperCase(Tools.getInputChar());
                if(merge == 'Y'){
                    pokemons[index].merge((Pokemon) item);
                }
                else{
                    pokemons = Arrays.copyOf(pokemons, pokemons.length + 1);
                    pokemons[pokemons.length-1] = (Pokemon) item;
                }
            }
        }
    }

    @Override
    public String getInformation() {
        return "♀";
    }
}
