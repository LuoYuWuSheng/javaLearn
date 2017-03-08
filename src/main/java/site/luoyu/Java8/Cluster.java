package site.luoyu.Java8;

import java.lang.management.ThreadInfo;

/**
 * Computer user xd
 * Created by 张洋 on 2017/3/8.
 */
public class Cluster {
    private class Employee{
        String name;
        int age;

        public Employee(String name, int age) {
            this.name = name;
            this.age = age;
        }
    }
    private class Inner{
        Employee employee;
        public Inner() {
        }
        public void testCluster(Employee employee){
            this.employee = employee;
            employee.name = "ww";
            System.out.println(employee.name);
        }
    }

    public void test(){
        Employee temp = new Employee("ZY",23);
        Inner inner = new Inner();
        inner.testCluster(temp);
    }
}
