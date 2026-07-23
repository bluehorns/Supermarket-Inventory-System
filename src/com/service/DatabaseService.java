package com.service;


import java.util.List;


public interface DatabaseService<T> {
	void addRecord(T type);
	void deleteRecord(T type);
	void updateRecord(T type);
	List<T> fetchRecord();
	void connectToDB();
	void closeDB();
}
