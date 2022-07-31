public class SystemTest {
    public static void main(String[] args) {
        //System类获取系统信息

        //java版本
        String javaVersion = System.getProperty("java.version");
        System.out.println("javaVersion = " + javaVersion);

        //jdk路径
        String javaHome = System.getProperty("java.home");
        System.out.println("javaHome = " + javaHome);

        //win操作系统版本
        String osVersion = System.getProperty("os.version");
        System.out.println("osVersion = " + osVersion);

        //用户路径
        String userHome = System.getProperty("user.home");
        System.out.println("userHome = " + userHome);

        //用户名称
        String userName = System.getProperty("user.name");
        System.out.println("userName = " + userName);

        //项目路径
        String userDir = System.getProperty("user.dir");
        System.out.println("userDir = " + userDir);

    }
}
