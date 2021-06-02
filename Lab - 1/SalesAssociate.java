public class SalesAssociate extends Employee {
	
	float bonus = 0;
	float totalSalary ;

	public SalesAssociate(String name, int age, int salary)
	{
		this.name = name;
		this.age = age;
		this.baseSalary = salary;
		this.totalSalary = salary;

		System.out.println("----Sales Associate has been added!----");
		System.out.println("Name: "+ this.name + " -- Age: "+ this.age + " -- Base Salary: " + this.baseSalary + " -- Bonus: " + this.bonus + " -- Total Salary: " + this.totalSalary );
	}

	public void showEmployeeInfo() {
		System.out.println("Name: " + this.name + " -- Age: " + this.age + " -- Base Salary: " + this.baseSalary + " -- Bonus: " + this.bonus + " -- Total Salary: " + this.totalSalary);
	}

	public void sellProduct(int id, int qty, Store store) {

		float saleBonus;

		saleBonus = store.sellProduct( id, qty);
		bonus += saleBonus;
		totalSalary += bonus;

		if(saleBonus > 0)
			System.out.println(" and " + this.name + " has received a bonus of BDT " + saleBonus + "!"); 

	}
}