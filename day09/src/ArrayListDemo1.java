import java.util.ArrayList;

public class ArrayListDemo1 {
    public static void main(String[] args) {
        //arrayListTest();
        studentTest();
    }

    public static void  studentTest(){
        Student s1 = new Student("张山","19");
        Student s2 = new Student("李氏","50");
        Student s3 = new Student("王五","34");
        ArrayList<Student> arr = new ArrayList<Student>();
        arr.add(s1);
        arr.add(s2);
        arr.add(s3);
        for (int i = 0;i < arr.size();i++){
            System.out.println(arr.get(i).getName()+","+arr.get(i).getAge());
        }
    }

    public  static void arrayListTest(){
        ArrayList<String> arr = new ArrayList<String>();
        arr.add("java");
        arr.add("jdk");
        arr.add("jre");
        arr.add(1,"hello");
//        arr.remove(1);
//        arr.remove("java");
        arr.set(0,"world");
        System.out.println("arr:"+arr);
        System.out.println(arr.get(3));
        System.out.println(arr.size());
        for (int i = 0;i < arr.size();i++){
            System.out.println(arr.get(i));
        }
    }
}
