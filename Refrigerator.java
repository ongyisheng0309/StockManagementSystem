
public class Refrigerator extends Product
{
	private String door_design;
	private String color;
	private double capacity;
	
	public Refrigerator(String name_product,String door_design,String color,double capacity, 
			int quantity_product,double price_product, int item_num)
			
	{
		super(name_product, price_product, quantity_product, item_num);
		this.door_design = door_design;
		this.color = color;
		this.capacity = capacity;
	}

	public String getDoor_design() {
		return door_design;
	}

	public void setDoor_design(String door_design) {
		this.door_design = door_design;
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
				+"Door design : " +getDoor_design() +"\n" + "Color : " + getColor() + "\n" +"Capacity (in Litres) : " + getCapacity() + "\n"
				+ "Quantity available : " + getQuantity_product() + "\n" + "Price (RM) : " + getPrice_product()
				+ "\n"+"Inventory value (RM) : "+getInventory_value(getQuantity_product(),getPrice_product())+ "\n"  + "Product status : " + getStatus_product();
	}
}