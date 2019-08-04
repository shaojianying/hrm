package com.syedu.hrm.service;

import com.syedu.hrm.bean.User;

import java.util.List;

public interface UserService {
    public User selectBynameAndPassword(String userId, String password);

   public  List <User>selectAllUser();//查找所有用户

    void addUserByNamePwd(User user);//添加用户

    void updateUserById(int id);//审批用户 更改状态

    User selectUserById(int id);//id 找用户

    List<User> selectUserByNameAndPassWord(String name, String passWord);

    void updateUser(User user);//修改用户

    void deleteUserById(int id);//删除用户
}
