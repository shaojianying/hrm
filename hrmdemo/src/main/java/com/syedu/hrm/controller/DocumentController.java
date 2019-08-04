package com.syedu.hrm.controller;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.syedu.hrm.bean.Document;
import com.syedu.hrm.bean.User;
import com.syedu.hrm.service.DocumentService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.crypto.Data;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.List;
import java.util.UUID;

//上传下载文件处理器
@Controller
public class DocumentController {//去上传文件页面
    @Autowired
    private DocumentService documentService;
    @RequestMapping("/document/toAddDocument")
    public String toAddDocument(){
        return "/document/addDocument";//跳到该页面
    }
    //获得表单去上传文件
    /*添加文档的方法*/
    @RequestMapping("/document/addDocument")
    public void  addDocument(MultipartFile file, HttpServletRequest request, HttpServletResponse response, Document document) throws  Exception{

        //文件上传就是把本地选择的文件拷贝到指定的文件下面 sql.txt->  拷贝电脑上选择的资源到/images/document/
        //不能让文件重名 UUID
        String realPath = request.getServletContext().getRealPath("/images/document/");
        // 生成一个新的文件名
        String newFileName= UUID.randomUUID().toString()+file.getOriginalFilename();
        //把需要上传的文件拷贝的哪里
        //D:\20190711\20190728项目\hrmcode\hrm20190711\src\main\webapp\images\document\064ebda6-aee1-4ab3-b715-10a55b70849chrm_db.sql
        file.transferTo(new File(realPath+newFileName));

        document.setUrl(realPath+newFileName);
        document.setCreateDate(new Date());
        //获取user
        User user=  (User)request.getSession().getAttribute("user");
        document.setUser(user);
        //把记录保存到hrm_document表中
        documentService.addDocument(document);
        response.sendRedirect("/document/documentList");
    }
    @RequestMapping("/document/documentList")//查询获得所有文件
    public String documentList(Model model){
      List<User> list= documentService.selectAllDocument();
      model.addAttribute("documents",list);
        return "/document/documentList";
    }
    @RequestMapping("/document/deleteDocument")//根据id删除文件
    public void deleteDocument(HttpServletResponse response,int id)throws Exception{
        System.out.println("**********"+id);
        documentService.delectDocumentById(id);
        response.sendRedirect("/document/documentList");
    }
    @RequestMapping("/document/downDocument")//根据id下载文件
    public void downDocument(int id, HttpServletResponse response,HttpServletRequest request)throws Exception{
        System.out.println("xxxxxxx"+id);
        //下载这个文件 要先找到这个文件,通过id找
        Document document=documentService.selectDocumentById(id);
        //获得这个文件的标题和路劲
       String title= document.getTitle();
       String url =document.getUrl();
       System.out.println("title**"+title);
       System.out.println("url**"+url);
        //告诉浏览器本次请求响应给浏览器的是文档附件资源不是普通的页面或者其他
        response.setHeader("content-type", "application/octet-stream");
        response.setContentType("application/octet-stream");
        response.setHeader("Content-Disposition", "attachment;filename=" +title);
        //定义缓冲数组
        byte [] bt=new byte[1024];
        //定义输入流 从服务器读取资源
        BufferedInputStream bis=null;
        //定义输出流
        OutputStream os =null;
        os=response.getOutputStream();
        bis =new BufferedInputStream(new FileInputStream(new File(url)));
        int b;
        while ((b=bis.read(bt))!=-1){
            os.write(bt);
        }
        os.close();
        bis.close();
    }
    //搜索栏模糊查询
    @RequestMapping("/document/selectDocument")
    public String selectDocument(String title ,Model Model){
        System.out.println("传来的"+title);
        List<Document>list= documentService.selectDocumentByTitle(title);
        System.out.println("大小"+list.size());
        Model.addAttribute("documents",list);
        return "document/documentList";
    }
    //带着需要修改的文件去修改页面
    @RequestMapping("/document/toUpdateDocument")
    public String toUpdateDocument(int id ,Model model){
        Document document=documentService.selectDocumentById(id);
        model.addAttribute("document",document);
        return "/document/updateDocument";
    }
    //从修改文件的页面提交表单到数据库,并从新打开所有文件的页面
    @RequestMapping("/document/updateDocument")
    public void  updateDocument(HttpServletResponse response,HttpServletRequest request, Document document)throws Exception{
        //修改时需要修改表单的UserId,从session中取出session,放入要修改的文件中
        User user =(User) request.getSession().getAttribute("user");
        document.setUser(user);
        Date date=new Date();
        document.setCreateDate(date);
        documentService.updateDocument(document);
        response.sendRedirect("/document/documentList");
    }
}
