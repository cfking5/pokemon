public class Main {
    public static void main(String[] args) {
        long bigNum = 10000000000L;
        double d = 3.14;
        int num1 = (int)bigNum;
        int num2 = (int)d;
        System.out.println("long值：" + bigNum);
        System.out.println("转int后：" + num1);
        System.out.println("double值：" + d);
        System.out.println("转int后：" + num2);

    }
}