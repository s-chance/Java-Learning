### Request&Response
#### 原理
   1. request对象和response对象都是由服务器创建的
   2. request对象用于获取请求消息,response对象用于返回响应消息
#### Request的简单使用

   1. 获取请求行信息  
   [示例](src/com/entropy/test/request/RequestLineTest.java)
   2. 获取请求头信息  
   [示例](src/com/entropy/test/request/RequestHeadTest.java)
   3. 关于用户代理User-Agent,不同浏览器有不同的User-Agent
      ```text
      Edge
      Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.5112.102 Safari/537.36 Edg/104.0.1293.63
      
      Chrome
      Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/104.0.0.0 Safari/537.36
      
      FireFox
      Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:105.0) Gecko/20100101 Firefox/105.0
      ```
   4. 关于URI、URL访问的差异(需要启动多个web项目进行测试)  
      [代码示例](web/test.html)、[视频演示](URI、URL访问测试.mp4)
   5. 获取请求体数据  
      只有post请求方拥有请求体,post的请求参数就位于请求体中  
      示例:[前端](web/register.html)、[后端](src/com/entropy/test/request/PostRequestBody.java)

#### Request重要功能
为方便测试,统一使用doPost处理请求
   1. 获取请求参数(通用方式):[前端示例](web/demo.html)、[后端示例](src/com/entropy/test/request/RequestFunction.java)  
   2. 请求转发:一种在服务器内部的资源跳转方式  
   特点:
      1. 浏览器地址栏路径不发生变化
      2. 只能转发到当前服务器内部资源中
      3. 转发是一次请求  
   3. 共享数据(域对象,以request域为例)
   4. 获取ServletContext  
   示例:[发送端](src/com/entropy/test/request/RequestSend.java)、[接收端](src/com/entropy/test/request/RequestReceive.java)
---
#### Response常见状态码
| **状态码** | **说明**       |
| :----------: | :--------------: |
| 200        | 成功           |
| 302        | 重定向         |
| 404        | 请求资源未找到 |
| 405        | 请求方式不支持 |
| 500        | 服务器错误     |
#### Response常用响应头
| **名称**     | **说明**                            |
| :------------: | :-----------------------------------: |
| Location     | 请求重定向的地址,常与302配合使用 |
| Content-Type | 响应正文的MIME类型,编码格式        |
#### Response重定向功能
重定向的特点：

> 1.地址栏发生变化
>
> 2.重定向可以访问其他站点(服务器)的资源
>
> 3.重定向是两次请求,不能使用request对象来共享数据
>
> 示例:[初始端](src/com/entropy/test/response/ResponseSend.java)、[目标端](src/com/entropy/test/response/ResponseReceive.java)

#### 服务器输出字符数据到浏览器
> 中文乱码问题设置响应头
>
> setContentType(“text/html;charset=UTF-8”)
>
> [示例](src/com/entropy/test/response/ResponseChar.java)
#### 服务器输出字节数据到浏览器
> [示例](src/com/entropy/test/response/ResponseByte.java)
#### 网页验证码制作
示例:[前端](web/verify.html)、[后端](src/com/entropy/test/VerificationCode.java)  
模板素材:[工具类](src/com/entropy/util/IdentifyCode.java)、[使用示例](src/com/entropy/util/IdentifyDemo.java)  
模板素材来源于网络,如有侵权请联系[s-chance](https://github.com/s-chance) 删除