import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressTest {
    public static void main(String[] args) {

        //IP和端口号
        //java中以InetAddress类代表IP
        //IP是由几串数字及字符 . 组成 例如192.168.0.107
        //端口号对应一个IP下的不同服务
        //写法格式是IP:端口号



        try {

            //实例化InetAddress有两种方式
            //方式一:getByName方法,填入IP参数或网址名称
            InetAddress byName = InetAddress.getByName("192.168.0.107");
            System.out.println(byName);

            InetAddress name = InetAddress.getByName("www.baidu.com");
            System.out.println(name);

            //访问一个网站可以通过域名也可以通过IP,
            //但要注意有的IP不止一个服务,这个时候就需要加上端口号,以便确认你所需要访问的服务

            //域名
            System.out.println(name.getHostName());
            //IP
            System.out.println(name.getHostAddress());

            InetAddress address = InetAddress.getByName("localhost");
            System.out.println(address);

            //方式二:getLocalHost方法,获取的是本地的IP
            InetAddress host = InetAddress.getLocalHost();
            System.out.println(host);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
