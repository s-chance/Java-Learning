import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        //TreeMap和TreeSet相比较，也具有自然排序和定义排序

        TreeMap<People,String> treeMap = new TreeMap();
        treeMap.put(new Student("Lily",18),"1");
        treeMap.put(new Student("Mary",22),"2");
        treeMap.put(new Student("Demmen",24),"4");
        treeMap.put(new Student("Laluos",21),"3");
        treeMap.put(new Student("Laluos",21),"3");

        TreeMap tree = new TreeMap(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                if (o1 instanceof Student) {
                    Student s1 = (Student) o1;
                    Student s2 = (Student) o2;

                    return Integer.compare(s2.age, s1.age); //根据年龄降序排序，定义排序的实现
                    //最好能熟练匿名内部类实现Comparator接口排序的流程
                }

                return 0;
            }
        });

        tree.put(new Student("Lily",18),"1");
        tree.put(new Student("Mary",22),"2");
        tree.put(new Student("Demmen",24),"4");
        tree.put(new Student("Laluos",21),"3");
        tree.put(new Student("Laluos",21),"3");

        Iterator < Map.Entry < People, String >> it = treeMap.entrySet().iterator();
        Iterator < Map.Entry < People, String >> treeIt = tree.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry<People, String> index = it.next();
            System.out.println(index.getKey()+":"+index.getValue());
        }
        System.out.println();
        while (treeIt.hasNext()) {
            Map.Entry<People, String> index = treeIt.next();
            System.out.println(index.getKey()+":"+index.getValue());
        }

    }
}
