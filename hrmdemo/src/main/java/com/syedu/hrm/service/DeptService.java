package com.syedu.hrm.service;

import com.syedu.hrm.bean.Dept;

import java.util.List;

public interface DeptService {
    public List <Dept> AllDept();

    void addDept(Dept dept);//添加部门

    List<Dept> selectAllDept();//查询所有部门

    void deleteDeptById(int id);//根据id删除部门

    Dept selectDeptById(int id);//查找部门

    void UpdateDeptById(Dept dept);//修改部门
}
