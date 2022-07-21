import java.io.*;

public class IOTest2 {
    public static void main(String[] args) throws IOException {
        //字节流视频复制操作
        //测试视频复制所需时间

        //缓冲流的使用
        //缓冲流的作用:能够提高处理效率

        long start = System.currentTimeMillis();

        normalCopy();

        long end = System.currentTimeMillis();

        System.out.println("普通字节流处理用时:"+(end-start));

        long start1 = System.currentTimeMillis();

        bufferedCopy();

        long end1 = System.currentTimeMillis();

        System.out.println("缓冲字节流处理用时:"+(end1-start1));

    }

    public static void normalCopy() throws IOException {
        File file1 = new File("Test13\\1.mp4");
        File file2 = new File("Test13\\123.mp4");

        FileInputStream fileInputStream = new FileInputStream(file1);

        FileOutputStream fileOutputStream = new FileOutputStream(file2);


        byte[] bytes = new byte[1024];

        int len;

        while ((len = fileInputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        fileOutputStream.close();
        fileInputStream.close();
    }

    public static void bufferedCopy() throws IOException {
        File file1 = new File("Test13\\1.mp4");
        File file2 = new File("Test13\\123.mp4");

        FileInputStream fileInputStream = new FileInputStream(file1);

        FileOutputStream fileOutputStream = new FileOutputStream(file2);


        //获取缓冲流
        BufferedInputStream bufferedInputStream = new BufferedInputStream(fileInputStream);
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(fileOutputStream);

        byte[] bytes = new byte[1024];

        int len;

        while ((len = bufferedInputStream.read(bytes)) != -1) {
            bufferedOutputStream.write(bytes, 0, len);
        }

        //使用缓冲流时只需关闭外部的缓冲流,即可自动关闭内部的字节流,但保持关闭的顺序 先开后闭
        bufferedOutputStream.close();
        bufferedInputStream.close();

    }
}
