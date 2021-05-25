package group.channel_pizza.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
/**
 * Order is the entity covering the items subject to the order together with the user
 * 
 * @author Enis Sinan Reyhan
 *
 *
 */
@Document(collection = "Order")
public class Order {
	//fields
	@Id
	private String id;
	/**
	 * Order items are listed by frontend respectively with their quantities
	 */
	private List<String> orderitems;
	private List<Integer> quantity;
	/**
	 * Total is render from frontend in accordance with the itemss 
	 */
	
	private double total;
	
	/**
	 * Date is rendered in constructor
	 */
	private String date;
	private String userid;
	
	//Getters and setters 

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}

	public Order() {
		LocalDateTime myDateObj = LocalDateTime.now();
	    DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

	    String formattedDate = myDateObj.format(myFormatObj);
		this.date= formattedDate; 
	}
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;}
	
	
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public List<String> getOrderitems() {
		return orderitems;
	}

	public void setOrderitems(List<String> orderitems) {
		this.orderitems = orderitems;
	}

	public List<Integer> getQuantity() {
		return quantity;
	}

	public void setQuantity(List<Integer> quantity) {
		this.quantity = quantity;
	} 
	


}
