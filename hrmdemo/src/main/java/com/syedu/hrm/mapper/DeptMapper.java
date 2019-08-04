package com.syedu.hrm.mapper;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.Dept;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * DeptMapper 数据访问类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-08-01 14:50:25
 * @version 1.0
 */
@Mapper
public interface DeptMapper extends BaseMapper {


    public List<Dept> AllDept();
    //通过id获得部门
    public Dept get(int id);

    Dept selectDeptById(int id);
}