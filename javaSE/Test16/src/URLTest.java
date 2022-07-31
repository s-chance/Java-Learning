import java.net.MalformedURLException;
import java.net.URL;

public class URLTest {

    //URL编程
    //URL统一资源定位
    //tomcat的使用
    //tomcat是一种web服务器
    //这边运行在本地上,即自己的电脑就是localhost
    //如果购买了服务器则IP就是购买的服务器指定的IP
    //tomcat的默认地址  http://localhost:8080/
    //这边http://localhost:8080/无法访问是因为tomcat还没有启动
    //tomcat可以从官网上下载,有时候下载会比较慢,稳定的版本推荐tomcat8
    //这边之前已经下载过tomcat,
    //官网下载完tomcat压缩包后解压,进入tomcat文件夹bin目录下,双击startup.bat运行
    //如果出现窗口一闪消失的现象,则可能是jdk环境变量的问题,tomcat需要依靠jdk来运行
    //运行成功后再访问http://localhost:8080/即可看到tomcat的默认页面

    public static void main(String[] args) {
        try {
            URL url = new URL("http://localhost:8080/examples/1.jpg?username=tom");
            //获取URL的协议名
            System.out.println(url.getProtocol());
            //获取URL的主机名
            System.out.println(url.getHost());
            //获取URL的端口号
            System.out.println(url.getPort());
            //获取URL的文件路径
            System.out.println(url.getPath());
            //获取URL的文件名
            System.out.println(url.getFile());
            //获取URL的查询名
            System.out.println(url.getQuery());
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
