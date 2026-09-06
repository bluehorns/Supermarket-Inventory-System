package com.service;

import java.util.List;

import com.model.DatabaseObject;

public interface DatabaseService<T> {
	void addRecord(T record);
	void deleteRecord(T record);
	void updateRecord(T record);
	List<T> fetchRecord();
}
