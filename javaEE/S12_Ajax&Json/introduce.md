### Ajax
#### 概念
ajax全称Asynchronous JavaScript And XML(异步的JavaScript和XML)  
关于异步与同步:  
- 建立在客户端和服务端相互通信的基础上
- 同步要求客户端必须等待服务器的响应, 在等待期间客户端无法进行其他操作
- 异步允许客户端在等待服务器处理请求返回响应的期间进行其他操作  
Ajax本身不是一种新技术, 而是由多种技术综合起来用于快速创建动态网页的综合性技术
#### 作用
一般网页更新内容需要加载整个网页, 这样对于经常更新的网页来说会降低效率, 
Ajax的使用能够让浏览器与服务器进行少量数据交换, 实现异步更新, 
即在不加载整个网页的前提下对网页的部分内容进行局部更新, 
有效提升了用户体验
#### 简单使用
> 原生js[案例](web/js_ajax.html)
>
> jq $.ajax[案例](web/jq_ajax.html)
>
> jq $.get[案例](web/jq_get.html)
>
> jq $.post[案例](web/jq_post.html)
>
> [测试用servlet程序](src/com/entropy/web/servlet/AjaxServlet.java)

### Json
#### 概念
json全称JavaScript Object Notation(JavaScript对象标记法)  
json是一种存储和交换数据的语法
json是通过JavaScript对象标记法书写的文本
#### 作用
json格式能够做为任何编程语言的数据格式, 能够在服务器和浏览器之间轻松传输  
json格式所具有的简洁和清晰的层次结构使得json成为理想的数据交换语言, 易于阅读和编写、解析和生成， 有效提升了网络传输效率
#### 语法格式
> 数字、字符串、逻辑值、数组、对象
>
> 以键值对的形式书写, 在标准json文件中以双引号包围键和值, 在其他文件中视情况而定
>
> json数组由[]包围、json对象由{}包围, 对象与数组之间又可以相互嵌套
>
> 多个数据之间以,分隔
>
> [简单示例](web/data.json)
>
> [在js中的使用](web/json.html)

### Json转换工具
- json转换工具使得json能够在java代码中使用
- json转换工具这里是指由java封装好的jar工具包
- json转换工具使得java对象或集合与json格式字符串能够相互转换
- 开源免费的json转换工具: Jackson, SpringMVC默认的json转换工具
- 常用的json解析器: Jsonlib、Gson、fastjson、jackson
#### 简单使用
> 1.导入jar包: 
> `jackson-annotations-2.2.3.jar`
> `jackson-core-2.2.3.jar`
> `jackson-databind-2.2.3.jar`
>
> 2.创建核心对象
>
> 3.调用转换方法
>
> [简单示例](src/com/entropy/test/JsonTest.java)

### 案例: 通过ajax发送json数据与后端交互
用户验证: [前端](web/register.html)、[后端](src/com/entropy/web/servlet/CheckServlet.java)