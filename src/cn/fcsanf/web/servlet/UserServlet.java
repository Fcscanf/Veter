package cn.fcsanf.web.servlet;

import cn.fcsanf.model.User;
import cn.fcsanf.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.security.auth.login.LoginException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.net.URLEncoder;
import java.sql.SQLException;
import java.util.Map;

//@WebServlet("/user")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 得到请求参数method,判断当前是什么操作
        String method = request.getParameter("method");

        if ("login".equals(method)) { // 登录操作台
            login(request, response);
        } else if ("regist".equals(method)) { // 注册操作
            try {
                regist(request, response);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }

    private void login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        UserServiceImpl userService = new UserServiceImpl();
        try {
            User user = userService.login(username, password);
            if (user != null) {
                // 用户如果登录成功，判断是否勾选了记住用户名.
                String saveUsername = request.getParameter("remember");
                if ("on".equals(saveUsername)) {
                    Cookie cookie = new Cookie("saveusername", URLEncoder.encode(username, "utf-8"));
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("saveusername", URLEncoder.encode(username, "UTF-8"));
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

//                自动登录
                String autologin = request.getParameter("autologin");
                if ("on".equals(autologin)) {
                    // 勾选了自动登录，就将用户名与密码存储到cookie中.
                    Cookie cookie = new Cookie("autologin", URLEncoder.encode(username, "utf-8") + "%Fcscanf%" + password);
                    cookie.setMaxAge(7 * 24 * 60 * 60);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                } else {
                    Cookie cookie = new Cookie("autologin", URLEncoder.encode(username, "utf-8") + "%Fcscanf%" + password);
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }

//                登录成功后将用户存储到session中
                request.getSession().invalidate();
                request.getSession().setAttribute("user", user);
                response.sendRedirect(request.getContextPath() + "index.jsp");
                return;
            } else {
                request.setAttribute("login.message", "用户名或密码错误！");
                request.getRequestDispatcher("/page.jsp").forward(request, response);
                return;
            }
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ServletException e) {
            e.printStackTrace();
        }
    }

    private void regist(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, SQLException {
//        验证码验证
        /*String checkcode = request.getParameter("checkcode");
        String _checkcode = (String) request.getSession().getAttribute("checkcode_session");

        request.getSession().removeAttribute("checkcode_session");
        if (_checkcode == null || !_checkcode.equals(checkcode)) {
            request.setAttribute("regist.message","验证码不正确");
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }*/

//        1.得到请求的参数，服装到javaBean
        User user = new User();
        try {
            BeanUtils.populate(user,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

//        进行服务器端数据校验
        Map<String,String> map = user.validateRegist();
        if (map.size() > 0) {
            request.setAttribute("map",map);
            request.getRequestDispatcher("/regist.jsp").forward(request,response);
            return;
        }
//        调用service操作
        UserServiceImpl service = new UserServiceImpl();
        service.regist(user);
        response.getWriter().write("注册成功，请<a href=' " + request.getContextPath() + "/index.jsp'>登录</a>");
    }
}
