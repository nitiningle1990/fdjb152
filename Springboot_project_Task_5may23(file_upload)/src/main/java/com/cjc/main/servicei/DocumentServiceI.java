package com.cjc.main.servicei;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.cjc.main.model.Document;

public interface DocumentServiceI {

	Document saveDocument(Document c);

	List getAlldata();

	void deleteDocument(int docid);

	Document edit(int docid);
	
	

	

	

}
