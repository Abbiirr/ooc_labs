public class Manager extends Employee {
	
	public Manager(String name, int age, int salary) {

		this.name = name;
		this.age = age;
		this.baseSalary = salary;

		System.out.println("----Manager has been added!----");
		System.out.println("Name: "+ this.name + " -- Age: "+ this.age + " -- Base Salary: " + this.baseSalary );
	}

	public void addProduct(int id, String pName, int price, int qty, int minQty, int reqAmount, Store store) {

		Product product1 = new Product(id, pName, price, qty, minQty, reqAmount);//creates new product 

		store.inventory.add(product1);  //stores the product to store.inventory

		System.out.println("----Product has been added!----");

		System.out.println(product1.getDetails());		//prints the details.

	}

	public void addExistingProduct(int id, int qty, Store store) {
		store.addItems(id, qty);
	}

	public void sendRequisition(Store store) {
		store.requisition();
	}
	
}