package site.luoyu.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//Retention 表明这个注释保留的时限
@Retention(RetentionPolicy.RUNTIME)
//target 表明注释能使用的位置
@Target(ElementType.TYPE)
public @interface MethodAnnotation {
	public String name() default "张洋";
}
