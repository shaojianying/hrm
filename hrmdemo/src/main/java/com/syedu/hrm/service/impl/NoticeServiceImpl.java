package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.Notice;
import com.syedu.hrm.mapper.NoticeMapper;
import com.syedu.hrm.service.NoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
 class NoticeServiceImpl implements NoticeService {
    @Autowired
    private NoticeMapper nm;
    @Override
    public List<Notice> selectAllNotice() {
        return nm.findAll(null);
    }

    @Override
    public void savenNotice(Notice notice) {
        nm.save(notice);
    }

    @Override
    public List<Notice> selectNoticeByTitle(String title) {
        return nm.selectNoticeByTitle(title);
    }

    @Override
    public Notice selectNoticeById(int id) {
        return nm.get(id);
    }

    @Override
    public void updateNotice(Notice notice) {
        nm.update(notice);
    }

    @Override
    public void delectNoticeById(int id) {
        nm.delete(id);
    }
}
