package com.entropy.test;

import com.entropy.util.EncodeUtil;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.FileInputStream;
import java.io.IOException;

@WebServlet("/download")
public class DataDownload extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求参数,文件名
        String filename = req.getParameter("filename");

        //使用字节输入流加载文件至内存
        //确认服务器存储路径
        ServletContext servletContext = this.getServletContext();
        String realPath = servletContext.getRealPath("/resources/" + filename);
        //使用字节输入流
        FileInputStream fileInputStream = new FileInputStream(realPath);

        //设置Response
        //设置响应头类型content-type
        String mimeType = servletContext.getMimeType(filename);
        resp.setHeader("content-type", mimeType);

        //解决中文乱码问题
        //获取user-agent请求头,包含浏览器的版本信息
        String agent = req.getHeader("user-agent");
        //使用处理编码方式的工具类重新编写文件名
        filename = EncodeUtil.getFilename(agent, filename);

        //设置响应头打开方式content-disposition  attachment:表示附件
        resp.setHeader("content-disposition", "attachment;filename="+filename);

        //将字节输入流的数据传入输出流
        ServletOutputStream outputStream = resp.getOutputStream();
        byte[] bytes = new byte[1024 * 8];
        int len = 0;
        while ((len = fileInputStream.read(bytes)) != -1) {
            outputStream.write(bytes, 0, len);
        }
        outputStream.close();
        fileInputStream.close();
    }
}
