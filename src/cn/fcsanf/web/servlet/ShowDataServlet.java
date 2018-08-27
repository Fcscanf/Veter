package cn.fcsanf.web.servlet;

import cn.fcsanf.model.Data;
import cn.fcsanf.utils.JDBCUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//@WebServlet(name = "ShowDataServlet")
public class ShowDataServlet extends HttpServlet {
    Data data = new Data();
    Connection connection = JDBCUtil.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Map> list = new ArrayList<Map>();
        String sql = "select * from datalist order by id desc";
        try {
            preparedStatement = connection.prepareStatement(sql);
            resultSet = preparedStatement.executeQuery(sql);
            while (resultSet.next()) {

                int id = resultSet.getInt("id");
                int temperature = resultSet.getInt("temperature");
                int ph = resultSet.getInt("ph");
                int turbidity = resultSet.getInt("turbidity");
                String currentime = resultSet.getString("currentime");

                Map map = new HashMap();
                map.put("id",id);
                map.put("temperature",temperature);
                map.put("ph",ph);
                map.put("turbidity",turbidity);
                map.put("currentime",currentime);
                list.add(map);
//                for (Map map1 : list) {
//                    System.out.println(map1);
//                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("key_list",list);
        request.getRequestDispatcher("/jsp/page.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}
