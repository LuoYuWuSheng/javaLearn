package site.luoyu.GenericCode;

import java.util.List;

/**
 * Created by xd on 2016/11/25.
 * 泛型接口
 * implements 的时候不需要指定T,因为擦除后是Object
 * 但是如果传入的话，编译器可以帮你检测类型是否正确
 * 所以建议传入
 */
public interface GenericInterface<T> {
    public T testGenericInterface(T arg1);
}

class implGenInterface implements GenericInterface<Double>{

    @Override
    public Double testGenericInterface(Double arg1) {
        return null;
    }
}

/**
 * 如果原接口不受限则继承后不能让原接口变成受限的。
 * class implGenInterface2 <H> implements GenericInterface<H extends List>{
 *
 * @Override public H testGenericInterface(H arg1) {
 * return null;
 * }
 * }
 **/