package com.item.controller;

import java.io.IOException;
import java.util.List;
import java.util.Objects;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.item.model.Item;
import com.item.service.ItemService;
import com.item.service.impl.ItemServiceImpl;

@WebServlet("/ItemController")
public class ItemController extends HttpServlet {
	
	@Resource(name = "jdbc/item")
	private DataSource dataSource ;
	
	private static final long serialVersionUID = 1L;
       

    public ItemController() {
        super();
   
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       String action = request.getParameter("action");
       
		if(Objects.isNull(action)){
			action = "load-items";
		}
		switch(action){
		case "add-item":
			addItem(request,response);
			break;
		case "remove-item":
			removeItem(request,response);
			break;
		case "load-item":
			loadItem(request,response);
			break;
		case "load-items":
			loadItems(request,response);
			break;
		case "update-item":
			updateItem(request,response);
			break;
		case "load-details":
			loadDetail(request,response);
			break;
		case "add-details":
			addDetails(request,response);
			break;
		case "show-details":
			showDetails(request,response);
			break;
		default :
			action = "load-item";
		}
	}

	
	private void loadDetail(HttpServletRequest request, HttpServletResponse response) {
		int id = Integer.parseInt(request.getParameter("id"));
		request.setAttribute("itemId", id);
		try {
			request.getRequestDispatcher("/add-details.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	private void showDetails(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		int id = Integer.parseInt(request.getParameter("id"));
		Item item = itemService.loadItem(id);
		request.setAttribute("itemDetail", item.getDetail());
		try {
			request.getRequestDispatcher("/details.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		
	}


	private void addDetails(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemDetail = request.getParameter("itemDetail");
		Item item = new Item(itemId,itemDetail);
		boolean descAdded = itemService.addDetail(item);

		if (descAdded) {
			loadItems(request, response);
		}
	}


	private void loadItems(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		List<Item> items = itemService.loadItems();

		request.setAttribute("itemsData", items);
		try {
			request.getRequestDispatcher("/load-items.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


	private void updateItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		int itemId = Integer.parseInt(request.getParameter("itemId"));
		String itemName = request.getParameter("itemName");
		double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
		String itemDetail = request.getParameter("itemDetail");
		int itemTotalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
		Item item = new Item(itemId,itemName,itemPrice,itemTotalNumber,itemDetail);
		boolean updataed = itemService.updateItem(item);
		if (updataed) {
			loadItems(request, response);
		}
		
	}


	private void loadItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		int id = Integer.parseInt(request.getParameter("id"));
		Item item = itemService.loadItem(id);
		request.setAttribute("itemData", item);
		try {
			request.getRequestDispatcher("/update-item.jsp").forward(request, response);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void removeItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		int id = Integer.parseInt(request.getParameter("id"));
		Boolean removedItem = itemService.removeItem(id);
		System.out.print(removedItem);
		if (removedItem) {
			System.out.print(false);
			loadItems(request, response);
		}
		
	}


	private void addItem(HttpServletRequest request, HttpServletResponse response) {
		ItemService itemService = new ItemServiceImpl(dataSource);
		String itemName = request.getParameter("itemName");
		double itemPrice = Double.parseDouble(request.getParameter("itemPrice"));
		int itemTotalNumber = Integer.parseInt(request.getParameter("itemTotalNumber"));
		Boolean addedItem = itemService.saveItem(new Item(itemName,itemPrice,itemTotalNumber,null));
		if (addedItem) {
			loadItems(request, response);
		}
		
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
