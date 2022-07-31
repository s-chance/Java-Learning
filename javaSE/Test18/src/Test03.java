import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
//
//@interface
//定义注解的关键字是@interface
//自定义注解中可以定义多个配置参数,说明参数的名称,以及参数值的类型
//如果只有一个配置参数,一般命名为value
//如果配置参数是value,并且只有一个配置参数,value可以省略
public class Test03 {
    @MyAnnotation2()
    public void test(){}

    @MyAnnotation3("")
    public void test2(){}
}

@Target({ElementType.TYPE,ElementType.METHOD})   //类和方法有效
@Retention(RetentionPolicy.RUNTIME)              // 运行时
@interface MyAnnotation2{
    //注解的参数：参数类型  + 参数名();
    //String name();  //要写参数
    String name() default "";    //default  :默认值
    int age() default 0;
    int id() default -1;  //如果默认为-1.代表不存在
    String[] str() default {""};
}



@Target({ElementType.TYPE,ElementType.METHOD})   //类和方法有效
@Retention(RetentionPolicy.RUNTIME)              // 运行时
@interface MyAnnotation3{
    String value();  //一个值的情况下可以用value
}
