/*
	�������룺
		������
			import java.util.Scanner;
		��������
			Scanner sc = new Scanner(System.in);
		�������ݣ�
			int x = sc.nextInt();
*/
import java.util.Random;
import java.util.Scanner;

public class ScannerDemo {
	public static void main(String[] args) {
		// //�������� ������cmd ����������
		// Scanner sc = new Scanner(System.in);
		// //������cmd ����������
		// int x = sc.nextInt();
		// //�������
		// System.out.println("x:" + x);
		// int i = 10;
		// int j = 20;
		// int k = 30;
		// //&& ��false��false
		// System.out.println((i > j) && (i > k)); //false && false
		// System.out.println((i < j) && (i > k)); //true && false
		// System.out.println((i > j) && (i < k)); //false && true
		// System.out.println((i < j) && (i < k)); //true && true
		// System.out.println("--------");
		// //|| ��true��true
		// System.out.println((i > j) || (i > k)); //false || false
		// System.out.println((i < j) || (i > k)); //true || false
		// System.out.println((i > j) || (i < k)); //false || true
		// System.out.println((i < j) || (i < k)); //true || true
		// System.out.println("--------");
		// //&��&& ��·�߼������ ������& ,|���Ҷ���ִ�У�&&,||���Ϊ��Ż�ִ���ұ�
		// //System.out.println((i++ > 100) & (j++ > 100)); //false & false
		// System.out.println((i++ > 100) && (j++ > 100)); //false && false
		// System.out.println("i:" + i);
		// System.out.println("j:" + j);


		//------Ҫ��ɲ����ֵ���Ϸ��������Ҫ��һ��Ҫ�µ����֣�ʹ����������ɸ����֣���Χ1��100-----------------
		Random r = new Random();
		//������ĸ��� r.netxtInt(x) ������ 0-x �������������+ y ��ʾ y-x+y �������
		int num  = r.nextInt(50)+1;

		Scanner sc = new Scanner(System.in);
		while(true){
			System.out.println("��������Ҫ�µ����֣�");
			int numImput = sc.nextInt();
			if(numImput > num){
				System.out.println("�´���");
			}else if(numImput < num){
				System.out.println("��С��");
			}else {
				System.out.println("��ϲ�㣬�¶���");
				break;
			}
		}
		
	}
}