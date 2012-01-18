package pumpsoft.ibm.data;

public class ShopData extends InvenData{
	private String price;

	public ShopData(String id, String name, String count, String desc, String url, String effect, String price) {
		super(id, name, count, desc, url, effect);
		// TODO Auto-generated constructor stub
		this.price = price;
	}

	public String getPrice() {
		return price;
	}

}
