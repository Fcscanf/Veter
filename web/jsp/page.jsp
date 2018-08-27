<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2018/5/1
  Time: 下午 19:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>WaterData</title>
    <style>
        th, tr, td, table {
            align:"center";
        }
    </style>

    <script>
        function Update() {
            $.get(ShowDataServlet);
        }
    </script>

</head>
<body>
<h1>历史数据显示</h1><br>
    <table border="1" align="center" width="50%">
        <caption>
            <h3>历史数据</h3>
            <input type="submit" value="刷新" onclick="Update">&nbsp;&nbsp;&nbsp;
        </caption>

        <tr>
            <th>序号</th>
            <th>温度</th><!--temperature-->
            <th>PH</th><!--ph-->
            <th>浊度</th><!--turbidity-->
            <th>数据提交时间</th><!--currentime-->
        </tr>

        <c:forEach items="${key_list}" var="usr" varStatus="index">
            <tr>
                <td>${usr.id}</td><td>${usr.temperature}</td><td>${usr.ph}</td><td>${usr.turbidity}</td><td>${usr.currentime}</td>
            </tr>
        </c:forEach>

    </table>
</form>
</body>
</html>
