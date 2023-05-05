package com.cjc.main.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cjc.main.model.Document;
import com.cjc.main.repository.DocumentRepository;
import com.cjc.main.servicei.DocumentServiceI;
@Service
public class DocumentServiceImpl implements DocumentServiceI{

	@Autowired
	DocumentRepository dr;

	
	
	@Override
	public List getAlldata() {
		
		return dr.findAll();
	}
	@Override
	public void deleteDocument(int docid) {
	  dr.deleteById(docid);
	
	}
	@Override
	public Document saveDocument(Document c) {
		 
	Document doo=dr.save(c);
	
	return doo;
	}
	@Override
	public Document edit(int docid) {
	       Document drr=dr.findByDocid(docid);
		return drr;
	}
	
	
	}


