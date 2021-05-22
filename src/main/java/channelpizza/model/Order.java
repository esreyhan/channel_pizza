package channelpizza.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Order")
public class Order {
	
	@Id
	private String id;
	private List<String> orderitems;
	private List<Integer> quantity;
	private double total;
	private String date;
	private String userid;
	

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
