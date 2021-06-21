public class Student {
    private String name;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    //构造方法也能重载
    public Student(){

    }
    public Student(String name){
        this.name = name;
    }
    public Student(String name,int age){
        this.name = name;
        this.age = age;
    }

    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return  this.name;
    }
    public void show(){
        System.out.println("name:"+this.name + "age:" + this.age);
    }
}
