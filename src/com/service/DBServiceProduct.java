package com.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.model.Product;

public class DBServiceProduct implements DatabaseService<Product> {
	private DatabaseConnection dbCon = new DatabaseConnection();
	private List<Product> plist = new ArrayList<>();
	
	@Override
	public void addRecord(Product record) {
		
		String sql = "INSERT INTO products(product_name, product_price, product_quantity, product_company)"
				+ "VALUES(?,?,?,?)";
		PreparedStatement stm;
		try {
			
			stm = dbCon.getConnection().prepareStatement(sql);
			stm.setString(1, record.getName());
			stm.setInt(2, record.getPrice());
			stm.setInt(3, record.getQuantity());
			stm.setString(4, record.getCompany());
			stm.executeUpdate();
			dbCon.closeConnection();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}
	
	@Override
	public void deleteRecord(Product record) {
		String sql = "UPDATE products SET is_deleted = 1 WHERE product_id = ? ";
		PreparedStatement stm;
		try {
			dbCon.createConnection();
			stm = dbCon.getConnection().prepareStatement(sql);
			stm.setInt(1, record.getId());
			stm.executeUpdate();
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public void updateRecord(Product record) {
		String sql = "UPDATE products SET product_name = ? , product_price = ?, product_quantity = ?, "
				+ "product_company = ? WHERE product_id = ?";
		PreparedStatement stm;
		try {
			dbCon.createConnection();
			stm = dbCon.getConnection().prepareStatement(sql);
			stm.setString(1, record.getName());
			stm.setInt(2, record.getPrice());
			stm.setInt(3, record.getQuantity());
			stm.setString(4, record.getCompany());
			stm.setInt(5, record.getId());
			stm.executeUpdate();
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Override
	public List<Product> fetchRecord() {
		String sql = "Select * from products WHERE is_deleted = 0";
		PreparedStatement stm;
		try {
			dbCon.createConnection();
			stm = dbCon.getConnection().prepareStatement(sql);
			ResultSet fetchSet = stm.executeQuery();
			while(fetchSet.next()) {
				Product tempProduct = new Product();
				tempProduct.setId(fetchSet.getInt("product_id"));
				tempProduct.setName(fetchSet.getString("product_name"));
				tempProduct.setCompany(fetchSet.getString("product_company"));
				tempProduct.setPrice(fetchSet.getInt("product_price"));
				tempProduct.setQuantity(fetchSet.getInt("product_quantity"));
				plist.add(tempProduct);
			}
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	

}
