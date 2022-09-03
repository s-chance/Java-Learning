### Filter过滤器&Listener监听器
#### Filter过滤器
##### 概念:JavaWeb三大组件之一,Filter能够拦截对服务器资源的请求,限制用户对服务器访问的权限,进而实现特殊的功能  

##### 作用:拦截请求,实现登录验证、统一编码处理以及敏感词过滤等功能,保护服务器资源的安全  

##### 简单使用
> 创建类,实现Filter接口,并重写方法
>
> 配置@WebFilter注解或配置[web.xml](web/WEB-INF/web.xml)
>
> [示例](src/com/entropy/web/filter/FilterTest.java)

##### 生命周期  
init:在服务启动后,创建Filter对象后,调用init方法加载资源(仅执行一次)  
doFilter:每一次拦截请求时会执行  
destroy:服务器正常关闭,Filter对象销毁,调用destroy方法释放资源(仅执行一次)

##### 注意
- 由于过滤器功能的特殊性,为防止混淆,在测试过滤器时,请关闭其它的过滤器(注释掉@WebFilter或者web.xml中的配置信息),以避免多个过滤器之间的干扰,或者在对应的过滤器下输出对应的信息提示
- 过滤器的配置既可以通过注解实现,也可以通过web.xml配置实现,但要注意注解配置不能和web.xml的配置有冲突

##### 示例  
过滤器:  
[拦截所有请求](src/com/entropy/web/filter/FilterTest.java)  
[拦截所有对jsp文件的访问请求](src/com/entropy/web/filter/FilterJsp.java)  
[拦截对index.jsp的特定方式的访问请求](src/com/entropy/web/filter/FilterIndex.java)(这里写了三种情况)  
[拦截多级目录下的所有内容](src/com/entropy/web/filter/FilterServletDemo.java)  
servlet程序:  
多级目录拦截测试用例:[demo1](src/com/entropy/web/servlet/ServletDemo1.java)、[demo2](src/com/entropy/web/servlet/ServletDemo1.java)  
转发访问用例:[forward](src/com/entropy/web/servlet/ServletForward.java)  

##### 多个过滤器先后执行顺序  
通过注解配置,则由类名的字符串比较值大小,从小到大依次执行  
通过web.xml,则由<filter-mapping>在web.xml中配置的位置,从上到下依次执行

##### 案例  
[登录鉴权](src/com/entropy/web/demo/filter/LoginFilter.java)、[敏感词过滤](src/com/entropy/web/demo/filter/WordFilter.java)  
关于敏感词过滤参考了动态代理设计模式增强了getParameter方法,使得在其获取前端参数时通过动态代理过滤掉敏感词(动态代理[简单示例](src/com/entropy/test/ProxyTest.java))
---
#### Listener监听器
##### 概念:JavaWeb三大组件之一,Listener能够监听某个事件源上发生的某个特定的事件并执行代码
##### 机制:将事件、事件源、监听器绑定在一起
##### 简单使用
> 创建类实现Listener接口(这里以监听ServletContext对象为例),并重写方法
>
> 配置web.xml或者使用@WebListener注解
>
> 示例:[监听ServletContext的创建与销毁](src/com/entropy/web/listener/ContextListener.java)、[监听Session的创建与销毁](src/com/entropy/web/listener/SessionListener.java)
##### 生命周期
Listener的一次生命周期取决于它所监听的对象

### 补充
可尝试将本module的过滤器和监听器移植到S10_Demo中完善JavaWeb项目
