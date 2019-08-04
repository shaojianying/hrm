package com.syedu.hrm.service;

import com.syedu.hrm.bean.Document;
import com.syedu.hrm.bean.User;

import java.util.List;

public interface DocumentService {
    public void addDocument(Document document);//添加文件到数据库

    public List<User> selectAllDocument();//获得所有文件

    public void  delectDocumentById(int id);//根据id删除文件

    public Document selectDocumentById(int id);//根据id查找文件

    public List<Document> selectDocumentByTitle(String title);//根据title模糊查询

    public void updateDocument(Document document);//修改文件
}
