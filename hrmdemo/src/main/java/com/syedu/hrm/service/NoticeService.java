package com.syedu.hrm.service;

import com.syedu.hrm.bean.Notice;

import java.util.List;

public interface NoticeService {
    public List<Notice> selectAllNotice();//查看所有公告

    public void savenNotice(Notice notice);//添加公告

    public List <Notice>selectNoticeByTitle(String title);//公告模糊查询

    public Notice selectNoticeById(int id);//根据id找公告

    void updateNotice(Notice notice);//修改公告

    void delectNoticeById(int id);//根据id删除公告
}
