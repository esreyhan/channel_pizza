package group.channel_pizza.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
/**
 * 
 * Entity is used to parse the JSON object sent to Web Service
 * 
 * @author nazlituncer
 *
 */
public class OrderItemDTO {
	//fields

	private String itemid;
	private int quantity;
	
	//getters and setters
	public String getItemid() {
		return itemid;
	}
	public void setItemid(String itemid) {
		this.itemid = itemid;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
	
}