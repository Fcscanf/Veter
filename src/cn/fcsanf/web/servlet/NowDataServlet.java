package cn.fcsanf.web.servlet;

import cn.fcsanf.service.impl.DataServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

//@WebServlet(name = "NowDataServlet")
public class NowDataServlet extends HttpServlet {
    DataServiceImpl dataService = new DataServiceImpl();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            //设定编码
            response.setCharacterEncoding("UTF-8");
            //表示是json类型的数据
            response.setContentType("application/json");
            response.getWriter().write(dataService.getnewdata());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
