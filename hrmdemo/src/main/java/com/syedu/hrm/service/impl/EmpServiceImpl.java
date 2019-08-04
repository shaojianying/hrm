package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.EmpExcel;
import com.syedu.hrm.bean.Employee;
import com.syedu.hrm.mapper.EmployeeMapper;
import com.syedu.hrm.service.EmpService;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Field;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {
    @Autowired
    private EmployeeMapper em;
    @Override
    public void addEmp(Employee employee) {
        em.save(employee);
    }

    @Override
    public List<Employee> selectAllEmp() {
        return em.findAll(null);
    }

    @Override
    public void delectEmpById(int id) {
        em.delete(id);
    }

    @Override
    public Employee selectEmpById(int id) {
        return em.selectEmpById(id);
    }

    @Override
    public void UpdateEmp(Employee employee) {
        em.update(employee);
    }

    @Override
    public List<Employee> selectEmpByLike(Employee employee) {
        return em.selectEmpByLike(employee);
    }

    @Override
    public void downExcel(HttpServletRequest request, HttpServletResponse response) throws Exception{//导出Excel
        //先查询出需要导出Excel的数据
        List<EmpExcel> list=em.findExcel();
        //创建工作表
        HSSFWorkbook hw = new HSSFWorkbook();
        //创建具体工作单
        HSSFSheet sheet = hw.createSheet("工作单NO1");
        //创建工作单的第一行
        HSSFRow row = sheet.createRow(0);
        //第一行作为表单字段内容已定
        String [] no1={"编号","部门","职位","姓名","性别","电话"};
        //将第一行写入表单
        for(int i=0;i<no1.length;i++){
            //创建单元格并赋值
            row.createCell(i).setCellValue(no1[i]);
        }
        //将查询到的数据放入表单中
        for(int i =0;i<list.size();i++){
            HSSFRow row1 = sheet.createRow(i + 1);
            //获得集合中的对象
            EmpExcel e =list.get(i);
            //获得这个对象的所有属性值
            Field[] def = e.getClass().getDeclaredFields();
            //遍历这个对象的属性  放入单元格
            for(int j=0;j<def.length;j++){
                //获得对象的具体属性
                Field field=def[j];
                //创建一个单元格
                HSSFCell cell = row1.createCell(j);
                if (!field.isAccessible()) {
                    field.setAccessible(true);
                }
                Object objvlue= field.get(e);
                cell.setCellValue(objvlue.toString());
            }
        }
        response.setHeader("Content-Disposition", "attachment;filename=employeeInfo.xls");
        hw.write(response.getOutputStream());

    }
}
