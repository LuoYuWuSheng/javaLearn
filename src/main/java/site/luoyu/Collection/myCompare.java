package site.luoyu.Collection;

/**
 * Computer user xd
 * Created by 张洋 on 2017/5/25.
 */
class myCompare implements Comparable<myCompare> {
    int age;

    public myCompare(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(myCompare o) {
        if (this.age == o.age) return 0;
        else if (this.age < o.age) return -1;
        else return 1;
    }
}
