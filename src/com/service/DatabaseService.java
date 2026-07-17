package com.service;

import java.util.ArrayList;
import java.util.List;

import com.model.Product;

public interface DatabaseService<T> {
	void addRecord(T type);
	void deleteRecord(T type);
	void updateRecord(T type);
	List fetchRecord();
	void connectToDB();
	void closeDB();
}
