package com.zhy.pokemon.level;

import com.zhy.pokemon.DisplayItem;
import com.zhy.pokemon.item.Treasure;
import com.zhy.pokemon.util.Tools;
import com.zhy.pokemon.Adventurer;

public class LevelMap {

    /**
     * 记录当前冒险家的位置
     */
    private int currentRow,currentCol;

    /**
     * 地图上的物品
     */
    private final DisplayItem[][] items = new DisplayItem[9][9];

    public LevelMap(){
        generate();
    }

    /**
     * 添加冒险家
     * @param adventurer 冒险家
     */
    public void addAdventurer(Adventurer adventurer){
        currentRow = 0;
        currentCol = 0;
        items[currentRow][currentCol] = adventurer;
    }

    /**
     * 生成地图及物品
     */
    public void generate(){
        Treasure treasure = new Treasure("宝箱");
        items[1][1] = treasure;
    }

    /**
     * 获取移动方向位置的信息
     * @param direct 方向
     * @return 目标位置上的物品
     */
    public DisplayItem getPositionInformation(char direct){
        int targetRow = currentRow, targetCol = currentCol;
        switch(direct){
            case 'A':
                if(targetCol == 0){
                    return null;
                }
                targetCol--;
                break;
            case 'D':
                if(targetCol == 8){
                    return null;
                }
                targetCol++;
                break;
            case 'W':
                if(targetRow == 0){
                    return null;
                }
                targetRow--;
                break;
            case 'S':
                if(targetRow == 8){
                    return null;
                }
                targetRow++;
                break;
        }
        return items[targetRow][targetCol];
    }
    /**
     * 冒险家移动
     * @param direct 方向
     */
    public void move(char direct) {
        int oldRow = currentRow, oldCol = currentCol;
        DisplayItem adventurer = items[oldRow][oldCol];
        switch(direct){
            case 'A':
                if(currentCol == 0){
                    System.out.println("非法移动");
                    Tools.lazy(300L);
                    return;
                }
                currentCol--;
                break;
            case 'D':
                if(currentCol == 8){
                    System.out.println("非法移动");
                    Tools.lazy(300L);
                    return;
                }
                currentCol++;
                break;
            case 'W':
                if(currentRow == 0){
                    System.out.println("非法移动");
                    Tools.lazy(300L);
                    return;
                }
                currentRow--;
                break;
            case 'S':
                if(currentRow == 8){
                    System.out.println("非法移动");
                    Tools.lazy(300L);
                    return;
                }
                currentRow++;
                break;
        }
        items[currentRow][currentCol] = adventurer;
        items[oldRow][oldCol] = null;
    }

    /**
     * 打印地图
     */
    public void show() {
        System.out.println("Adventurer start");
        for (int i = 0; i < items.length; i++) {
            String line1 = "", line2 = "";
            for (int j = 0; j < items.length; j++) {
                String info = " ";
                if (items[i][j] != null) {
                    info = items[i][j].getInformation();
                }
                if (i == 0) {//第一行
                    if (j == 0) {//第一列
                        line1 += "┌───";
                        line2 += "│ " + info + " ";
                    } else if (j == items[i].length - 1) {//最后一列
                        line1 += "┬───┐";
                        line2 += "│ " + info + " │";
                    } else {
                        line1 += "┬───";
                        line2 += "│ " + info + " ";
                    }
                } else {
                    if (j == 0) {//第一列
                        line1 += "├───";
                        line2 += "│ " + info + " ";
                    } else if (j == items[i].length - 1) {//最后一列
                        line1 += "┼───┤";
                        line2 += "│ " + info + " │";
                    } else {
                        line1 += "┼───";
                        line2 += "│ " + info + " ";
                    }
                }
            }

            System.out.println(line1);
            System.out.println(line2);
        }
            String lastLine = "";//最后一行网格线
            for(int i=0;i<items[0].length; i++){
                if(i==0){//第一列
                    lastLine += "└───";
                } else if(i == items[0].length -1){//最后一列
                    lastLine += "┴───┘";
                } else {
                    lastLine += "┴───";
                }
            }
            System.out.println(lastLine);
        }


    /**
     * 测试用
     * @return 获得当前行
     */
    public int getCurrentRow() {
        return currentRow;
    }

    /**
     * 测试用
     * @return 获得当前列
     */
    public int getCurrentCol() {
        return currentCol;
    }

    public LevelMap getMap(){
        return this;
    }
}
