package com.item.service.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.sql.DataSource;
import com.item.model.Item;
import com.item.service.ItemService;

public class ItemServiceImpl implements ItemService {
    
	private DataSource dataSource;
	


	public ItemServiceImpl(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	@Override
	public boolean addDetail(Item item){
		
		try {
			Connection connection = dataSource.getConnection();
			String query = "INSERT INTO details (book_id , detail) VALUES ("+item.getId()+",'"+item.getDetail()+"')";
			Statement statement = connection.createStatement();
			int res = statement.executeUpdate(query);
			
			return res == 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		
		return false;
	
		}
	
	
	@Override
	public String showDetail(Item item) {
		try {
			Connection connection = dataSource.getConnection();
			String query = "SELECT DETAIL FROM DETAILS WHERE BOOK_ID = " + item.getId();
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
						
			if (resultSet.next()) {
				return resultSet.getString("detail");
			}

		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}
	@Override
	public boolean saveItem(Item item) {
		try {
			Connection connection = dataSource.getConnection();
			
			String query = "INSERT INTO item (NAME,PRICE,TOTAL_NUMBER)"
						+ " VALUES ('" + item.getName() + "', " 
					    + item.getPrice() +", " + item.getTotalNumber() + ")";
			Statement statement = connection.createStatement();
			int res = statement.executeUpdate(query);
			

			return res == 1;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean removeItem(int id) {
		try {
			Connection connection =  dataSource.getConnection();
			String query2 = "DELETE FROM item where id = " + id;
			String query1 = "DELETE FROM details where book_id = " + id;
			Statement statement = connection.createStatement();
			int res = 0;
			int res0 =0;
			if (Objects.nonNull(loadItem(id))) {// nonNull   null		
				res0 = statement.executeUpdate(query1);
				System.out.print(res0);
				res = statement.executeUpdate(query2);
				System.out.print(res);

			}
			
			return res == 1 ;
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean updateItem(Item item) {
		try {
	        Connection connection = dataSource.getConnection();

	        String query1 = "UPDATE item SET NAME = '" + item.getName() + "', " +
	                       "PRICE = " + item.getPrice() + ", " +
	                       "TOTAL_NUMBER = " + item.getTotalNumber() +
	                       " WHERE ID = " + item.getId(); 
	        Statement statement = connection.createStatement();
	        int res = statement.executeUpdate(query1);
	        int res2;
	        if(!(item.getDetail() == null)) {
		        String query2 = "UPDATE details SET detail = '" + item.getDetail() +"' WHERE book_id = " + item.getId();
	        	res2 = statement.executeUpdate(query2);}else {res2 = 1;}
	        
	        
	        return res == 1 && res2 == 1;

	    } catch (SQLException e) {
	        System.out.println("SQL Error: " + e.getMessage());
	    }

	    return false;
	}

	@Override
	public Item loadItem(int id) {
		try {
			Connection connection =  dataSource.getConnection();
			String query = "SELECT ID , NAME , PRICE , TOTAL_NUMBER , DETAIL FROM item i LEFT OUTER JOIN details d ON(i.id = d.book_id) WHERE i.id =" + id;
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			
			if (resultSet.next()) {
				return new Item(
						resultSet.getInt("id"),
						resultSet.getString("Name"),
						resultSet.getDouble("price"),
						resultSet.getInt("total_number"),
						resultSet.getString("detail")
				);
			}
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

	@Override
	public List<Item> loadItems() {
		try {
			Connection connection =  dataSource.getConnection();
			String query = "SELECT i.ID , i.NAME , i.PRICE , i.TOTAL_NUMBER , d.DETAIL FROM item i LEFT OUTER  JOIN details d ON(i.id = d.book_id)";
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			List<Item> items = new ArrayList<Item>();
			
			while (resultSet.next()) {
				Item item = new Item(
						resultSet.getInt("id"),
						resultSet.getString("Name"),
						resultSet.getDouble("price"),
						resultSet.getInt("total_number"),
						resultSet.getString("detail")

				);
				items.add(item);
			}
			
			return items;
			
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
