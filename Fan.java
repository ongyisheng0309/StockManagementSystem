
public class Fan extends Product
{
	private String fan_type;
	private String color;
	private int blade_count;
	private int rpm;
	
	public Fan(String name_product, String fan_type, String color, int blade_count, int rpm,
		int quantity_product, double price_product, int item_num)
	{
		super(name_product, price_product, quantity_product, item_num);
		this.fan_type = fan_type;
		this.color = color;
		this.blade_count = blade_count;
		this.rpm = rpm;
	}

	public String getFan_type() {
		return fan_type;
	}

	public void setFan_type(String fan_type) {
		this.fan_type = fan_type;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public int getBlade_count() {
		return blade_count;
	}

	public void setBlade_count(int blade_count) {
		this.blade_count = blade_count;
	}
	
	public int getRpm() {
		return rpm;
	}

	public void setRpm(int rpm) {
		this.rpm = rpm;
	}
	
	public double getInventory_value(int quantity_product , double price_product)
	{
		return quantity_product * price_product;
	}
	
	public String toString()
	{
		return "Item number : " + getItem_num()  + "\n" + "Product name : " + getName_product() + "\n" 
			+"Fan type : " + getFan_type() +"\n" + "Color : " + getColor() + "\n" +"Blade count : " + getBlade_count() + "\n"
			+ "RPM : " + getRpm() + "\n"
			+ "Quantity available : " + getQuantity_product() + "\n" + "Price (RM) : " + getPrice_product()
			+ "\n"+"Inventory value (RM) : "+getInventory_value(getQuantity_product(),getPrice_product())+ "\n"  + "Product status : " + getStatus_product();
	}
}
