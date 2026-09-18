package com.zhy.pokemon;

public class LevelMap {


    private int currentRow,currentCol;

    /**
     * 打印地图
     */
    public void show() {
        System.out.println("Adventurer start");
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i == currentRow && j == currentCol) {
                    System.out.print("♀");
                    continue;
                }
                System.out.print(" ■");
            }
            System.out.println();
        }
    }

    public void move(char direct) {
        switch(direct){
            case 'A':
                if(currentCol == 0){
                    System.out.println("非法移动");
                    return;
                }
                currentCol--;
                break;
            case 'D':
                if(currentCol == 8){
                    System.out.println("非法移动");
                    return;
                }
                currentCol++;
                break;
            case 'W':
                if(currentRow == 0){
                    System.out.println("非法移动");
                    return;
                }
                currentRow--;
                break;
            case 'S':
                if(currentRow == 8){
                    System.out.println("非法移动");
                    return;
                }
                currentRow++;
                break;
        }
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
