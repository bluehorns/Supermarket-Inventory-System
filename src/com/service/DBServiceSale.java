package com.service;
	
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;


import com.model.Sale;

public class DBServiceSale implements DatabaseService<Sale> {
	
	private DatabaseConnection dbCon = new DatabaseConnection();
	private int generatedId;
	private List<Sale> saleList = new ArrayList<>();
	
	@Override
	public void addRecord(Sale record) {
		try {
			dbCon.createConnection();
			String sql = "INSERT into sales(sale_date,sale_time,employee_id)"
					+ "VALUES(?,?,?)";
			PreparedStatement stm = dbCon.getConnection().prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
			stm.setDate(1, Date.valueOf(record.getSaleDate()));
			stm.setTime(2, Time.valueOf(record.getSaleTime()));
			stm.setInt(3, 5);
			stm.executeUpdate();
			ResultSet rs = stm.getGeneratedKeys();
			rs.next();
			generatedId = rs.getInt(1);
			dbCon.closeConnection();
		}catch(SQLException s) {
			s.printStackTrace();
		}
	}
	
	@Override
	public void deleteRecord(Sale type) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public List<Sale> fetchRecord() {
		String sql = "Select * from sales";
		PreparedStatement stm;
		try {
			dbCon.createConnection();
			stm = dbCon.getConnection().prepareStatement(sql);
			ResultSet rs = stm.executeQuery();
			parseResultSet(rs);
			dbCon.closeConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return saleList;
	}
	
	
	
	@Override
	public void updateRecord(Sale type) {
		// TODO Auto-generated method stub
		
	}
	
	
	public int getGeneratedID() {
		return generatedId;
	}
	
	private void parseResultSet(ResultSet rs) {
		try {
			while(rs.next()) {
				Sale tempSale = new Sale();
				tempSale.setSalesId(rs.getInt("sale_id"));
				tempSale.setEmployeeId(rs.getInt("employee_id"));
				tempSale.setSaleTime(rs.getTime("sale_time").toLocalTime());
				tempSale.setSaleDate(rs.getDate("sale_date").toLocalDate());
				saleList.add(tempSale);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
