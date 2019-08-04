package com.syedu.hrm.service;

import com.syedu.hrm.bean.Job;

import java.util.List;

public interface JobService {
    public List<Job> selectAllJob();//获得所有职业表信息

    void saveJob(Job job);//添加职位

    void delectJobById(int id);//删除职位

    Job selectJobById(int id);//查找职位

    void UpdateJobById(Job job);//修改职位
}
