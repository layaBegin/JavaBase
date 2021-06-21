import java.util.Random;
import java.util.Scanner;

public class DebugTest {
    public static void main(String[] args) {
        //100以内逢7过
        //seven();
        //百钱买百鸡
        //checken100();
        //20个月后有多少只兔子
        //rabbit();
        //评委打分
        dafen();


    }

    public static  void seven(){
        for (int i = 1; i < 100; i++) {
            if (i%10 == 7 || i/10%10 ==7 || i % 7 == 0){
                System.out.println("逢7过");
                System.out.println(i);
            }
        }
    }
    //百钱买100鸡，公鸡5文钱，母鸡3文钱，小鸡1文钱3只
    public static  void checken100(){
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 33; j++) {
                int z = 100 - j - i;
                if (z % 3 == 0 && 5*i + 3*j + z/3 == 100){
                    System.out.println(i + "," + j +","+z );
                }
            }
        }
    }

    //一对兔子第三个月能下一对兔子，在到第三个月又能下一对兔子，问20个月后有多少对兔子
    public static void  rabbit(){
        int[] arr = new int[20];
        arr[0] = 1;
        arr[1] = 1;
        for (int i = 2; i < 20; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        System.out.println(arr[19]);
    }

    public static int getMax(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (temp < arr[i]){
                temp = arr[i];
            }
        }
        return temp;
    }
    public static int getMin(int[] arr){
        int temp = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (temp > arr[i]){
                temp = arr[i];
            }
        }
        return temp;
    }
    public static int getSum(int[] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum+=arr[i];
        }
        return sum;
    }

    public static void dafen(){
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[6];
        for (int i = 0; i < 6; i++) {
            System.out.println("请输入分数");
            int a = sc.nextInt();
            arr[i] = a;
        }
        int sum = getSum(arr);
        int max = getMax(arr);
        int min = getMin(arr);
        int realScore = (sum - max - min)/(arr.length - 2);
        System.out.println("分数为:"+ realScore);
    }
}
