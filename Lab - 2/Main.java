
public class Main {
	
	public static void main(String[] args) {
		_99BottlesSong song1 = new _99BottlesSong();
		int numberOfBottles = Integer.parseInt(args[0]);
		for(;numberOfBottles >= 0 ; numberOfBottles--)
			song1.song(numberOfBottles);
	}
}