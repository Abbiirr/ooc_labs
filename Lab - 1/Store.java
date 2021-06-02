import java.util.ArrayList;
public class Store {
	ArrayList<Product> inventory = new ArrayList<Product>();

	public Store() {
		System.out.println("----Store has been generated successfully!----");
	}

	public void showStoreDetails() {
		//System.out.println(inventory.size());

		System.out.println("----Inventory Details----");
		for(int i=0; i< inventory.size();i++)
		{
			System.out.println(inventory.get(i).getDetails());
		}
	}

	public float sellProduct(int id, int qty) {
		String productName;

		for(int i=0; i< inventory.size();i++)
		{
			productName = inventory.get(i).getName();

			if(inventory.get(i).getID() == id)
			{
				if(inventory.get(i).getAmount() - qty >= 0)
				{

					return inventory.get(i).sell(qty);
				}
				else
				{
					System.out.println("Not enough amount of "+ productName + ". Contact your manager!");

					return 0;
				}
					
					
			}
		}

		return 0;
	}

	public void requisition() {
		for(int i=0; i< inventory.size();i++)
		{
			//System.out.println(inventory.get(i).getAmount() + " " + inventory.get(i).getID()+ " " + inventory.get(i).getName());


			if(inventory.get(i).getAmount() < inventory.get(i).minLevel )
			{
				inventory.get(i).add(inventory.get(i).usualReqAmount);

				System.out.println("----Added " + inventory.get(i).usualReqAmount + " pieces of " + inventory.get(i).getName() + "----");
			}
		}

		//System.out.println("Requisitionn completed");

	}

	public void addItems(int id, int qty) {
		for(int i=0; i< inventory.size();i++)
		{
			if(inventory.get(i).getID() == id)
			{
				inventory.get(i).currentLevel += qty;

				System.out.println("----Added " + qty + " pieces of " + inventory.get(i).getName() + "----");
			}
		}

	}
}