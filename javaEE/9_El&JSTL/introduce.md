### EL表达式
基本概念:全称Expression Language表达式语言,是一种servlet规范,在jsp2.0中引入  
作用:用于jsp页面,以简单的表达式获取域对象中的数据,而不需要写复杂的java代码块和jsp表达式  
语法:${表达式}  
注意:jsp默认支持EL表达式,忽略表达式可以修改page指令或者在表达式前用转义字符\  
[示例](web/index.jsp)、[测试用例](src/com/entropy/pojo/User.java)
### JSTL
概念:全称JSP Standard Tag Library(JSP标准标签库),由Apache组织提供的开源jsp标签  
作用:和EL表达一样简化了jsp页面的java代码开发,一般和EL表达式组合使用  
> 简单使用
>
> 1.导入必要的jar包,路径WEB-INF/lib
> `javax.servlet.jsp.jstl.jar`
> `jstl-impl.jar`
>
> 2.taglib指令引入标签库 
>
> 3.使用标签库,主要使用的是if、choose和foreach标签
>
> [if标签示例](web/if.jsp)、[choose标签示例](web/choose.jsp)、[foreach标签示例及综合使用](web/foreach.jsp)