package com.syedu.hrm.mapper;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * UserMapper 数据访问类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-29 17:13:37
 * @version 1.0
 */
@Mapper
public interface UserMapper extends BaseMapper {
   public User selectBynameAndPassword(String userId, String password);
   public User get(int id);

    User selectUserById(int id);


    List<User> selectUserByNameAndPassWord(String name, String passWord);

    void updateUser(User user);

    void deleteUserById(int id);
}