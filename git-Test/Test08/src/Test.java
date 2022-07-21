import java.util.*;

public class Test {
    public static void main(String[] args) {
        //map集合
        //map集合中主要有HashMap和TreeMap等
        /*map集合是以键值对的形式存储的，map<key,value>，通常和泛型一起使用保持数据的规范性*/

        HashMap<Integer, String> map = new HashMap<>();

        //增加元素  put
        map.put(1,"Hello");
        map.put(2,"Map");
        map.put(3,"HashMap");


        //map集合的key不能重复,出现多个相同的key时值会被覆盖,相当于是修改了值,value可以重复
        map.put(3,"again");
        map.put(4,"Hello");

        //删除元素    remove
        map.remove(1);
        map.remove(4,"Hello");

//        map.put(10,null);
//        map.put(null,null);
        System.out.println(map.size());//集合大小size 即使是null也算一个尺寸，不过和key的值无关


        //values方法 获取map集合中所有的value
        Collection<String> values = map.values();

        Iterator<String> iter = values.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());//同样的，iterator也不能在一次循环中多次调用
        }




        //map集合的遍历和set集合一样只能用增强for或者迭代器iterator

        //增强for
        //keySet方法，将map中的key转换成set集合,再通过get方法获取key所对应的value
        for (Integer integer : map.keySet()) {
            System.out.println(map.get(integer));
        }

        //迭代器
        Iterator<Integer> it = map.keySet().iterator();
        while (it.hasNext()) {
            int index = it.next();
            System.out.println(index+":"+map.get(index));
            //next方法需要注意不能在while中调用多次，每调用一次next的指向就会变化，
            // 一次循环中多次调用next，就会丢失数据
        }

        //还有containsKey，containsValue，isEmpty之类的方法，
        System.out.println("------------------------------------");

        //清空map集合  不同于删除单个元素，清空是一次性删除全部元素
        //map.clear();
        System.out.println(map.isEmpty()+" "+map.size());
        System.out.println(map.containsKey(2)+" "+map.containsKey(333));
        System.out.println(map.containsValue("Map")+" "+map.containsValue("...."));

        //System.exit(0);

        //注意到之前的keySet方法只能将map中的key提取出来
        //EntrySet方法则可以将整个map的映射关系提取出来
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        for (Map.Entry<Integer, String> entry : entrySet) {
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}
