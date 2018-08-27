package cn.fcsanf.service.impl;

import cn.fcsanf.dao.UserDao;
import cn.fcsanf.model.User;

import javax.security.auth.login.LoginException;
import java.sql.SQLException;

/**
    *@Author:Fcscanf
    *@Description:用户处理的业务层-增删改查-依赖dao层-impl为实现类
    *@Date:下午 23:14 2018/4/28
    */
public class UserServiceImpl {
    UserDao userDao = new UserDao();

    public User login(String username, String password) throws LoginException {
        UserDao userDao = new UserDao();
        User user = null;
        try {
            user = userDao.findUserByUserNameAndPassword(username, password);
            if (user == null) {
                throw new LoginException("用户名或密码不正确");
            }
        } catch (LoginException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public void regist(User user) throws SQLException {
        userDao.addUser(user);
    }
}
