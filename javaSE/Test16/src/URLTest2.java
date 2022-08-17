import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLTest2 {

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


    //这边使用tomcat来下载存储在tomcat中的资源
    //由于是在本地这边事先将资源迁移到tomcat中webapps\examples目录下

    //如果是使用购买的服务器则可以在互联网上供广大用户访问,下载
    //本地服务器除去特殊手段只能由自己访问,且不能像购买的服务器那样24小时不关机

    public static void main(String[] args) throws IOException {
        URL url = new URL("http://localhost:8080/examples/1.jpg");
        //获取HttpURL连接
        HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
        //获取连接
        urlConnection.connect();
        //获取输入流
        InputStream inputStream = urlConnection.getInputStream();
        //保存到本地
        FileOutputStream fileOutputStream = new FileOutputStream("D:\\git-repo\\Java-Learning\\javaSE\\Test16\\url.jpg");
        byte[] bytes = new byte[1024];
        int len;
        while ((len = inputStream.read(bytes)) != -1) {
            fileOutputStream.write(bytes, 0, len);
        }

        System.out.println("下载完成");
        //关闭资源
        fileOutputStream.close();
        inputStream.close();
        //断开连接
        urlConnection.disconnect();
    }
}
