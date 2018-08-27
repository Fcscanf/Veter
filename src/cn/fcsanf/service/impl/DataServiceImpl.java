package cn.fcsanf.service.impl;

import cn.fcsanf.dao.DataDao;
import cn.fcsanf.model.Data;

import java.sql.SQLException;

/**
    *@Author:Fcscanf
    *@Description:数据处理的业务层-依赖dao层-impl为实现类
    *@Date:下午 23:14 2018/4/28
    */
public class DataServiceImpl {
    DataDao dataDao = new DataDao();

    public void SaveData(Data data) throws SQLException {
        dataDao.UpdateData(data);
    }

    public String getnewdata() throws SQLException {
        return dataDao.lastdata();
    }
}
