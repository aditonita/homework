package tema1;

public class TresCincos {
 
	static final int NUMAR_MAX = 100;

	public static void main(String[] args) {
		
		boolean tresOrCincos = false;
		
		for(int i=1;i<=NUMAR_MAX;i++) {
			if(i % 3 == 0) {
				tresOrCincos = true;
				System.out.print("Tres");
			}
			if(i % 5 == 0){
				tresOrCincos = true;
				System.out.print("Cincos");
			}
			if(!tresOrCincos){
				System.out.print(String.valueOf(i));
			}
			System.out.println("");
			tresOrCincos = false;
		}
	}
}
