package com.syedu.hrm.mapper;

import com.syedu.hrm.bean.Document;
import com.syedu.hrm.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DocumentMapper {
    public void addDocument(Document document);//添加文件

    public List<User> selectAllDocument();//获得所有文件

    public void  delectDocumentById(int id);//根据id删除文件

   public Document selectDocumentById(int id);//根据id找文件

   public  List<Document> selectDocumentByTitle(String title);//根据title模糊查询

    public void updateDocument(Document document);//修改文件
}
