import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPTest {

    //TCP编程(服务端+客户端)
    //先启动服务端,再启动客户端,否则会报错
    //java.net.ConnectException: Connection refused: connect 服务端没有启动
    //服务端使用了accept方法,一直等待客户端的启动

    //客户端的socket和服务端的serverSocket是用于传输数据的两个必要对象

    //为了方便测试,这里引入了junit单元测试@Test
    //@Test 其作用相当于psvm,不过psvm在一个类只能使用一次,而@Test可以多次使用
    //@Test和psvm不能同时使用

    //客户端
    @Test
    public void client() throws IOException {
        //创建socket对象 需要服务器端的IP和端口号
        InetAddress byName = InetAddress.getByName("127.0.0.1");
        Socket socket = new Socket(byName, 8899);

        //获取一个字节流输出流,用于输出数据
        //这里的数据在服务端输出
        OutputStream outputStream = socket.getOutputStream();
        outputStream.write("client is ready".getBytes());
        outputStream.close();
        socket.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //创建服务器的serverSocket,确定端口号
        ServerSocket serverSocket = new ServerSocket(8899);
        //调用accept方法,接受来自客户端的Socket
        Socket accept = serverSocket.accept();
        //获取输入流
        InputStream inputStream = accept.getInputStream();

        //IO流的写法可能导致乱码
        /*byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            String string = new String(bytes, 0, len);
            System.out.println(string);
        }*/

        //网络编程中的输入输出流,对于文本信息,使用ByteArrayOutputStream处理
        //读取输入流中的数据并输出
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        byte[] bytes = new byte[5];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            byteArrayOutputStream.write(bytes, 0, len);
        }

        //字节转换为字符串
        System.out.println(byteArrayOutputStream.toString());
        System.out.println("已接受"+accept.getInetAddress().getHostAddress()+"的数据");

        byteArrayOutputStream.close();
        inputStream.close();
        accept.close();
        serverSocket.close();
    }
}
