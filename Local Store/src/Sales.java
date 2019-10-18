
public class Sales{
	private String iCode;
	private int iQuant;
	private String iName;
	private float iPrice;
	private float cost;
	


	

	
	public String getiName() {
		return iName;
	}
	public Sales(String iCode, int iQuant, String iName, float iPrice, float cost) {
		super();
		this.iCode = iCode;
		this.iQuant = iQuant;
		this.iName = iName;
		this.iPrice = iPrice;
		this.cost = cost;
	}
	public void setiName(String iName) {
		this.iName = iName;
	}
	public float getcost() {
		return cost;
	}
	public void setcost(float cost) {
		this.cost = cost;
	}
	
	
	public String getiCode() {
		return iCode;
	}
	public void setiCode(String iCode) {
		this.iCode = iCode;
	}
	public int getiQuant() {
		return iQuant;
	}
	public void setiQuant(int iQuant) {
		this.iQuant = iQuant;
	}




	public float getiPrice() {
		return iPrice;
	}




	public void setiPrice(float iPrice) {
		this.iPrice = iPrice;
	}
}
