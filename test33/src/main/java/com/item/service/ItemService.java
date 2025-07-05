package com.item.service;
import java.util.List;
import com.item.model.Item;
public interface ItemService {
	boolean saveItem(Item item);
	boolean removeItem(int id);
	boolean updateItem(Item item);
	boolean addDetail(Item item);
	Item loadItem(int id);
	String showDetail(Item item);
	List<Item> loadItems();
	
	
	
	

}
