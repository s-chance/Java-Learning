import java.io.File;
import java.io.IOException;

public class FileTest {
    public static void main(String[] args) throws IOException {
        //File类
        //构造方法
        //绝对路径、相对路径
        //绝对路径:带有盘符如C、D等开头的路径(windows系统下)
        //相对路径:不带有盘符,是相对的一个文件夹或文件

        //绝对路径创建File对象
        File file1 = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12\\test01.txt");
        System.out.println("file1 = " + file1);

        //父目录加子文件创建File对象
        File file2 = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12", "test02.txt");
        System.out.println("file2 = " + file2);

        //父File类加子文件创建File对象
        File parent = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12");
        File file3 = new File(parent, "test03.txt");
        System.out.println("file3 = " + file3);

        //成员方法
        //createNewFile具体创建出一个文件(需要抛出IOException)
        //true表示创建成功,false表示已经存在创建的文件或创建失败
        boolean newFile1 = file1.createNewFile();
        System.out.println("newFile1 = " + newFile1);


        //mkdir创建一级目录,不能创建多级目录
        File dir = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12\\dir");
        boolean mkdir = dir.mkdir();
        System.out.println("mkdir = " + mkdir);

        //mkdirs创建多级目录
        File dirs = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12\\a\\b\\c");
        boolean mkdirs = dirs.mkdirs();
        System.out.println("mkdirs = " + mkdirs);

        //delete删除文件夹,但要求当前文件夹内不能有其他文件或文件夹
        boolean delete = dirs.delete();
        System.out.println("delete = " + delete);

        System.out.println();

        //判断
        //isDirectory判断一个File对象是否为目录
        boolean file1_isDirectory = file1.isDirectory();
        System.out.println("file1_isDirectory = " + file1_isDirectory);
        boolean dir_isDirectory = dir.isDirectory();
        System.out.println("dir_isDirectory = " + dir_isDirectory);

        System.out.println();

        //isFile判断一个File对象是否为文件
        boolean file1_isFile = file1.isFile();
        System.out.println("file1_isFile = " + file1_isFile);
        boolean dir_isFile = dir.isFile();
        System.out.println("dir_isFile = " + dir_isFile);

        System.out.println();

        //exists判断一个文件或文件夹是否存在
        File isExist = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12\\abcdefg");
        boolean exists = isExist.exists();
        System.out.println("exists = " + exists);

        boolean existsFile1 = file1.exists();
        System.out.println("existsFile1 = " + existsFile1);

        System.out.println();
        //获取
        //getAbsolutePath获取绝对路径
        String file2AbsolutePath = file2.getAbsolutePath();
        System.out.println("file2AbsolutePath = " + file2AbsolutePath);

        //getPath获取相对路径
        File relative = new File("relativeFile.txt");
        String relativePath = relative.getPath();
        System.out.println("relativePath = " + relativePath);
        System.out.println("absolutePath = " + relative.getAbsolutePath());

        //getName获取文件或文件夹名称
        String file3Name = file3.getName();
        System.out.println("file3Name = " + file3Name);

        //lastModified获取文件最后一次修改的时间
        long l = file1.lastModified();
        System.out.println(l);

        System.out.println();

        //listFiles获取指定目录下的所有File对象,返回一个File数组
        File main = new File("D:\\git-repo\\Java-Learning\\javaSE\\Test12");
        File[] files = main.listFiles();
        for (File file : files) {
            System.out.println(file);
        }

        //list获取指定目录下的所有File对象,返回一个名称数组
        String[] list = main.list();
        for (String s : list) {
            System.out.println(s);
        }
    }
}
