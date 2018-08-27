package cn.fcsanf.service;

import cn.fcsanf.model.User;
/**
    *@Author:Fcscanf
    *@Description:
    *@Date:下午 23:18 2018/4/28
    */
public interface UserService {
    // 注册操作
    public void regist(User user) throws Exception;

    // 登录操作
    public User login(String username, String password) throws Exception;
}
