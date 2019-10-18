
public class Stock {
	private String code;
	private String name;
	private int quant;
	private float price;
	
	
	
	public float getPrice() {
		return price;
	}



	public void setPrice(float price) {
		this.price = price;
	}



	public Stock(String code, String name, int quant, float price) {
		super();
		this.code = code;
		this.name = name;
		this.quant = quant;
		this.price = price;
	}
	

	
	public Stock() {
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getQuant() {
		return quant;
	}
	public void setQuant(int quant) {
		this.quant = quant;
	}



	public String getCode() {
		return code;
	}



	public void setCode(String code) {
		this.code = code;
	}
	

}
