### Cookie&Session
#### 会话技术
概念:一次会话中包含多次请求和响应  
一次会话是在浏览器第一次给服务器资源发送请求时建立,直到一方断开连接  
功能:在一次会话的范围内的多次请求之间能够共享数据  
> 会话管理
>
> 客户端会话技术:Cookie
>
> 服务端会话技术:Session
#### Cookie
概念:客户端会话技术,数据保存在客户端
> 简单使用
>
> 1.创建Cookie对象,绑定数据(注意cookie无法直接绑定某些特殊字符)
>
> 2.发送Cookie对象
>
> 3.获取Cookie对象,读取数据
>
> 示例:[发送端](src/com/entropy/cookie/CookieSend.java)、[接收端](src/com/entropy/cookie/CookieReceive.java)
>
> 补充:删除Cookie中的数据一般通过setMaxAge方法实现或者通过浏览器设置

原理:基于响应头set-cookie和请求体cookie实现  
部分细节:
1. cookie一次可以发送多个
2. 默认情况下,cookie数据会在浏览器关闭后销毁  
   持久化存储可以用浏览器自带的设置或者代码实现  
   另外也需要注意浏览器是否设置关闭时自动清理cookie以及浏览器设置的优先级要高于程序的设计
3. 关于cookie能否存储中文数据  
   tomcat8版本之前cookie无法直接存储中文数据,需要对中文进行转码  
   tomcat8版本之后cookie能够存储中文数据,特殊字符不支持,需要使用URL编码来存储和解析
4. cookie跨项目共享数据
   - 默认情况下不能共享
   - 需要共享可以通过setPath(String path)方法设置cookie的获取范围
5. cookie的特点及主要用途:  
   1.cookie数据都存储在浏览器客户端  
   2.浏览器对单个cookie的大小有限制(最大4kB)  
   3.浏览器对同一个域名下的cookie总数有限制(最多20个)  
   4.cookie主要用于存储少量、不敏感的数据  
   5.cookie的使用使得用户无需重复登录就能完成服务器对客户端的身份识别
6. 使用cookie模拟网页记录访问状态  
   [示例](src/com/entropy/demo/CookieDemo.java)
#### Session
概念:服务端会话技术,数据保存在服务端
> 简单使用
> 
> 1.获取Session对象,存储数据
>
> 2.读取Session对象中的数据
>
> 3.删除数据
>
> 4.获取SessionId(与Session原理有关)
>
> 5.销毁Session
>
> 示例:[发送端](src/com/entropy/session/SessionSend.java)、[接收端](src/com/entropy/session/SessionReceive.java)

原理:HttpSession本质上还是一个Cookie,是一个由服务器自动创建的特殊的Cookie  
这个特殊的Cookie的名称为JSESSIONID,它的数据值是服务器分配的一个唯一的标识值  
通过这个唯一的标识值

部分细节
1. 客户端(浏览器)关闭,服务端保持开启  
  默认情况下,客户端重新获取的是一个新的session,即session默认不开启持久化  
  由于Session需要依赖Cookie来实现功能(可以用其它技术手段来代替cookie,不过一般情况下都是用的cookie),  
  因此持久化可以通过修改JSESSIONID这个用于标识Session的特殊的Cookie的存活时间来实现
2. 客户端保持开启,服务端关闭  
  默认情况下,客户端获取的是新的session,但由于关闭是服务端,为了保护用户的数据,一般开发中都会开启持久化  
  关于服务端的session持久化(HttpSession的钝化和活化)  
  HttpSession钝化:在服务器正常关闭之前,将Session对象序列化到硬盘上  
  HttpSession活化:在服务器启动之后,将Session文件转化为内存中的Session对象
3. session的失效时间有三种情况
   - 在未进行持久化的情况下关闭服务器(cookie则是浏览器关闭)
   - 调用invalidate()方法,然而实际开发中这种方法很少使用  
     在程序中cookie并没有直接性的销毁方法,而是间接利用了存活时间设置  
     有一点值得注意的是JSESSIONID的销毁并不会导致session本身的销毁。只是失去了作为唯一标识的JSESSIONID,服务器就无法再找到原先的session(原先的session会在超过有效时间后自动销毁)
   - 超过session的默认30分钟有效时间或手动设置的有效时间  
4. session的特点及主要用途  
   1. session用于存储一次会话的多次请求的数据
   2. session可以存储任意类型、任意大小的数据
   3. session的安全性也要高于cookie,但仍存在一定的风险
5. session实现记住密码功能  
   示例:[前端登录](web/index.jsp)、[后端验证](src/com/entropy/demo/LoginServlet.java)、[验证码生成](src/com/entropy/demo/VerificationCode.java)
   

  