/*
	数据输入：
		导包：
			import java.util.Scanner;
		创建对象：
			Scanner sc = new Scanner(System.in);
		接收数据：
			int x = sc.nextInt();
*/
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		// //创建对象 可以在cmd 中输入整型
		// Scanner sc = new Scanner(System.in);
		// //可以在cmd 中输入整型
		// int x = sc.nextInt();
		// //输出数据
		// System.out.println("x:" + x);

		int i = 10;
		int j = 20;
		int k = 30;
		
		//&& 有false则false
		System.out.println((i > j) && (i > k)); //false && false
		System.out.println((i < j) && (i > k)); //true && false
		System.out.println((i > j) && (i < k)); //false && true
		System.out.println((i < j) && (i < k)); //true && true
		System.out.println("--------");
		
		//|| 有true则true
		System.out.println((i > j) || (i > k)); //false || false
		System.out.println((i < j) || (i > k)); //true || false
		System.out.println((i > j) || (i < k)); //false || true
		System.out.println((i < j) || (i < k)); //true || true
		System.out.println("--------");
		
		//&和&& 短路逻辑运算符 的区别，& ,|左右都会执行，&&,||左边为真才会执行右边
		//System.out.println((i++ > 100) & (j++ > 100)); //false & false
		System.out.println((i++ > 100) && (j++ > 100)); //false && false
		System.out.println("i:" + i);
		System.out.println("j:" + j);	

	}
}