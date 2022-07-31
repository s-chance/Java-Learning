import test.People;
import test.Student;
import test.Teacher;
//这个时候访问Student对象就需要导包

public class Test {
    public static void main(String[] args) {
        //封装
        Student student = new Student();
        student.setAge(-110);
        System.out.println(student.getAge());

        student.setAge(11);
        System.out.println(student.getAge());
        //可以看到通过实例化直接访问对象修改它的属性会出现非法输入的情况
        //虽然可以通过if判断在测试类中处理，但数据过多的话，效率会很低。
        //封装的使用就有效的解决了这一问题
        //封装一定程度上保护了数据的安全


        //关于package   命名规范：全为小写字母
        //package通常用来对不同功能的类进行分类，并影响不同类之间相互访问的权限
        //权限修饰符  public protected 默认修饰符 private  访问权限大->小
        //protected对于不同包的类相互之间没有访问权限，有继承关系的另外考虑

        Student.id = 10;  //静态属性可通过类名直接访问
        Student.getId(Student.id);


        //关于继承extends
        /*
        * 注意到Student和Teacher有相同的属性
        * 这时候我们可以将它们相同的属性或方法抽取出来放到一个基类即父类中
        * 这个时候子类的共同属性就可以从父类继承而来  而不需要在子类中编写*/

        System.out.println("-------------------");
        Teacher t = new Teacher();
        t.say();
        student.say();


        //关于protected的补充：protected对本包和子类可见，那么对于子类在另外的包里，它是否可见？
        //可以看见通过继承的protected属性依旧可以访问,但是对父类实例化的属性却无法访问
        People p = new People();
        student.f(p);
        System.out.println(p.name);
    }
}
