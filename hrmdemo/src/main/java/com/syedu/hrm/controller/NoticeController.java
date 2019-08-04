package com.syedu.hrm.controller;

import com.syedu.hrm.bean.Notice;
import com.syedu.hrm.bean.User;
import com.syedu.hrm.service.NoticeService;
import jdk.nashorn.internal.ir.RuntimeNode;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

//公告处理器
@Controller
public class NoticeController {
    @Autowired
    private NoticeService noticeService;
    //查询所有公告
    @RequestMapping("/notice/noticeList")
    public String noticeList(Model model){
        List<Notice> list =noticeService.selectAllNotice();
        model.addAttribute("notices",list);
        return "/notice/noticeList";
    }
    //去添加公告页面
    @RequestMapping("/notice/toAddNotice")
    public String toAddNotice(){
        return "/notice/addNotice";
    }
    //提交添加的公告到数据库并展示所有公告
    @RequestMapping("/notice/addNotice")
    public void addNotice(Notice notice, HttpServletRequest request, HttpServletResponse response)throws Exception{
        User user= (User) request.getSession().getAttribute("user");
        notice.setUser(user);
        notice.setUserId(user.getId());
        notice.setCreateDate(new Date());
        noticeService.savenNotice(notice);
        response.sendRedirect("/notice/noticeList");
    }
    @RequestMapping("/notice/selectNotice")
    public String selectNotice(String title,Model model){//模糊查询
       List<Notice>list= noticeService.selectNoticeByTitle(title);
       model.addAttribute("notices",list);
        return "/notice/noticeList";
    }
    @RequestMapping("/notice/toUpdateNotice")//去修改指定公告的页面
    public String toUpdateNotice(int id ,Model Model){
        //先获得需要修改的Notice
       Notice notice= noticeService.selectNoticeById(id);
       Model.addAttribute("notice",notice);
       return "/notice/updateNotice";
    }
    @RequestMapping("/notice/updateNotice")//修改公告
    public void updateNotice(HttpServletRequest request,Notice notice,HttpServletResponse response)throws Exception{
        User user=(User) request.getSession().getAttribute("user");
        notice.setUserId(user.getId());
        notice.setCreateDate(new Date());
        noticeService.updateNotice(notice);
        response.sendRedirect("/notice/noticeList");
    }
    @RequestMapping("/notice/deleteNotice")//删除公告
    public void deleteNotice(int id ,HttpServletResponse response)throws Exception{
        noticeService.delectNoticeById(id);
        response.sendRedirect("/notice/noticeList");
    }
    @RequestMapping("/notice/prevNotice")
    public String prevNotice(int id ,Model model){//通过id找到公告
        Notice notice=noticeService.selectNoticeById(id);
        model.addAttribute("notice",notice);
        return "/notice/prevNotice";
    }
}
