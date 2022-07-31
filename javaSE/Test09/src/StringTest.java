public class StringTest {
    public static void main(String[] args) {
        String string = "abcd";
        int abc = string.compareTo("abc");
        int bbc = string.compareTo("bbc");
        int abcd = string.compareTo("abcd");

        //compareTo比较方法返回一个int值
        //目标字符t.compareTo(被比较的字符c)
        System.out.println(abc);//  t大于c 返回1
        System.out.println(bbc);//  t小于c 返回-1
        System.out.println(abcd);//  t等于c 返回0

        //equals方法返回的是boolean值，与compareTo相比equals更多用于流程控制
        //compareTo则用于实现集合的排序
        boolean abcd1 = string.equals("abcd");
        boolean aa = string.equals("aa");
        System.out.println(abcd1+"  "+aa);

        //lastIndexOf寻找字符串中对应字符中的最后一个字符下标，如果找不到返回-1
        int index = string.lastIndexOf("a");
        int index1 = string.lastIndexOf("m");
        System.out.println(index+" "+index1);

        //contains判断字符串中是否包含某一个字符，返回boolean
        boolean a = string.contains("a");
        boolean m = string.contains("m");
        System.out.println(a+" "+m);

        //charAt判断字符串中下标对应的字符，返回一个char字符，注意下标越界问题
        char c = string.charAt(0);
        char c1 = string.charAt(string.length()-1);

        System.out.println(c+" "+c1);

        //endsWith判断字符串是否以指定字符或字符片段结尾，返回boolean
        boolean d = string.endsWith("d");
        boolean cd = string.endsWith("cd");
        boolean a1 = string.endsWith("a");
        System.out.println(d+" "+cd+" "+a1);

        //concat即字符拼接
        String cccc = string.concat("cccc");
        String copyccccc = string+"cccc";
        System.out.println(cccc);
        System.out.println(copyccccc);

        //startsWith判断字符串是否以指定的字符或字符片段开头，类似于endsWith
        boolean a2 = string.startsWith("a");
        boolean b = string.startsWith("b");

        //subString截取字符串对应下标到结尾 或 两个下标之内的字符串
        String substring = string.substring(3);
        String substring1 = string.substring(2);
        String substring2 = string.substring(0, 2);
        System.out.println(substring);
        System.out.println(substring1);
        System.out.println(substring2);

        //toCharArray将String转换成char[]数组
        char[] chars = string.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            System.out.print(chars[i]+" ");
        }
        System.out.println();


        String s = string.toUpperCase();//将字母字符转换为大写
        System.out.println(s);
        String s1 = s.toLowerCase();//将字母字符转换为小写
        System.out.println(s1);


        //split字符串切割，去除特定的重复出现的字符
        String str = "a/b/c/d";
        String[] split = string.split("/");
        for (int i = 0; i < split.length; i++) {
            System.out.println(split[i]);
        }

        //trim方法删去字符串开头或结尾的空格
        String tr = "    abc     ";
        String trim = tr.trim();
        System.out.println(trim);
    }
}
