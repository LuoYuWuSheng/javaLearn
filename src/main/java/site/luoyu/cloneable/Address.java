package site.luoyu.cloneable;

/**
 * Computer user xd
 * Created by 张洋 on 2017/12/13.
 */
public class Address implements Cloneable {
    public String country;
    public String province;

    public Address(String country, String street) {
        this.country = country;
        this.province = street;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Address clone = (Address) super.clone();
        return clone;
    }
}
