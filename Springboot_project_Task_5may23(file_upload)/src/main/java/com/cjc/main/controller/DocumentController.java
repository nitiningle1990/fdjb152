package com.cjc.main.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.cjc.main.model.Document;
import com.cjc.main.servicei.DocumentServiceI;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
public class DocumentController {

	@Autowired
	DocumentServiceI dsi;
	//file & json data store in DB
	//post API
	@PostMapping(value = "/document")
	public ResponseEntity<Document > saveDocument(@RequestParam("photo") MultipartFile file1,
			@RequestParam("pancard") MultipartFile file2,
			@RequestParam("custId") String data) throws IOException
	{
		
		System.out.println(file1.getBytes());
		System.out.println(file2.getBytes());
		System.out.println(data);//on consol output is json format
		
		//how to convert json data into java object vice varsa
		ObjectMapper om=new ObjectMapper();
		     Document dd=om.readValue(data,Document.class);//convert json to object
		    /* System.out.println(dd);
		     String json=om.writeValueAsString(dd);//java to json
		     System.out.println(json);*/
		     dd.setPhoto(file1.getBytes());
		     dd.setPancard(file2.getBytes());
		     
		return new ResponseEntity<Document>(dsi.saveDocument(dd), HttpStatus.CREATED);
			
	}
	@GetMapping(value = "/getdAllDocumnet")
	public ResponseEntity<List> getAllData()
	{
	return new ResponseEntity<List>(dsi.getAlldata(),HttpStatus.OK);
	}
	
	
	@DeleteMapping("/Delete/{docid}")
	public ResponseEntity<String> delete(@PathVariable int docid )
	{
	  dsi.deleteDocument(docid);
	    
	    return new ResponseEntity<String>("Data Is DELETED", HttpStatus.NO_CONTENT);
	}
	
	@PutMapping("/updateDocument/{docid}")
	public ResponseEntity<Document> updateDocument(@PathVariable int docid, @RequestBody Document d)
	{
		 Document dee =dsi.saveDocument(d);
		
		return new ResponseEntity<Document>(dee, HttpStatus.OK);
	}
}
