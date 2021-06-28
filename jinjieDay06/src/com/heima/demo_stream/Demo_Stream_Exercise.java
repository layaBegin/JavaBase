package com.heima.demo_stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class Demo_Stream_Exercise {
    public static int totalMoney;
    public static void main(String[] args) {
        Employee e1 = new Employee("孙悟空",1000,100,"顶撞上司");
        Employee e2 = new Employee("猪八戒",1500,100,"");
        Employee e3 = new Employee("沙和尚",500,100,"");
        Employee e4 = new Employee("白龙马",300,100,"");

        List<Employee> list = new ArrayList<>();
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);

        Employee f1 = new Employee("武松",1000,200,"");
        Employee f2 = new Employee("李逵",1000,10,"");
        Employee f3 = new Employee("西门庆",3000,500,"");
        Employee f4 = new Employee("潘金莲",400,60,"");
        List<Employee> list2 = new ArrayList<>();
        list.add(f1);
        list.add(f2);
        list.add(f3);
        list.add(f4);
        //1,分别筛选出两个部门工资最高的员工，封装成TopEmployee
       /* TopEmployee topEmployee = list.stream().sorted(( o1,  o2)-> Double.compare(o2.getToTalEarn(),o1.getToTalEarn())).
               findFirst().map(e -> new TopEmployee(e.getName(),e.getSalary(),e.getBonus(),e.getPunis())).get();
        System.out.println(topEmployee);*/

        //2,算出平均工资，要求去掉最高工资和最低工资
       /*   list.stream().sorted(( o1,  o2)-> Double.compare(o2.getToTalEarn(),o1.getToTalEarn())).skip(1).limit(list.size() -2).
            forEach(employee -> totalMoney+=employee.getToTalEarn());
        System.out.println(totalMoney*1.0/(list.size() - 2));*/
        //3.统计两个部门的平均工资
        Stream<Employee> concat = Stream.concat(list.stream(), list2.stream());
        concat.sorted(( o1,  o2)-> Double.compare(o2.getToTalEarn(),o1.getToTalEarn())).skip(1).limit(list.size() -2).
                forEach(employee -> totalMoney+=employee.getToTalEarn());
        System.out.println(totalMoney*1.0/(list.size() - 2));
    }
}
class TopEmployee{
    public TopEmployee(String name, int salary, int bonus, String punis) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.punis = punis;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getBonus() {
        return bonus;
    }

    public int getToTalEarn(){
        return salary + bonus;
    }

    public String getPunis() {
        return punis;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setPunis(String punis) {
        this.punis = punis;
    }

    private String name;
    private int salary;
    private int bonus;
    private String punis;

    @Override
    public String toString() {
        return "TopEmployee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", punis='" + punis + '\'' +
                '}';
    }
}

class Employee{
    public Employee(String name, int salary, int bonus, String punis) {
        this.name = name;
        this.salary = salary;
        this.bonus = bonus;
        this.punis = punis;
    }

    public String getName() {
        return name;
    }

    public int getSalary() {
        return salary;
    }

    public int getBonus() {
        return bonus;
    }

    public int getToTalEarn(){
        return salary + bonus;
    }

    public String getPunis() {
        return punis;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void setPunis(String punis) {
        this.punis = punis;
    }

    private String name;
    private int salary;
    private int bonus;
    private String punis;

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", bonus=" + bonus +
                ", punis='" + punis + '\'' +
                '}' + "\n";
    }
}