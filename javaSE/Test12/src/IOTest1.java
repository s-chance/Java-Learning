import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class IOTest1 {
    public static void main(String[] args) {
        //字符流操作 读
        //读取操作对应字符流输入流FileReader(需要抛出IOException)
        File file1 = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12\\test01.txt");
        System.out.println("file1 = " + file1);
        FileReader fileReader = null;

        try {
            //获取到输入流
            fileReader = new FileReader(file1);

            //读取
            int data; //记录当前所读取字符的ASCII值

            //read方法读取到文件末尾返回-1
            while ((data = fileReader.read()) != -1) {
                System.out.println((char)data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流,特别注意,否则会导致内存泄露问题
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        //Ctrl  Alt T 快捷键实现异常处理结构代码
        //推荐使用try-catch-finally的方式,而不是直接throws IOException


        //优化版
        //字符流操作 读
        //读取操作对应字符流输入流FileReader(需要抛出IOException)
        File file2 = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12\\test01.txt");
        System.out.println("file1 = " + file1);
        FileReader fileReader2 = null;

        try {
            //获取到输入流
            fileReader = new FileReader(file1);

            //使用char数组存储字符
            char[] ch = new char[5];

            //读取
            int len; //记录当前所读取字符的数量

            //read方法读取到文件末尾返回-1
            while ((len = fileReader.read(ch)) != -1) {
                String s = new String(ch, 0, len);
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流,特别注意,否则会导致内存泄露问题
            try {
                fileReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
