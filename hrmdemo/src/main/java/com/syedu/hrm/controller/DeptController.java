package com.syedu.hrm.controller;

import com.syedu.hrm.bean.Dept;
import com.syedu.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

//部门处理器
@Controller
public class DeptController {
    @Autowired
    private  DeptService ds ;
    @RequestMapping("/emp/toAddEmp")//去添加员工页面
    public String toAllDept (Model model){//获得所有部门信息 并带着数据进入添加员工的页面
        System.out.println("进来了****");
        List<Dept> list= ds.AllDept();
        System.out.println("*****"+list.size());
        model.addAttribute("depts",list);
        return "/emp/addEmp";
    }
    @RequestMapping("/dept/toAddDept")//去添加部门的页面
    public String toAddDept(){
        return "/dept/addDept";
    }
    @RequestMapping("/dept/addDept")//添加部门到数据库
    public void addDept(Dept dept, HttpServletResponse response)throws Exception{
        ds.addDept(dept);
        response.sendRedirect("/dept/deptList");
    }
    @RequestMapping("/dept/deptList")//查询所有部门
    public String deptList(Model model){
        List<Dept> list=ds.selectAllDept();
        model.addAttribute("depts",list);
        return "/dept/deptList";
    }
    @RequestMapping("/dept/deleteDept")//根据id删除部门
    public void deleteDept(int id,HttpServletResponse response)throws Exception{
        ds.deleteDeptById(id);
        response.sendRedirect("/dept/deptList");
    }
    @RequestMapping("/dept/toUpdateDept")//去部门修改页面
    public String toUpdateDept(int id ,Model model){
        Dept dept=ds.selectDeptById(id);
        model.addAttribute("dept",dept);
        return "/dept/updateDept";
    }
    @RequestMapping("/dept/updateDept")//修改部门 保存到数据库 并跳转所有部门页面
    public void updateDept(Dept dept,HttpServletResponse response)throws Exception{
        ds.UpdateDeptById(dept);
        response.sendRedirect("/dept/deptList");
    }
}
