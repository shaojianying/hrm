package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.Dept;
import com.syedu.hrm.mapper.DeptMapper;
import com.syedu.hrm.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DeptServiceImpl implements DeptService {
    @Autowired
    private DeptMapper dm ;
    @Override
    public List<Dept> AllDept() {
        return dm.AllDept();
    }

    @Override
    public void addDept(Dept dept) {
        dm.save(dept);
    }

    @Override
    public List<Dept> selectAllDept() {
        return dm.findAll(null);
    }

    @Override
    public void deleteDeptById(int id) {
        dm.delete(id);
    }

    @Override
    public Dept selectDeptById(int id) {
        return dm.selectDeptById(id);
    }

    @Override
    public void UpdateDeptById(Dept dept) {
        dm.update(dept);
    }
}
