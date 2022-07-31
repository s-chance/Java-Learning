import org.junit.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPTest {

    //UDP编程(接收端+发送端)
    //接收端和发送端没有先后启动的顺序要求
    //无论先启动哪个都不会报错,不过先启动发送端,就会导致接收端收不到信息,
    //但发送端可以反复启动,所以一般先启动哪个也没有强制要求

    //这里就作为简单的了解

    @Test
    public void sender() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket();
        String string = "UDP导弹";
        byte[] bytes = string.getBytes();
        InetAddress localHost = InetAddress.getLocalHost();
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length, localHost, 9090);
        datagramSocket.send(datagramPacket);
        datagramSocket.close();
    }

    @Test
    public void receiver() throws IOException {
        DatagramSocket datagramSocket = new DatagramSocket(9090);
        byte[] bytes = new byte[1024];
        DatagramPacket datagramPacket = new DatagramPacket(bytes, 0, bytes.length);
        datagramSocket.receive(datagramPacket);

        System.out.println(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));

        datagramSocket.close();
    }
}
