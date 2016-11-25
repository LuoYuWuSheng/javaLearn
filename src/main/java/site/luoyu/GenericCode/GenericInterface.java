package site.luoyu.GenericCode;

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