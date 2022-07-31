import java.io.*;

public class IOTest4 {
    public static void main(String[] args) throws Exception {
        //转换流
        //InputStreamReader将一个字节输入流转换为字符输入流
        //字节解码为字符数组

        //OutputStreamWriter将一个字符输出流转换为字节输出流
        //字符数组重新编码为字节

        //利用转换流可以实现对文件的编码格式转换,不同的编码格式可能会出现乱码

        FileInputStream fileInputStream = new FileInputStream(new File("Test13\\introduce.md"));

        FileOutputStream fileOutputStream = new FileOutputStream(new File("Test13\\exchange.md"));

        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "UTF-8");
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream, "GBK");

        char[] chars = new char[1024];
        int len;
        while ((len = inputStreamReader.read(chars)) != -1) {
            outputStreamWriter.write(chars, 0, len);
        }
        outputStreamWriter.close();
        inputStreamReader.close();
    }
}
