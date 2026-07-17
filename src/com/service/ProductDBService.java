package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.swing.SwingWorker;

import com.model.Product;

public class ProductDBService implements DatabaseService<Product> {
	private Connection con;
	private static List<Product> plist = new ArrayList<>();
	
	@Override
	public void addRecord(Product record) {
		SwingWorker<Void,Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() throws Exception {
				connectToDB();
				String sql = "INSERT INTO products(product_name, product_price, product_quantity, product_company)"
						+ "VALUES(?,?,?,?)";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setString(1, record.getName());
				stm.setInt(2, record.getPrice());
				stm.setInt(3, record.getQuantity());
				stm.setString(4, record.getCompany());
				stm.executeUpdate();
				closeDB();
				return null;
			}
			@Override
			protected void done() {
				System.out.println("Added successfully");
				super.done();
			}
		};
		worker.execute();
	}
	
	@Override
	public void deleteRecord(Product record) {
		SwingWorker<Void,Void> worker = new SwingWorker<>() {
			@Override
			protected Void doInBackground() throws Exception {
				connectToDB();
				String sql = "UPDATE products SET is_deleted = 1 WHERE product_id = ? ";
				PreparedStatement stm = con.prepareStatement(sql);
				stm.setInt(1, record.getId());
				stm.executeUpdate();
				closeDB();
				return null;
			}
			
			@Override
			protected void done() {
				System.out.println("Deleted " + record.getName() +"");
				super.done();
			}
		};
		worker.execute();
		
	}
	
	@Override
	public void updateRecord(Product type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Product> fetchRecord() {
		
		connectToDB();
		String sql = "Select * from products WHERE is_deleted = 0";
		PreparedStatement stm;
		try {
			stm = con.prepareStatement(sql);
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
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return plist;
	}
	
	@Override
	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","1234");
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	
	@Override
	public void closeDB() {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}
