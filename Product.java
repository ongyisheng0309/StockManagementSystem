
public abstract class Product	
{
	private String name_product ;
	private double price_product;
	private int quantity_product , item_num;
	
	public boolean status_product = true;
	public double total_value;
	
	public Product() {} // default constructor
	public Product(String name_product ,double price_product,int quantity_product,int  item_num) //parameterized constructor
	{
		this.name_product = name_product;
		this.price_product = price_product;
		this.quantity_product = quantity_product;
		this.item_num =  item_num;
	}
	public  String getName_product() {
		return name_product;
	}
	public void setName_product(String name_product) {
		this.name_product = name_product;
	}
	public double getPrice_product() {
		return price_product;
	}
	public void setPrice_product(double price_product) {
		this.price_product = price_product;
	}
	public int getQuantity_product() {
		return quantity_product;
	}
	public void setQuantity_product(int quantity_product) {
		this.quantity_product = quantity_product;
	}
	public int getItem_num() {
		return item_num;
	}
	public void setItem_num(int item_num) {
		this.item_num = item_num;
	}
	
	public double getTotalValue(double price_item , int quantity_item)
	{
		total_value = price_item * quantity_item; 
		return total_value;
	}
	public boolean getStatus_product() {
		
		return status_product;
	}
	public void setStatus_product(boolean status_product) {
		this.status_product = status_product;
	}

	public void addStock_product (int quantity_product) //insert the adding stock item
	{
		if(getStatus_product())
		{
			this.quantity_product += quantity_product;
			System.out.println(quantity_product + " new product has added into the product list! ");
		}
		else System.out.println("Failed to adding stock to unavailable product list.");
	}
	public void deductStock_product (int quantity_product)
	{
		if(getStatus_product())
		{
			if (quantity_product > getQuantity_product() ) System.out.println("Failed to deduct stock due to not enough product in the list!");
			else 
			{
				this.quantity_product -= quantity_product;
				System.out.println(quantity_product + "  product has deduct from the product list! ");
			}
		}
		else System.out.println("Failed to deduck stock to unavailable product list.");
	}
	public String toString () 
	{
		return "Item number : " + getItem_num()  + "\n" + "Product name : " + getName_product() + "\n" 
				+ "Quantity available : " + getQuantity_product() + "\n" + "Price (RM) : " + getPrice_product()
				+ "\n" + "Product status : " + getStatus_product();
		
	}

	
	
}