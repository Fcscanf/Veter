package cn.fcsanf.dao;

import cn.fcsanf.model.Data;
import cn.fcsanf.utils.DataSourceUtils;
import cn.fcsanf.utils.JDBCUtil;
import org.apache.commons.dbutils.QueryRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
    *@Author:Fcscanf
    *@Description:数据处理的持久层-即作用于数据库
    *@Date:下午 23:11 2018/4/28
    */
public class DataDao {
    Data data = new Data();
    Date date = new Date();
    Connection connection = JDBCUtil.getConnection();
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentime = dateFormat.format(new Date());

    public void UpdateData(Data data) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into datalist values (null,?,?,?,?)";
        runner.update(sql, data.getTemperature(), data.getPh(), data.getTurbidity(),currentime);
    }

    public String lastdata() throws SQLException {
        int temperature = 0;
        int ph = 0;
        int turbidity = 0;
        String lasttime = "";
        String sql = "select * from datalist order by id desc limit 0,1";
        preparedStatement = connection.prepareStatement(sql);
        resultSet = preparedStatement.executeQuery(sql);
        while (resultSet.next()) {
            temperature = resultSet.getInt("temperature");
            ph = resultSet.getInt("ph");
            turbidity = resultSet.getInt("turbidity");
            lasttime = resultSet.getString("currentime");
        }
        String test = "{\"temperature\":" + temperature + "," + "\"ph\":" + ph + ",\"turbidity\":" + turbidity + ",\"lasttime\":" + "\"" + lasttime + "\"" +"}";
        return test;
    }
}
