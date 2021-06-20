/*
	数据输入：
		导包：
			import java.util.Scanner;
		创建对象：
			Scanner sc = new Scanner(System.in);
		接收数据：
			int x = sc.nextInt();
*/
import java.util.Random;
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		// //创建对象 可以在cmd 中输入整型
		// Scanner sc = new Scanner(System.in);
		// //可以在cmd 中输入整型
		// int x = sc.nextInt();
		// //输出数据
		// System.out.println("x:" + x);
		// int i = 10;
		// int j = 20;
		// int k = 30;
		// //&& 有false则false
		// System.out.println((i > j) && (i > k)); //false && false
		// System.out.println((i < j) && (i > k)); //true && false
		// System.out.println((i > j) && (i < k)); //false && true
		// System.out.println((i < j) && (i < k)); //true && true
		// System.out.println("--------");
		// //|| 有true则true
		// System.out.println((i > j) || (i > k)); //false || false
		// System.out.println((i < j) || (i > k)); //true || false
		// System.out.println((i > j) || (i < k)); //false || true
		// System.out.println((i < j) || (i < k)); //true || true
		// System.out.println("--------");
		// //&和&& 短路逻辑运算符 的区别，& ,|左右都会执行，&&,||左边为真才会执行右边
		// //System.out.println((i++ > 100) & (j++ > 100)); //false & false
		// System.out.println((i++ > 100) && (j++ > 100)); //false && false
		// System.out.println("i:" + i);
		// System.out.println("j:" + j);


		//------要完成猜数字的游戏，首先需要有一个要猜的数字，使用随机数生成该数字，范围1到100-----------------
		Random r = new Random();
		//随机数的概念 r.netxtInt(x) 会生成 0-x 的随机数，后面+ y 表示 y-x+y 的随机数
		int num  = r.nextInt(50)+1;

		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("请输入你要猜的数字：");
			int numImput = sc.nextInt();
			if(numImput > num){
				System.out.println("猜大了");
			}else if(numImput < num){
				System.out.println("猜小了");
			}else {
				System.out.println("恭喜你，猜对了");
				break;
			}
		}
		
	}
}