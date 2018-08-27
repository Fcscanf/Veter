package cn.fcsanf.test;

import cn.fcsanf.dao.DataDao;
import cn.fcsanf.utils.DataServerUtils;
import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MyTest {
    Date date = new Date();
    DataDao dataDao = new DataDao();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String currentime = dateFormat.format(new Date());
    public static void main(String[] args) throws IOException {
        DataServerUtils dataServer = new DataServerUtils();
        dataServer.DataServer();
    }

    @Test
    public void SqlTest() throws SQLException {
        System.out.println(dataDao.lastdata());
    }
}
