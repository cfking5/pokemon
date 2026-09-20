package com.zhy.pokemon.util;

import java.util.Random;
import java.util.Scanner;

public class Tools {

    /**
     * 输入对象
     */
    public static final Scanner scanner = new Scanner(System.in);

    public static final Random random = new Random();
    /**
     *从控制台获取一个字符
     * @return
     */
    public static char getInputChar(){

        while(true){
            String input = scanner.next().trim();
            if(input.length() != 1){
                System.out.println("输入错误，请重新输入");
            }
            else{
                return input.charAt(0);
            }
        }
    }

    /**
     *延迟给定时间
     * @param time 延迟时间
     */
    public static void lazy(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 取min到max的随机数
     * @param min 最小范围
     * @param max 最大范围
     * @return 随机数
     */
    public static int getRandomNumber(int min,int max){
        return random.nextInt(max-min+1)+min;
    }

    public static int getRandomNumber(int max){
        return getRandomNumber(0,max);
    }
}
