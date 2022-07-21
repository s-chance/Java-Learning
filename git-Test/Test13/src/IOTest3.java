import java.io.*;

public class IOTest3 {
    public static void main(String[] args) throws IOException {
        //IO流换行问题

        BufferedReader bufferedReader = new BufferedReader(new FileReader(new File("Test13\\clone.md")));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File("Test13\\clone2.md")));

        char[] chars = new char[2];

        int len;
//        while ((len = bufferedReader.read(chars)) != -1) {
//            //方式一
//            //使用String+\n换位符
//            //但是这种方法不推荐,因为不同操作系统下的换位符会有所不同
//
//            String s = new String(chars, 0, len);
//            s+="\n";
//            bufferedWriter.write(s);
//        }

        //方式二
        //使用ReadLine先读取一行文字

        String s;
        while ((s = bufferedReader.readLine()) != null) {
            bufferedWriter.write(s);
            bufferedWriter.newLine();
            bufferedWriter.newLine();
        }

        bufferedWriter.close();
        bufferedReader.close();
    }
}
