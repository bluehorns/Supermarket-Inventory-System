package com.service;

import java.util.List;

import com.model.DatabaseObject;

public interface DatabaseService {
	void addRecord(DatabaseObject record);
	void deleteRecord(DatabaseObject record);
	void updateRecord(DatabaseObject record);
	List<?> fetchRecord();
}
