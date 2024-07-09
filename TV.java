
public class TV extends Product
{
	private String screen_type,resolution,display_size;
	
	public TV(String name_product,String screen_type, String resolution, String display_size,
			int quantity_product  ,double price_product, int item_num)
			
	{
		super( name_product,  price_product,  quantity_product,  item_num);
		this.screen_type = screen_type;
		this.resolution = resolution;
		this.display_size = display_size;
		
	}

	public String getScreen_type() {
		return screen_type;
	}

	public void setScreen_type(String screen_type) {
		this.screen_type = screen_type;
	}

	public String getResolution() {
		return resolution;
	}

	public void setResolution(String resolution) {
		this.resolution = resolution;
	}

	public String getDisplay_size() {
		return display_size;
	}

	public void setDisplay_size(String display_size) {
		this.display_size = display_size;
	}
	
	public double getInventory_value(int quantity_product , double price_product)
	{
		return quantity_product * price_product;
		
	}
	public String toString()
	{
		return "Item number : " + getItem_num()  + "\n" + "Product name : " + getName_product() + "\n" 
				+"Screen type : " +getScreen_type() +"\n" + "Resolution : " + getResolution() + "\n" +"Display size :  " + getDisplay_size() + "\n"
				+ "Quantity available : " + getQuantity_product() + "\n" + "Price (RM) : " + getPrice_product()
				+ "\n"+"Inventory value (RM) : "+getInventory_value(getQuantity_product(),getPrice_product())+ "\n"  + "Product status : " + getStatus_product();
	}

}
