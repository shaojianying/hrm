package com.syedu.hrm.controller;

import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.syedu.hrm.bean.User;
import com.syedu.hrm.service.UserService;
import io.netty.handler.codec.json.JsonObjectDecoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

//用户处理器
@Controller
public class Usercontroller {
    @Autowired
    UserService us;
    @RequestMapping("/togoin")
    public String togoin(){//取登录页
        return "longin";
    }
    @RequestMapping("/loginAjax")
    @ResponseBody//返回json
    public String longinAjax( String userId, String password, String code, HttpServletRequest request) {
        //创建json对象
        JSONObject objson = new JSONObject();
        //取得session中的验证码,因为生成验证码的时候就已经将验证码放入session中了
        String ver= (String )request.getSession().getAttribute("verify");
       // if(ver.equalsIgnoreCase(code)){
      User user=  us.selectBynameAndPassword(userId,password);
      if(user!=null){
      //创建session对象,将找到的user放入session中
        request.getSession().setAttribute("user",user);
           objson.put("flag","0");
           objson.put("tip","登陆成功");
        }else {
          objson.put("flag","2");
          objson.put("tip","用户名或密码有误");
      }
        //}
        //去拦截器,再去ajax回调方法
        return objson.toString();
    }
    @RequestMapping("/logout")//注销登陆
    public void logout(HttpServletRequest request, HttpServletResponse response)throws Exception{
        request.getSession().invalidate();//清除session中的数据
        response.sendRedirect("/togoin");//跳到登录页
    }
    @RequestMapping("/user/userList")//查询所有用户
    public String userList(Model model){
        List<User> list=us.selectAllUser();
        model.addAttribute("users",list);
        return "user/userList";
    }
    @RequestMapping("/user/toAddUser")//去添加用户页面
    public String toAddUser(){
        return "/user/addUser";
    }
    @RequestMapping("/user/addUser")//往数据库添加用户
    public void addUser(User user,HttpServletResponse response)throws Exception{
        user.setDate(new Date());
        us.addUserByNamePwd(user);
        response.sendRedirect("/user/userList");
    }
    @RequestMapping("/user/checkUser")//审批用户
    public void checkUser(int id ,HttpServletResponse response)throws Exception{
        us.updateUserById(id);
        response.sendRedirect("/user/userList");
    }
    @RequestMapping("/user/toUpdateUser")//去修改用户
    public String toUpdateUser(int id,Model model){
        //先找到需要修改的用户
       User user= us.selectUserById(id);
       model.addAttribute("user",user);
       return "/user/updateUser";
    }
    @RequestMapping("/user/updateUser")//修改用户
    public void updateUser(String passWord,String newPwd,String name,HttpServletResponse response)throws Exception{
        System.out.println("89898989898989");
       List<User>list = us.selectUserByNameAndPassWord(name,passWord);
       if(list.size()==0){
           System.out.println("空空空");
           response.sendRedirect("/user/userList");
       }else {
        System.out.println("不是空");
       User u=list.get(0);
       User user=new User();
       user.setId(u.getId());
       user .setName(name);
       user.setPassword(newPwd);
       us.updateUser(user);
       response.sendRedirect("/user/userList");
    }
    }
    @RequestMapping("/user/deleteUser")
    public void deleteUser(HttpServletResponse response,int id )throws Exception{
        us.deleteUserById(id);
        response.sendRedirect("/user/userList");
    }

}

