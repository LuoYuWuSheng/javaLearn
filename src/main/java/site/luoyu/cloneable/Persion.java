package site.luoyu.cloneable;

/**
 * Computer user xd
 * Created by 张洋 on 2017/12/13.
 * clone三部曲。
 * 1 声明实现Cloneable接口。
 * 2 调用super.clone拿到一个对象，如果父类的clone实现没有问题的话，在该对象的内存存储中，
 * 所有父类定义的field都已经clone好了，该类中的primitive和不可变类型引用也克隆好了，可变类型引用都是浅copy。
 * 3 把浅copy的引用指向原型对象新的克隆体。
 */
public class Persion implements Cloneable {
    String name;
    int age;
    Address address;

    public Persion(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public static void main(String[] args) {
        Persion myself = new Persion("zy", 18, new Address("china", "xian"));
        try {
            Persion clone = (Persion) myself.clone();
            clone.name = "tyc";
            clone.age = 14;
            clone.address.country = "american";
            System.out.println(myself.name + " " + clone.name);
            System.out.println(myself.age + " " + clone.age);
            System.out.println(myself.address.country + " " + clone.address.country);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Persion clone = (Persion) super.clone();
        clone.address = (Address) clone.address.clone();
        return clone;
    }
}
