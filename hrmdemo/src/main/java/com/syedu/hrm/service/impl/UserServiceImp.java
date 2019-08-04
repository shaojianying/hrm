package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.User;
import com.syedu.hrm.mapper.UserMapper;
import com.syedu.hrm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    UserMapper um;
    @Override
    public User selectBynameAndPassword(String userId, String password) {
        return um.selectBynameAndPassword(userId, password);
    }

    @Override
    public List<User> selectAllUser() {
        return um.find(null);
    }

    @Override
    public void addUserByNamePwd(User user) {
        um.save(user);
    }

    @Override
    public void updateUserById(int id) {
        um.update(id);
    }

    @Override
    public User selectUserById(int id) {
        return um.selectUserById(id);
    }

    @Override
    public List<User> selectUserByNameAndPassWord(String name, String passWord) {
        return um.selectUserByNameAndPassWord(name,passWord);
    }

    @Override
    public void updateUser(User user) {
        um.updateUser(user);
    }

    @Override
    public void deleteUserById(int id) {
        um.deleteUserById(id);
    }


}
