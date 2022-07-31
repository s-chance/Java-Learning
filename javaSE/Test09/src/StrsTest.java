public class StrsTest {

    public static void main(String[] args) {
        //已知String本身是final修饰的类，本身不可变
        //于是Java这边提供了可变的StringBuilder和StringBuffer
        StringBuilder stringBuilder = new StringBuilder("abc");

        //拼接append
        StringBuilder aa = stringBuilder.append("aa");

        System.out.println(stringBuilder);
        System.out.println(stringBuilder==aa);
        //与String不同StringBuilder在拼接之后其第一个实例本身已经改变

        //删除delete
        stringBuilder.delete(2,3);//0a1b2c3a4a -> 0a1b2 3a4a
        System.out.println(stringBuilder);

        //insert指定在某一个下标开始插入数字
        StringBuilder insert = stringBuilder.insert(1, 223);
        System.out.println(insert);

        //replace修改
        stringBuilder.replace(1,4,"");//a223baa->abaa
        System.out.println(stringBuilder);


        //charAt找到指定下标对应的字符实现遍历
        for (int i = 0; i < stringBuilder.length(); i++) {
            System.out.print(stringBuilder.charAt(i)+" ");
        }

        StringBuffer sbf = new StringBuffer("aaad");
        //StringBuffer的方法与StringBuilder的方法基本一致

        //StringBuffer(sbf)、StringBuilder(sbd)分别与String之间的转换

        //String转sbf，直接构造方法创建
        String a = "aa";
        StringBuffer sbf1 = new StringBuffer(a);

        //sbf转String，toString方法
        String string = sbf.toString();

        //sbd与String之间的转换同sbf与String的转换

    }
}
