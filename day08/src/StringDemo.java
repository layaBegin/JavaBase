import java.util.Scanner;

public class StringDemo {
    public static void main(String[] args) {
        //testString();
        //login();
        //egcharAtIndex();
        stringTime();
    }

    public static void   bindString(){

    }

    public static void stringTime(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String line = sc.nextLine();
        int bigCount = 0;
        int smallCount = 0;
        int numCount = 0;
        for (int i = 0;i < line.length();i++){
            char c = line.charAt(i);
            if (c >= 'A' && c <= 'Z'){
                bigCount++;
            }else if (c >= 'a' && c <= 'z'){
                smallCount ++;
            }else if (c >= '0' && c <= '9'){
                numCount++;
            }
        }
        System.out.println("大写字母" + bigCount + "," + "小写字母：" + smallCount + ","+ "数字："+ numCount );

    }

    public static void  testString(){
        char[] chars = {'a','d','e'};
        String s1 = new String(chars);
        String s2= new String(chars);
        String s3 = "ade";
        String s4 = "ade";
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1 == s3);
        System.out.println(s1.equals(s3));
    }

    public static void login(){
        String acc = "heima";
        String pass = "chuanzhi";
        Scanner sc = new Scanner(System.in);
        int time = 3;
        for (int i = 0; i < time; i++) {
            System.out.println("请输入账户名：");
            String a = sc.nextLine();
            System.out.println("请输入密码：");
            String p = sc.nextLine();
            if (a.equals(acc) && pass.equals(p)){
                System.out.println("登录成功");
                break;
            }else{
                System.out.println("你还有"+ (time - i -1)+ "次机会");
            }
        }
    }

    /**
     * 遍历字符串
     */
    public static char charAtIndex(){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String line = sc.nextLine();
        for (int i = 0;i < line.length();i++){
            System.out.println(line.charAt(i));
        }
        return '0';
    }
}
