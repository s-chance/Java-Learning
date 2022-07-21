import java.lang.annotation.*;
//元注解
//
//@Target 指定一个注解的使用范围
//@Retention 描述注解的生命周期,也就是该注解被保留的时间长短
//@Documented 表示是否将我们的注解生成在java文档中
//@Inherited 指定该注解可以被继承
//测试元注解
public class Test02 {

    //由于这些注解我不知道该怎么演示,这边就大致看一下它们的说明

    public void test(){

    }
}

//定义一个注解
//Target：表示我们的注解可以用在那些地。使用范围
@Target(value = {ElementType.METHOD,ElementType.TYPE})
//ElementType.METHOD  :可以用在方法上，有约束   TYPE:用在类上

//Retention：表示我们注解在什么地方还有效  有效范围
//runtime:运行时所有地方都有效  > class有效  > sources:源码有效
//runtime > class > sources
@Retention(value = RetentionPolicy.RUNTIME)

// Documented   表示是否将注解生成在java文档中
@Documented

// Inherited  子类可以继承父类的注解
@Inherited

//自定义注解@interface
@interface MyAnnotation{

}