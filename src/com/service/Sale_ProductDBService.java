package com.service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.model.Product;
import com.model.Sale_products;

public class Sale_ProductDBService implements DatabaseService<Sale_products> {
	private Connection con;
	List<Sale_products> saleProductList = new ArrayList<Sale_products>();
	
	@Override
	public void addRecord(Sale_products record) {
		connectToDB();
		String sql = "Insert into sale_products(sale_id,product_id,saleproduct_name,saleproduct_company"
				+ ",saleproduct_price,saleproduct_quantity) values(?,?,?,?,?,?)";
		
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(1, record.getSaleId());
			stm.setInt(2, record.getSaleProduct().getId());
			stm.setString(3, record.getSaleProduct().getName());
			stm.setString(4, record.getSaleProduct().getCompany());
			stm.setInt(5, record.getSaleProduct().getPrice());
			stm.setInt(6, record.getSaleProduct().getQuantity());
			stm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		closeDB();
	}
	
	@Override
	public void deleteRecord(Sale_products type) {
		// TODO Auto-generated method stub
		
	}
	
	
	@Override
	public List<Sale_products> fetchRecord() {
		connectToDB();
		String sql = "Select * from sale_products";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			parseResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		closeDB();
		return saleProductList;
	}
	
	
	public List<Sale_products> fetchRecord(int SaleId){
		connectToDB();
		String sql = "Select * from sale_products where sale_id = ?";
		try {
			PreparedStatement stm = con.prepareStatement(sql);
			stm.setInt(0, SaleId);
			ResultSet rs = stm.executeQuery();
			parseResultSet(rs);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		closeDB();
		return saleProductList;
	}
	
	
	@Override
	public void updateRecord(Sale_products type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void connectToDB() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Inventory","root","1234");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch(SQLException e) {
			e.printStackTrace();
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
	
	private void parseResultSet(ResultSet rs) {
		
		try {
			while(rs.next()) {
				Sale_products saleProduct = new Sale_products();
				saleProduct.setSaleId(rs.getInt("sale_id"));
				saleProduct.setSaleProductId(rs.getInt("saleproduct_id"));
				Product tempProduct = new Product();
				tempProduct.setId(rs.getInt("product_id"));
				tempProduct.setName(rs.getString("saleproduct_name"));
				tempProduct.setCompany(rs.getString("saleproduct_company"));
				tempProduct.setPrice(rs.getInt("saleproduct_price"));
				tempProduct.setQuantity(rs.getInt("saleproduct_quantity"));
				saleProduct.setSaleProduct(tempProduct);
				saleProductList.add(saleProduct);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
