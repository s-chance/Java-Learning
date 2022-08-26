package com.entropy.test;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/verify")
public class VerificationCode extends HttpServlet {

    private Random random = new Random();

    //验证码字符随机色
    private Color getRandomColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int width = 100;
        int height = 50;

        //创建一个验证码图片对象
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        //美化图片
        //1.背景色填充
        Graphics graphics = bufferedImage.getGraphics(); //画笔对象
        graphics.setColor(Color.white); //白色背景
        graphics.fillRect(0, 0, width, height); //填充颜色

        //2.边框绘制
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0, 0, width-1 ,height-1);

        //验证码字符集
        char[] arr = {'A', 'B', 'C', 'D', 'N', 'E', 'W', 'b', 'o', 'y','l','c','q',
                '0', '1', '2', '3', '4', '5', '6','7','8','9'};

        //3.随机获取4个验证码字符
        for (int i = 0; i < 4; i++) {
            int index = random.nextInt(arr.length);
            char c = arr[index];
            graphics.setColor(getRandomColor()); //随机色
            graphics.setFont(new Font(Font.DIALOG, Font.BOLD + Font.ITALIC, 19)); //字体样式
            graphics.drawString(String.valueOf(c), width/5*i+10, 30); //输出每个字符
        }

        //4.干扰线绘制
        for (int i = 0; i < 8; i++) {
            int x1 = random.nextInt(width);
            int y1 = random.nextInt(height);
            int x2 = random.nextInt(width);
            int y2 = random.nextInt(height);

            graphics.setColor(getRandomColor());
            graphics.drawLine(x1, y1, x2, y2);
        }


        //将图片展示到前端页面
        ImageIO.write(bufferedImage, "jpg", resp.getOutputStream());

    }

}
