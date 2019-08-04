package com.syedu.hrm.mapper;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.Notice;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * NoticeMapper 数据访问类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-07-31 16:30:43
 * @version 1.0
 */
@Mapper
public interface NoticeMapper extends BaseMapper {

    public List<Notice> selectNoticeByTitle(String title);
}