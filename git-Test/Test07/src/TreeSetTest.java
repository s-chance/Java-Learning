import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        //TreeSet的使用及其两种排序,treeSet只能放入同一类型的数据，相当于自带泛型（？）
        TreeSet treeSet = new TreeSet<>();
//        treeSet.add("aa");
//        treeSet.add("11");

//        TreeSet添加自定义的对象类时需要实现对象的comparable接口，重写compareTo方法
        //但idea自动生成的compareTo方法只能让TreeSet添加一个对象，需要再对compareTo方法进行修改

        //这种排序也成为自然排序
        treeSet.add(new User("dd",33));
        treeSet.add(new User("dd",34));
        treeSet.add(new User("zero",0));
        treeSet.add(new User("tzo",201));
        for (Object o : treeSet) {
            System.out.println("o = " + o);
        }
    }
}
