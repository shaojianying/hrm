package com.syedu.hrm.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syedu.hrm.bean.Job;
import com.syedu.hrm.mapper.JobMapper;
import com.syedu.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class JobServiceImpl implements JobService {
    @Autowired
    private JobMapper jm;
    @Override
    public List<Job> selectAllJob() {
      return jm.find(null);
    }

    @Override
    public void saveJob(Job job) {
        jm.save(job);
    }

    @Override
    public void delectJobById(int id) {
        jm.delete(id);
    }

    @Override
    public Job selectJobById(int id) {
        return jm.selectJobById(id);
    }

    @Override
    public void UpdateJobById(Job job) {
        jm.update(job);
    }
}




