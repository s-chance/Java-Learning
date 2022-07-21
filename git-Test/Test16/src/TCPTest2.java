import org.junit.Test;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest2 {

    //这里模拟客户端上传图片并保存到服务端

    @Test
    public void client() throws IOException {
        //创建socket对象,提供IP和端口号
        Socket socket = new Socket(InetAddress.getByName("127.0.0.1"), 9090);
        //获取输出流
        OutputStream outputStream = socket.getOutputStream();
        //获取输入流
        FileInputStream fileInputStream = new FileInputStream(new File("D:\\git-repo\\git\\git-Test\\Test16\\1.jpg"));

        //读写
        byte[] bytes = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }

        //资源关闭
        fileInputStream.close();
        outputStream.close();
        socket.close();
    }

    @Test
    public void server() throws IOException {
        //创建服务器serverSocket,规定端口号
        ServerSocket serverSocket = new ServerSocket(9090);
        //调用accept方法,接受来自客户端的socket
        Socket accept = serverSocket.accept();
        //获取输入流
        InputStream inputStream = accept.getInputStream();
        //获取输出流
        FileOutputStream fileOutputStream = new FileOutputStream(new File("D:\\git-repo\\git\\git-Test\\Test16\\TCP1212.jpg"));
        //读写
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }
        //资源关闭
        fileOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
