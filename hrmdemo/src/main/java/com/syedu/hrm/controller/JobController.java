package com.syedu.hrm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.syedu.hrm.bean.Job;
import com.syedu.hrm.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

//职位处理器
@Controller
public class JobController {
    @Autowired
    private JobService js ;
    @RequestMapping("/job/loadJobAjax")//去获得职位表的信息 json格式传给添加员工页面
    @ResponseBody
    public String loadJobAjax(){
        //从添加员工的jsp页面中可以看出 跳到jsp页面时 我们需要带着职位表所有的name和id的信息,页面通过json ajax异步加载方式
        List<Job> list=js.selectAllJob();
        JSONArray jsonArray=new JSONArray();
        for(Job job:list){
            JSONObject jsonObject=new JSONObject();
            jsonObject.put("id",job.getId());
            jsonObject.put("name",job.getName());
            jsonArray.add(jsonObject);
        }
        //请求成功后将数据传给ajax的回调函数
        return jsonArray.toString();
    }
    @RequestMapping("job/jobList")
    public String jobList(Model model){//查询所有职位
        List<Job>list=js.selectAllJob();
        model.addAttribute("jobs",list);
        return "/job/jobList";
    }
    @RequestMapping("job/toAddJob")
    public String toAddJob(){//去添加职位的页面
        return "/job/addJob";
    }
    @RequestMapping("/job/addJob")
    public void addJob(Job job, HttpServletResponse response)throws Exception{//往数据库添加职位并跳转到所有职位页面
        js.saveJob(job);
        response.sendRedirect("/job/jobList");
    }
    @RequestMapping("/job/deleteJob")//根据id删除职位,并跳到显示所页面
    public void deleteJob(int id,HttpServletResponse response)throws Exception{
        js.delectJobById(id);
        response.sendRedirect("/job/jobList");
    }
    @RequestMapping("/job/toUpdateJob")//去修改职位页面
    public String toUpdateJob(int id,Model model){
        //先获的需要修改的job
        Job job=js.selectJobById(id);
        model.addAttribute("job",job);
        return "/job/updateJob";
    }
    @RequestMapping("/job/updateJob")
    public void updateJob(Job job, HttpServletResponse response)throws Exception{
        js.UpdateJobById(job);
        response.sendRedirect("/job/jobList");
    }
}
