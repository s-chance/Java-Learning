import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest3 {

    //这里进一步模拟了客户端服务端交互
    //客户端上传图片到服务端
    //服务端发送反馈给客户端
    //客户端再接收处理服务端的反馈信息

    @Test
    public void client() throws IOException {
        //创建socket对象, IP和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //获取输出流
        OutputStream outputStream = socket.getOutputStream();
        //获取输入流
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\git-repo\\git\\git-Test\\Test16\\1.jpg"));
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        //关闭数据的输出
        socket.shutdownOutput();

        //接受来自服务端的数据,显示在控制台上
        //获取输入流
        InputStream inputStream = socket.getInputStream();
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes1 = new byte[5];
        int len1;
        while ((len1 = inputStream.read(bytes1)) != -1) {
            byteArrayOutputStream.write(bytes1, 0, len1);
        }
        System.out.println(byteArrayOutputStream.toString());
        //资源关闭
        byteArrayOutputStream.close();
        inputStream.close();
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        //创建serverSocket对象,确定端口号
        ServerSocket serverSocket = new ServerSocket(9090);
        //调用accept方法,接受来自客户端的socket
        Socket accept = serverSocket.accept();
        //获取输入流
        InputStream inputStream = accept.getInputStream();
        //获取输出流
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\git-repo\\git\\git-Test\\Test16\\TCP3434.jpg"));
        //读写
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        System.out.println("图片传输完成");

        //服务端反馈客户端
        //获取输出流
        OutputStream outputStream = accept.getOutputStream();
        outputStream.write("收到,感谢你的支持".getBytes());

        //资源关闭
        outputStream.close();
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
