import java.util.*;
import java.util.regex.Pattern;

//import Mainclass.NameException;
//import Mainclass.PhoneException;
public class Main {
	ArrayList<Stock> stockList;
	ArrayList<Sales> salesList;
	ArrayList<String> codeList;
	public static void main(String args[]) {
		Main m = new Main();
		m.stockList = new ArrayList<>();
		m.salesList = new ArrayList<>();
		m.codeList = new ArrayList<>();
		Stock s = new Stock("001","Pen",13,100f);
		m.stockList.add(s);
		Stock s1 = new Stock("002","Pencil",23,120f);
		m.stockList.add(s1);
		Stock s2 = new Stock("003","Apple",10,32f);
		m.stockList.add(s2);
		Stock s3 = new Stock("004","Grape",5,332f);
		m.stockList.add(s3);
		Stock s4 = new Stock("005","Orange",17,210f);
		m.stockList.add(s4);
		m.codeList.add("001");
		m.codeList.add("002");
		m.codeList.add("003");
		m.codeList.add("004");
		m.codeList.add("005");
		int f=1;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("MENU");
			System.out.println("1. Add Stock");
			System.out.println("2. View Stock");
			System.out.println("3. Update Stock");
			System.out.println("4. Sale Entry");
			System.out.println("5. View Sales Invoice");
			System.out.println("0. Exit");
			System.out.println("Enter a option:");
			int opt=Integer.parseInt(sc.nextLine());
			switch(opt) {
			case 1:
				m.addStock();
				break;
			case 2:
				m.viewStock();
				break;
			case 3:
				m.updateStock();
				break;
			case 4:
				m.saleEntry();
				break;
			case 5:
				m.viewSaleEntry();
				break;
			case 0:
				f=0;
				break;
			}	
			
			
		}while(f==1);
			
			
		
	}//main method ends
	class NameException extends Exception {
		public NameException(String message) {
			super(message);
		}
	}
	
	class CodeException extends Exception {
		public CodeException(String message) {
			super(message);
		}
	}
	
	public boolean validatename(String name) {
		Pattern p = Pattern.compile("^[a-zA-Z][a-zA-Z\\s]+$");
		try {
		if(p.matcher(name).matches()) {return false;}
		if (!(p.matcher(name).matches())) {
			throw new NameException("Name Should not contain numbers or special characters or be null");
		}
		else {return false;}
		}
		catch(NameException e){
			System.err.println(e.getMessage());
			return true;
		}
	}
	public boolean validatecode(String ph) {
		Pattern p = Pattern.compile("^\\d{3}$");
		try {
		if(p.matcher(ph).matches()) {return false;}
		if (!(p.matcher(ph).matches())) {
			throw new CodeException("Code Should be 3 digits");
		}
		else {return false;}
		}
		catch(CodeException e){
			System.err.println(e.getMessage());
			return true;
		}
	}
	
	public void viewSaleEntry() {
		float tot=0;
		System.out.println("************************SALES INVOICE***************************\n\n");
		System.out.format("%10s %10s %10s %10s %10s","CODE","NAME","QUANTITY","PRICE","COST");
		System.out.println();
		for(Sales s:salesList) {
			tot+=s.getcost();
			System.out.format("%10s %10s %10d %10.2f %10.2f",s.getiCode(),s.getiName(),s.getiQuant(),s.getiPrice(),s.getcost());
			System.out.println();
		}
		System.out.format("%30s %.2f","TOTAL COST",tot);
		System.out.println();
		System.out.println("*******************************************************************\n\n");
		
		
	}
	
	public void saleEntry() {
		Scanner sc = new Scanner(System.in);
		int fg=1;
		float price=0f;
		int quant=0;
		int qq; 
		String name="";
		do {
			System.out.println("Enter the Product Code :");
			String code=sc.nextLine();
			for(Stock k :stockList) {
				if(k.getCode().equals(code)) {
					fg=0;
					price=k.getPrice();
					quant=k.getQuant();
					name=k.getName();
				}
			}
			if(fg==1) {
				System.out.println("No item found");
			}
			else {
			System.out.println("Enter the quantity");
			int reqQuant = Integer.parseInt(sc.nextLine());
			if(reqQuant>quant) {
				System.out.println("Stock not available.\n Available Quantity: "+quant);
			}
			else {
			float cost = (float)reqQuant*price;
			int remQuant = quant-reqQuant;
			for(Stock k :stockList) {
				if(k.getCode().equals(code)) {
					k.setQuant(remQuant);
				}
			}
			Sales s= new Sales(code,reqQuant,name,price,cost);
			this.salesList.add(s);
			}
			}
			System.out.println("Press 1 enter another item \n Press 2 for Menu");
			qq= Integer.parseInt(sc.nextLine());
		}while(qq==1);
	
		
	}
	public void addStock() {
		Scanner sc = new Scanner(System.in);
		System.out.printf("%70s\n","ENTER DETAILS OF PRODUCT");
		System.out.println("Enter Product Code : ");
		String code=sc.nextLine();
		
		while(this.validatecode(code)) {
			System.out.println("Code must be a three digit number.\nPlease enter valid Code : ");
			code=sc.nextLine();
		}
		if(codeList.contains(code)) {
			System.out.println("Product already exists");
		}
		else {
			System.out.println("Enter Product Name : ");
			String name=sc.nextLine();
			while(this.validatename(name)) {
				System.out.println("Please enter valid product name : ");
				name=sc.nextLine();
			}
			
			System.out.println("Enter Quantity : ");
			int quant = Integer.parseInt(sc.nextLine());
			System.out.println("Enter Price : ");
			float price = Integer.parseInt(sc.nextLine());
			
			Stock st = new Stock(code,name,quant,price);
			this.stockList.add(st);
			
		}
		

		
	}
	
	public void updateStock() {
		int flag=1;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Item Code to Update");
		String i =sc.nextLine();
		for(Stock s:stockList) {
			if(s.getCode().equals(i)) {
				System.out.println("Enter the new Product Name: ");
				String name = sc.nextLine();
				while(validatename(name)) {
					System.out.println("Please enter valid product name : ");
					name=sc.nextLine();
				}
				
				System.out.println("Enter the new Quantity :");
				int q = Integer.parseInt(sc.nextLine());
				
				System.out.println("Enter Price : ");
				float price = Integer.parseInt(sc.nextLine());
				
				flag=0;
				s.setName(name);
				s.setQuant(q);
				s.setPrice(price);
				System.out.println("Product has been Updated Successfully");
				
				
			}
			
			
		}
		if(flag==1) {
			System.out.println("No item matches the entered Item Code");
		}
		
	}
	
	public void viewStock() {
		System.out.println("******************* STOCK DETAILS *****************************\n");
		System.out.format("%10s %10s %10s %10s\n", "CODE","NAME","QUANTITY","PRICE");
		for (Stock n : this.stockList) {
			System.out.format("%10s %10s %10d %10.2f",n.getCode(),n.getName(),n.getQuant(),n.getPrice());
			System.out.println();

	}
		System.out.println();
		System.out.println("**************************************************************");
	}

}
