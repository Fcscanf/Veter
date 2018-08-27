package cn.fcsanf.dao;

import cn.fcsanf.model.User;
import cn.fcsanf.utils.DataSourceUtils;
import cn.fcsanf.utils.Md5Utils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.taglibs.standard.tag.common.sql.DataSourceUtil;

import java.sql.SQLException;

/**
    *@Author:Fcscanf
    *@Description:用户处理的持久层-作用于数据库
    *@Date:下午 23:12 2018/4/28
    */
public class UserDao {
    User user = new User();

    public User findUserByUserNameAndPassword(String username, String password) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "seclect * from users where username=? and password=?";
        return runner.query(sql, new BeanHandler<User>(User.class), username, Md5Utils.md5(password));
    }

    public void addUser(User user) throws SQLException {
        QueryRunner runner = new QueryRunner(DataSourceUtils.getDataSource());
        String sql = "insert into users values (null,'user',?,?,?,?,?,0)";
        runner.update(sql,user.getUsername(),Md5Utils.md5(user.getPassword()),user.getEmail(),user.getAge(),user.getSex(),user.getAddress());
    }
}
