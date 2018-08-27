package cn.fcsanf.web.servlet;

import cn.fcsanf.service.impl.DataServiceImpl;
import cn.fcsanf.utils.DataServerUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

//@WebServlet(name = "DataServlet")
public class DataServlet extends HttpServlet {
    DataServiceImpl dataService = new DataServiceImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DataServerUtils dataServer = new DataServerUtils();
        dataServer.DataServer();
    }
}
