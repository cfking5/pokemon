package com.zhy.pokemon;

import com.zhy.pokemon.level.LevelMap;
import com.zhy.pokemon.util.Tools;
import com.zhy.pokemon.item.Item;
import com.zhy.pokemon.item.Treasure;

public class Adventurer implements DisplayItem {


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
                        processTreasure(levelmap,direct);
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

    private void processTreasure(LevelMap map,char direct){
        System.out.println("发现宝箱，是否打开?Y/N");
        char open = Tools.getInputChar();
        if(Character.toUpperCase(open) == 'Y'){
            Item item = new Treasure("天山雪莲");
            System.out.println("获得" + item.getInformation());
            map.getMap().move(direct);
        }
    }
//    public Item discovery(char direct){
//
//    }

    @Override
    public String getInformation() {
        return "♀";
    }
}
