package com.syedu.hrm.service.impl;

import com.syedu.hrm.bean.Document;
import com.syedu.hrm.bean.User;
import com.syedu.hrm.mapper.DocumentMapper;
import com.syedu.hrm.service.DocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DocumentServiceImpl implements DocumentService {
    @Autowired
    private DocumentMapper mp;
    @Override
    public void addDocument(Document document) {
        mp.addDocument(document);
    }

    @Override
    public List<User> selectAllDocument() {
        return mp.selectAllDocument();
    }

    @Override
    public void delectDocumentById(int id) {
        mp.delectDocumentById(id);
    }

    @Override
    public Document selectDocumentById(int id) {
        return mp.selectDocumentById(id);
    }

    @Override
    public List<Document> selectDocumentByTitle(String title) {
        return mp.selectDocumentByTitle(title);
    }

    @Override
    public void updateDocument(Document document) {
        mp.updateDocument(document);
    }
}
