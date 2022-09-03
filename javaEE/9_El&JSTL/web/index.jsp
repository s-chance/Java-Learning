<%@ page import="com.entropy.pojo.User" %>
<%@ page import="java.util.Date" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: Entropy
  Date: 2022/8/30
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Expression Language</title>
  </head>
  <body>
  <%--java代码块:在request域中存入数据--%>
  <%
    request.setAttribute("msg", "Expression");
  %>

  <%--java代码块:获取request域数据--%>
  <%
    out.print("通过java代码获取的数据:" + request.getAttribute("msg"));
  %>
  <br>
  <%--jsp表达式:获取request域数据--%>
  <%="通过jsp表达式获取的数据:" + request.getAttribute("msg")%>
  <br>
  <%--EL表达式:获取request域数据--%>
  通过EL表达式获取的数据:${msg}
  <br>
  <hr>
  <h1>EL表达式的其它功能</h1>
  <h2>算术运算符</h2>
  ${3 + 2}<br>
  ${7 - 9}<br>
  ${4 * 8}<br>
  ${35 / 7}<br>
  ${35 div 5}<br>
  ${123 % 10}<br>
  ${231 mod 100}<br>
  <h2>比较运算符</h2>
  ${1 > 3}<br>
  ${23 < 45}<br>
  ${1 == 1}<br>
  <h2>逻辑运算符</h2>
  ${3 >= 4 && 1 < 2}<br>
  ${3 >= 4 and 1 < 2}<br>
  ${3 >= 4 || 1 < 2}<br>
  ${3 >= 4 or 1 < 2}<br>
  ${!(3 >= 4) && 1 < 2}<br>
  <h2>数据获取</h2>
  <%
    //分别在request域和session存入数据
    request.setAttribute("name", "tom");
    session.setAttribute("password", 123);
  %>
  <%--为了区分不同域的数据,不会直接写数据的键,而是会在键前面加上对应的域--%>
  ${requestScope.name}
  ${sessionScope.password}<br>
  <%--指定的键如果不存在,则不会获取任何数据,前端页面也不会有任何提示--%>
  ${sessionScope.isExist}

  <%--关于区分域的必要性,如果不同域中使用了相同的键值,那么在未指定域的情况下,EL表达式会从小到大地寻找域中的数据--%>
  <%--关于域的大小:page < request < session < application--%>
  <%--其中application就是servletContext在jsp页面的别称,二者实际上是同一个对象--%>
  <%
    pageContext.setAttribute("data", "page");
    request.setAttribute("data", "request");
    session.setAttribute("data", "session");
    application.setAttribute("data", "application");
  %>
  ${data}
  ${applicationScope.data}
  <hr>
  <h1>获取对象、List集合、Map集合的数据</h1>
  <%
    //对象数据
    User user = new User("xyz", 12, new Date());
    request.setAttribute("user", user);
    //List集合数据
    ArrayList arrayList = new ArrayList();
    arrayList.add("a");
    arrayList.add("b");
    arrayList.add("c");
    arrayList.add(user);
    request.setAttribute("list", arrayList);
    //Map集合数据
    HashMap hashMap = new HashMap();
    hashMap.put("level", 5);
    hashMap.put("score", 100);
    request.setAttribute("map", hashMap);
  %>
  <h2>对象中的数据</h2>
  <%--EL表达式会自动将后面的属性名首字母转为大写字母,并加上get的前缀,再到实体类里找到匹配的名称--%>
  <%--因此EL表达式中属性名的写法为实体类的方法名去掉get前缀并将剩下的单词的首字母改为小写字母--%>
  ${requestScope.user}<br>
  ${requestScope.user.name}
  ${requestScope.user.age}
  ${requestScope.user.formatTime}
  <h2>List集合中的数据</h2>
  ${list}<br>
  ${list[0]}<br>
  ${list[1]}<br>
  ${list[2]}<br>
  <%--这里获取的是User对象--%>
  ${list[3].name}<br>
  <%--下标越界,则不会获取任何数据,前端页面也不会有任何提示--%>
  ${list[10]}
  <h2>Map集合中的数据</h2>
  ${map.level}
  ${map["score"]}
  <hr>
  <h1>empty运算符</h1>
  <%
    String str = "abc";
    String no = "";
    String nothing = null;
    request.setAttribute("str", str);
    request.setAttribute("no", no);
    request.setAttribute("nothing", nothing);
  %>
  判断字符串、集合、数组对象是否为null或者长度为零:
  ${empty str}
  ${empty no}
  ${empty nothing}<br>
  判断字符串、集合、数组对象是否不为null或者长度不为零:
  ${not empty str}
  ${not empty no}
  ${not empty nothing}
  <hr>
  <h1>jsp动态获取虚拟目录</h1>
  ${pageContext.request}<br>
  ${pageContext.request.contextPath}
  </body>
</html>
