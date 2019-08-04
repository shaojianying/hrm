package com.syedu.hrm.controller;

import com.syedu.hrm.bean.Dept;
import com.syedu.hrm.bean.Employee;
import com.syedu.hrm.service.DeptService;
import com.syedu.hrm.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

//员工管理处理器
@Controller
public class EmpController {
    @Autowired
    private EmpService es;
    @Autowired
    private DeptService deptService;
    @RequestMapping("/employee/addEmp")//往数据库存新增员工 在跳转到显示员工页
    public void addEmp(Employee employee, HttpServletResponse response)throws Exception{
        es.addEmp(employee);
        response.sendRedirect("/emp/empList");
    }
    @RequestMapping("/emp/empList")//查询所有员工
    public String emplist(Model model){
       List <Employee> list=es.selectAllEmp();
       List<Dept>list1=deptService.AllDept();
       model.addAttribute("depts",list1);
       Employee e=list.get(1);
       model.addAttribute("employees",list);
       return "/emp/empList";
    }
    @RequestMapping("/emp/deleteEmp")//删除员工 通过id,在跳转到所有员工页面
    public void deleteEmp(int id,HttpServletResponse response)throws Exception{
        es.delectEmpById(id);
        response.sendRedirect("/emp/empList");
    }
    @RequestMapping("/emp/toUpdateEmp")//去修改指定员工信息页面
    public String toUpdateEmp(int id,Model model){
        Employee e =es.selectEmpById(id);
        model.addAttribute("emp",e);
        List<Dept> list=deptService.AllDept();
        model.addAttribute("depts",list);
        return "/emp/updateEmp";
    }
    @RequestMapping("/emp/updateEmp")//修改员工信息并保存数据库后,跳转到所有员工页面
    public void updateEmp(Employee employee,HttpServletResponse response)throws Exception{
        es.UpdateEmp(employee);
        response.sendRedirect("/emp/empList");
    }
    @RequestMapping("/employee/selectEmployee")//模糊查询
    public String selectEmployee(Employee employee,Model model){
        List <Employee> list=es.selectEmpByLike(employee);
            model.addAttribute("employees",list);
            return "/emp/empList";
    }
    @RequestMapping("/employee/downExcel.html")//导出Excel
    public void downExcel(HttpServletResponse response, HttpServletRequest request)throws Exception{
        es.downExcel(request,response);
    }
}
