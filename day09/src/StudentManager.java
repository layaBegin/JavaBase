import jdk.nashorn.api.tree.ArrayLiteralTree;

import java.util.ArrayList;
import java.util.Scanner;

public class StudentManager {
    public static void main(String[] args) {
        ArrayList<Student> arr = new ArrayList<Student>();
        zhixing(arr);
    }

    public static void zhixing(ArrayList<Student> arr){
        while (true){
            Scanner sc = new Scanner(System.in);
            System.out.println("请选择要执行的命令==");
            System.out.println("1,添加");
            System.out.println("2,删除");
            System.out.println("3,查看");
            System.out.println("4,修改");
            System.out.println("5,退出");

            String s = sc.nextLine();
            switch (s){
                case "1":
                    addStudent(arr);
                    break;
                case "2":
                    deleteStudent(arr);
                    break;
                case "3":
                    findAllStudent(arr);
                    break;
                case "4":
                    updateStudent(arr);
                    break;
                case "5":
                    System.out.println("退出");
                    System.exit(0);
                    break;
                default:
                    break;
            }
        }
    }

    public static void addStudent(ArrayList<Student> arr){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id");
        String s = sc.nextLine();
        Student stu = new Student();
        stu.setId(s);
        System.out.println("请输入学生姓名");
        String s1 = sc.nextLine();
        stu.setName(s1);
        System.out.println("请输入学生年龄");
        String sAge = sc.nextLine();
        stu.setAge(sAge);
        System.out.println("请输入学生地址");
        String sAddress = sc.nextLine();
        stu.setAddress(sAddress);
        arr.add(stu);

    }
    public static void deleteStudent(ArrayList<Student> arr){
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入学生id");
        String s = sc.nextLine();
        for (int i = 0;i < arr.size();i++){
            if (arr.get(i).getId().equals(s)){
                arr.remove(i);
                break;
            }
        }

    }
    public static void  findAllStudent(ArrayList<Student> arr){
        for (int i = 0;i < arr.size();i++){
            Student s = arr.get(i);
            s.show();
        }

    }
    public static void updateStudent(ArrayList<Student> arr){
        System.out.println("请输入要修改的学生id");
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        Student stu  = arr.get(0);
        for (int i = 0;i < arr.size();i++){
            if (arr.get(i).getId().equals(line)){
                stu = arr.get(i);
                break;
            }
        }

        System.out.println("请输入学生姓名");
        String s1 = sc.nextLine();
        stu.setName(s1);
        System.out.println("请输入学生年龄");
        String sAge = sc.nextLine();
        stu.setAge(sAge);
        System.out.println("请输入学生地址");
        String sAddress = sc.nextLine();
        stu.setAddress(sAddress);
    }
}
