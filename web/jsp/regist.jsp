<%--
  Created by IntelliJ IDEA.
  User: fcsca
  Date: 2018/4/28
  Time: 下午 23:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Title</title>
    <script type="text/javascript">
        function change() {
            document.getElementById("im").src = "${pageContext.request.contextPath}/checkcode?time" + new Date().getTime();
        };

        function checkForm() {
            //先得到所有的span，将其内容清空
            var spans = document.getElementsByTagName("span");
            for (var i=0;i<spans.length;i++){
                spans[i].innerHTML = "";
            }

            var flag1 = checkNull("username");
            var flag2 = checkNull("password");
            var flag3 = checkNull("repassword");
            var flag4 = checkNull("age");
            var flag5 = checkNull("sex");
            var flag6 = checkNull("address");
            //对确认密码进行操作
            var flag7=repasswordValidate();

            return flag1&&flag2&&flag3&&flag4&&flag5&&flag6&&flag7;
        };

        function repasswordValidate(){

            var value1=document.getElementById("password").value;
            var value2=document.getElementById("repassword").value;

            if(value1==value2){
                return true;
            }else{
                document.getElementById("repassword_span").innerHTML="两次密码不一致";
                return false;
            }
        }

        //非空操作
        function checkNull(field){
            var reg = /^\s*$/; //代表0个或多个空白符

            var value = document.getElementById(field).value;

            if (reg.test(value)) {
                document.getElementById(field+"_span").innerHTML=(field+"不能为空");
                return false;
            }

            return true;
        }
    </script>
</head>
<body>
${requestScope["regist.message"]}
<br>
<div>
    <form action="${pageContext.request.contextPath}/user" method="post" onsubmit="return checkForm();">
        <input type="hidden" name="method" value="regist"><!--当前为注册操作-->
        <table border="1" align="center" width="50%">
            <caption>用户注册</caption>
            <tr>
                <td>用户名</td>
                <td><input type="text" name="username" id="username"><span
                        id="username_span"></span></td>
            </tr>

            <tr>
                <td>密码</td>
                <td><input type="password" name="password" id="password"><span
                        id="password_span"></span></td>
            </tr>

            <tr>
                <td>确认密码</td>
                <td><input type="password" name="repassword" id="repassword"><span
                        id="repassword_span"></span></td>
            </tr>

            <tr>
                <td>邮箱</td>
                <td><input type="text" name="email" id="email"><span
                        id="email_span"></span></td>
            </tr>

            <tr>
                <td>年龄</td>
                <td><input type="text" name="age" id="age"><span
                        id="age_span"></span></td>
            </tr>

            <tr>
                <td>性别</td>
                <td><input type="text" name="sex" id="sex"><span
                        id="sex_span"></span></td>
            </tr>

            <tr>
                <td>地址</td>
                <td><input type="text" name="address" id="address"><span
                        id="address_span"></span></td>
            </tr>

            <tr>
                <td colspan="2" align="center"><input type="submit" value="注册">&nbsp;&nbsp;&nbsp;&nbsp;<input
                        type="reset" value="取消"></td>
            </tr>
        </table>
    </form>
</div>
<body>
</body>
</html>
