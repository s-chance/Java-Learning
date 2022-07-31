package optional;

import org.junit.Test;

import java.util.Optional;

public class OptionalTest {
    //专门用于处理null的类,防止空指向异常
    //ofNull 允许null存在
    //orElse 有值则返回该值,否则返回指定的other对象
    //of 创建Optional实例,需要一个非空任意类型的值作为参数
    @Test
    public void test1() {
        //准备测试数据  Boss和Staff
        //一般情况下,Optional实例不允许为空
        Staff staff = new Staff();
//        staff = null;
        Optional<Staff> optionalStaff = Optional.of(staff);
        System.out.println(optionalStaff);
    }

    @Test
    public void test2() {
        //ofNullable可以允许一个空的Optional实例
        Staff staff = new Staff();
        staff = null;
        Optional<Staff> optionalStaff = Optional.ofNullable(staff);
        System.out.println(optionalStaff);

        //orElse可以保证最后的结果不为空,即使前面传入的是空,但要指定other对象
        Staff res = optionalStaff.orElse(new Staff("res"));
        System.out.println(res);
        //如果前面传入的对象并不是空,则返回该对象
        Optional<Staff> num = Optional.ofNullable(new Staff("num"));
        Staff rep = num.orElse(new Staff("rep"));
        System.out.println(rep);
    }

    //后面模拟一下Optional处理的场景

    //通过Boss获取Staff的name
    public static String staffName(Boss boss) {
        return boss.getStaff().getName();
    }

    //通过普通的未经过处理的方法很容易出现空引用异常
    @Test
    public void test3() {
//        Boss boss = new Boss();
//        //boss和staff均为null,出现空引用异常
//        String staffName = staffName(boss);
//        System.out.println(staffName);
    }

    //经过条件判断处理的方法获取
    public String staffNamePro(Boss boss) {
        if (boss != null) {
            Staff staff = boss.getStaff();
            if (staff != null) {
                return staff.getName();
            }
        }
        return null;
    }

    //经过一定的条件处理之后,异常能够得到预防
    @Test
    public void test4() {
        Boss boss = new Boss();
        boss = null;
//        String staffNamePro = staffNamePro(boss);
//        String staffNamePro = staffNamePro(new Boss(null));
        String staffNamePro = staffNamePro(new Boss(new Staff("a")));
        System.out.println(staffNamePro);
    }

    //使用Optional来处理获取staff的name
    public static String staffNameMax(Boss boss) {
        Optional<Boss> optionalBoss = Optional.ofNullable(boss);
        //如果boss不存在则由另一位拥有名为emp的staff的empBoss代替
        Boss empBoss = optionalBoss.orElse(new Boss(new Staff("emp")));

        Staff staff = empBoss.getStaff();
//        staff = null;
        Optional<Staff> optionalStaff = Optional.ofNullable(staff);
        //如果empBoss下的staff也不存在则由另一位staff代替
        //或者Boss存在但staff不存在,此时前面的staff即使不指定为null它的值也为null
        Staff replaceEmp = optionalStaff.orElse(new Staff("replaceEmp"));
        return replaceEmp.getName();
    }


    //用Optional来处理相对一般的条件判断处理,能够节省更多代码实现在前一个值或对象不为null时不受到后面的影响
    //Optional的处理也可以用条件判断来完成,但相对的Optional的代码会更加简洁
    @Test
    public void test5() {
        //boss不存在的情况
        Boss boss = null;
        //boss存在但staff不存在的情况
        boss = new Boss();
        //boss和staff都存在的情况
        boss = new Boss(new Staff("FIRST"));

        String staffNameMax = staffNameMax(boss);
        System.out.println(staffNameMax);

        //最初的boss和staff均不存在 返回replaceEmp
        //最初的boss不存在,而empBoss的staff存在  返回emp
        //最初的boss存在,但staff不存在,则返回的是replaceEmp
        //最初的boss存在和staff都存在,则返回该staff  FIRST


        //另外javaSE的内容到这边从简单介绍的角度来说差不多就这些了
        //后面更详细的内容以及进一步的学习就需要各位亲自去探索了
    }
}
