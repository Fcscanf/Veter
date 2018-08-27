package cn.fcsanf.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
    *@Author:Fcscanf
    *@Description:用户实体类
    *@Date:下午 17:07 2018/4/2
    */
public class User implements Serializable {

    private static final long serialVersionUID = 1L;

    /**用户ID*/
    private String id;
    /*role*/
    private String role;
    /**用户名*/
    private String username;
    /**密码*/
    private String password;
    /**姓名*/
    private String sex;
    /**年龄*/
    private int age;
    /**E-mail*/
    private String email;
    /**地址*/
    private String address;
    /**逻辑删除*/
    private int udelete;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getUdelete() {
        return udelete;
    }

    public void setUdelete(int udelete) {
        this.udelete = udelete;
    }

    public Map<String, String> validateRegist() {
        Map<String, String> map = new HashMap<String, String>();

        if (username == null || username.trim().isEmpty()) {
            map.put("username.message", "用户名不能为空");
        }

        if (password == null || password.trim().isEmpty()) {
            map.put("password.message", "密码不能为空");
        }

        if (email == null || email.trim().isEmpty()) {
            map.put("email.message", "邮箱不能为空");
        }

        if (sex == null || sex.trim().isEmpty()) {
            map.put("sex.message", "性别不能为空");
        }

        if (address == null || address.trim().isEmpty()) {
            map.put("address.message", "地址不能为空");
        }

        return map;
    }


    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", role='" + role + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", udelete=" + udelete +
                '}';
    }
}
