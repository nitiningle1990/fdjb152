package com.cjc.main.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cjc.main.model.Document;
@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

	public Document findByDocid(int Docid);

	
	
}
