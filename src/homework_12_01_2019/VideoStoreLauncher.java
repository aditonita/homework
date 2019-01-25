package homework_12_01_2019;

public class VideoStoreLauncher {

	public static void main(String[] args) {

		VideoStore myVideoStore = new VideoStore();
		myVideoStore.addVideo("The Matrix");
		myVideoStore.addVideo("Godfather II");
		myVideoStore.addVideo("Star Wars Episode IV: A New Hope");

		// myVideoStore.listInventory();

		myVideoStore.checkOut("Godfather II");
		 myVideoStore.listInventory();

		myVideoStore.checkOut("Star Wars Episode IV: A New Hope");
		myVideoStore.returnVideo("Godfather II", "Ionescu", 10);
		// myVideoStore.listInventory();

		myVideoStore.checkOut("The Matrix");
		myVideoStore.returnVideo("Star Wars Episode IV: A New Hope", "Popescu", 7);
		myVideoStore.returnVideo("The Matrix", "Vasilescu", 6);
		//myVideoStore.listInventory();

		myVideoStore.checkOut("The Matrix");
		myVideoStore.returnVideo("The Matrix", "Ionescu", 10);
		//myVideoStore.listInventory();

	}

}
