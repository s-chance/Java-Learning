package com.entropy;

import java.util.Scanner;
//工具类一般是为了优化代码而创建,一般采用静态方法,方便调用
public class InputUtils {

    //输入提示及输入操作 整数
    public static int getInt(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        //用hasNextInt()作为判断下一个输入是否为数字需要配合next()方法使用
        //hasNextInt()函数大体意思表示scanner当前的标记的输入是否为int,并不会自动移动标记
        //要实现hasNextInt的读取的标记位置的改变,可以用scanner.next()移动
        while (!scanner.hasNextInt()) {
            scanner.next();
            System.out.println("数据类型不匹配");
            System.out.println("请重新输入一个整数");
        }
        return scanner.nextInt();
    }

    //输入提示及输入操作 字符串
    public static String getStr(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }

    //输入提示及输入操作 字符
    public static char getChar(String msg) {
        System.out.println(msg);
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        while (!s.equals("男") && !s.equals("女")) {
            System.out.println("数据类型不匹配");
            System.out.println("请重新输入(男/女)");
            s = scanner.next();
        }
        return s.charAt(0);
    }
}
