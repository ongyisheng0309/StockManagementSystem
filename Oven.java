public class Oven extends Product

{
	private String oven_type;
	private String color;
	private double capacity;
	
	public Oven(String name_product, String oven_type, String color, double capacity, 
		int quantity_product, double price_product, int item_num)
	{
		super(name_product, price_product, quantity_product, item_num);
		this.oven_type = oven_type;
		this.color = color;
		this.capacity = capacity;
	}

	public String getOven_type() {
		return oven_type;
	}

	public void setOven_type(String oven_type) {
		this.oven_type = oven_type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public double getCapacity() {
		return capacity;
	}

	public void setCapacity(double capacity) {
		this.capacity = capacity;
	}
	
	public double getInventory_value(int quantity_product , double price_product)
	{
		return quantity_product * price_product;
	}
	
	public String toString()
	{
		return "Item number : " + getItem_num()  + "\n" + "Product name : " + getName_product() + "\n" 
			+"Oven type : " + getOven_type() +"\n" + "Color : " + getColor() + "\n" +"Capacity (in Litres) : " + getCapacity() + "\n"
			+ "Quantity available : " + getQuantity_product() + "\n" + "Price (RM) : " + getPrice_product()
			+ "\n"+"Inventory value (RM) : "+getInventory_value(getQuantity_product(),getPrice_product())+ "\n"  + "Product status : " + getStatus_product();
	}
}
