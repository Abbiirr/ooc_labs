public class Product {
	int identificationNumber;
	String productName;
	int price;
	int currentLevel;
	int minLevel;
	int usualReqAmount;

	public Product(int id, String name, int price, int cQty, int mintQty, int reqQty )
	{
		this.identificationNumber = id;
		this.productName = name;
		this.price = price;
		this.currentLevel = cQty;
		this.minLevel = mintQty;
		this.usualReqAmount = reqQty;
	}

	public int getID() {
		return this.identificationNumber;
	}

	public String getName() {
		return this.productName;
	}

	public int getAmount() {
		return this.currentLevel;
	}

	public int getMinLevel() {
		return this.minLevel;
	}

	public String getDetails() {		//returns details of the product
		return "ID: "+ this.identificationNumber + " -- Product Name: "+ this.productName + " -- Price: " + this.price + 
		" -- Qty: " + this.currentLevel + " -- Min.Qty: " + this.minLevel + " -- Req. Amt.: "+ this.usualReqAmount+ "\n";
	}

	public float sell(int qty) {
		//System.out.println(this.currentLevel - qty);
		currentLevel -= qty;

		System.out.print(productName + " has been sold");

		return (qty*price)*1/100;
	}


	public void add(int qty)
	{
		currentLevel += qty;
	}

	
}