package channelpizza.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Products")
public class Item {
	
	@Id
	private String id;
	private String title;
	private String description;
	private String image;
	private double price;
	private String type;
	private String date;
	
	
	
	public Item(String id, String title, String description, String image, double price, String type, String date) {
		
		this.id = id;
		this.title = title;
		this.description = description;
		this.image = image;
		this.price = price;
		this.type = type;
		this.date = date;
	}
	
	
	
	public Item() {
		super();
		// TODO Auto-generated constructor stub
	}


	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}


	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
	
	

}
