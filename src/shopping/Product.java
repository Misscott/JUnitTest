package shopping;

public class Product {
	private String code;
	private String title;
	private String description;
	private double price;

	public Product(String code, String title, String description, double price) {
		this.code = code;
		this.title = title;
		this.description = description;
		this.price = price;
	}

	public String getCode() {
		return code;
	}

	public String getTitle() {
		return title;
	}

	public String getDescription() {
		return description;
	}

	public double getPrice() {
		return price;
	}
}