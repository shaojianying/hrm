package com.syedu.hrm.mapper;

import com.syedu.hrm.base.BaseMapper;
import com.syedu.hrm.bean.Job;
import org.apache.ibatis.annotations.Mapper;

/**
 * JobMapper 数据访问类
 * @author qxy
 * @email 1766181826@qq.com
 * @date 2019-08-01 14:21:30
 * @version 1.0
 */
@Mapper
public interface JobMapper extends BaseMapper {


    Job selectJobById(int id);
}