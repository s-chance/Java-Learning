import java.io.*;

public class IOTest1 {
    public static void main(String[] args) throws IOException {
        //IO流
        //字节流的使用
        //字节流图片复制操作

        //先创建一个File对象用于输入
        File file1 = new File("Test13\\1.jpg");

        //再创建一个File对象用于输出
        File file2 = new File("Test13\\target.jpg");

        //获取字节输入流
        FileInputStream fileInputStream = new FileInputStream(file1);
        //获取字节输出流
        FileOutputStream fileOutputStream = new FileOutputStream(file2);

        //字节流使用字节数组byte,区别于字符流使用字符数组char
        byte[] bytes = new byte[1024];

        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
//            String s = new String(bytes, 0, len);
//            System.out.println(s);
            fileOutputStream.write(bytes, 0, len);
        }

        //这里为了方便直接抛出IOException,实际开发建议使用try-catch-finally
        fileInputStream.close();
        fileOutputStream.close();
        //字符流与字节流使用区别
        //对于非文本文件,直接读取出来的是一堆乱码,一般用字节流去处理这类非文本文件
        //对于文本文件,则使用字符流去处理


        //用字符流来处理非文本文件,会直接导致文件无法打开,存在格式问题

//        File file3 = new File("Test13\\char.jpg");
//
//        FileReader fileReader = new FileReader(file1);
//        FileWriter fileWriter = new FileWriter(file3);
//
//        char[] chars = new char[1024];
//
//        int length;
//        while ((length = fileReader.read(chars)) != -1) {
//            fileWriter.write(chars, 0, length);
//        }
//
//        fileWriter.close();
//        fileReader.close();


    }
}
