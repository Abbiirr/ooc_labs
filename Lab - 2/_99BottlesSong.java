public class _99BottlesSong {
	
	String bottles = " bottles of milk";
	String bottle = " bottle of milk";
	String onTheWall = " on the wall";
	String noMore = "No more";
	String dot = ".";
	String comma = ", ";
	String result = "";
	String goToStore = "Go to the store and buy some more, 99 bottles of milk on the wall.";

	public String ifZero() {
		return noMore + bottles + onTheWall + comma + noMore.toLowerCase() + bottles + dot + "\n" + goToStore;
	}

	public String firstLine(int number_of_bottles) {	//System.out.println(number_of_bottles);
		String line1 = "";
		if(number_of_bottles > 1)
			line1 += "" + number_of_bottles + bottles + onTheWall + comma + number_of_bottles + bottles + dot + "\n";	//System.out.println(number_of_bottles + bottles + onTheWall + comma + number_of_bottles + bottles + dot);
		else if(number_of_bottles == 1)
			line1 += "" + number_of_bottles + bottle + onTheWall + comma + number_of_bottles + bottle + dot + "\n";	//System.out.println(number_of_bottles + bottle + onTheWall + comma + number_of_bottles + bottle + dot);
		else if(number_of_bottles == 0)
			line1 = ifZero();
		return line1;
	}

	public String takeOneDown(int number_of_bottles) {
		String takeDownLine = "Take one down and pass it around, " ;
		if(number_of_bottles > 1)
			takeDownLine += "" + number_of_bottles + bottles;
		else if(number_of_bottles == 1)
			takeDownLine += "" + number_of_bottles + bottle;
		else if(number_of_bottles == 0)
			takeDownLine += noMore.toLowerCase() + bottles;
		takeDownLine += "" +onTheWall + dot;
		return takeDownLine;
	}

	public String song(int number_of_bottles) {
		result = firstLine(number_of_bottles);
		number_of_bottles--;
		if(number_of_bottles >=0 )
			result += takeOneDown(number_of_bottles);
		System.out.println(result);
		return result;
	}
}