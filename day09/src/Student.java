public class Student {
    private String id;
    private String name;
    private String age;
    private String address;

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getAge() {
        return age;
    }

    //构造方法也能重载
    public Student(){

    }
    public Student(String name){

        this.name = name;
    }
    public Student(String name,String age){
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

        System.out.println("id:" + this.id + "\t" + "name:" + this.name + "\t" + "age:" + this.age +"\t"+ "address:" + this.address);
    }
}
