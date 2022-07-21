import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class IOTest2 {
    public static void main(String[] args) {
        //字符流实现完整的读写操作   相当于实现了一次复制粘贴   被写入的文件如果不存在会自动创建

        File file1 = new File("D:\\git-repo\\git\\git-Test\\Test12\\test01.txt");
        File file2 = new File("D:\\git-repo\\git\\git-Test\\Test12\\test02.txt");
        FileReader fileReader = null;
        FileWriter fileWriter = null;

        try {
            //获取字符流输入流
            fileReader = new FileReader(file1);
            //获取字符流输出流
            fileWriter = new FileWriter(file2);

            //使用char数组
            char[] ch = new char[5];

            //读取并写入
            int data;
            while ((data = fileReader.read(ch)) != -1) {
                String s = new String(ch, 0, data);
                fileWriter.write(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //关闭流, 注意先打开的流后关闭,后打开的流先关闭
            if (fileWriter != null) {
                try {
                    fileWriter.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
