import java.util.Comparator;
import java.util.TreeSet;

public class TreeSetTest2 {
    public static void main(String[] args) {
        //定义排序，也称比较器排序
        //Comparator接口，通过匿名内部类


        Comparator<User> com = new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if(o1 instanceof User && o2 instanceof User) {
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                } else {
                    throw new RuntimeException("can't cast");
                }
            }
        };

//        TreeSet<User> treeSet = new TreeSet(com);

        //comparator的实现方法还可以直接写在TreeSet里面
        TreeSet<User> treeSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User o1, User o2) {
                if(o1 instanceof User && o2 instanceof User) {
                    User u1 = (User)o1;
                    User u2 = (User)o2;
                    return Integer.compare(u1.getAge(),u2.getAge());
                } else {
                    throw new RuntimeException("can't cast");
                }
            }
        });
        treeSet.add(new User("dd",36));
        treeSet.add(new User("dd",34));
        treeSet.add(new User("zero",0));
        treeSet.add(new User("tzo",201));

        for (User user : treeSet) {
            System.out.println("user = " + user);
        }
    }
}
