package com.syedu.hrm.service;

import com.syedu.hrm.bean.Employee;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface EmpService {
    public void addEmp(Employee employee);//添加员工

    public List<Employee> selectAllEmp();//查询所有员工

    void delectEmpById(int id);//通过id删除员工

    Employee selectEmpById(int id);//通过id找员工

    void UpdateEmp(Employee employee);//修改员工信息

    List<Employee> selectEmpByLike(Employee employee);//模糊查询


    void downExcel(HttpServletRequest request, HttpServletResponse response) throws Exception;//导出Excel
}
