package com.syedu.hrm.mapper;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.EmpExcel;
import com.syedu.hrm.bean.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * EmployeeMapper 数据访问类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-08-01 13:59:26
 * @version 1.0
 */
@Mapper
public interface EmployeeMapper extends BaseMapper {


  public Employee selectEmpById(int id);

    List<Employee> selectEmpByLike(Employee employee);


  List<EmpExcel> findExcel();
}