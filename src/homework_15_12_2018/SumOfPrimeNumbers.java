package tema1;

public class SumOfPrimeNumbers {
	static final int NUMAR_MAX = 100;
	
	public static void main(String[] args) {
		
		int[] allNumbers = new int[NUMAR_MAX+1];
		int numarCurent = 0;
		int result = 0;
		
		for(int i=0; i<=NUMAR_MAX;i++) {
			allNumbers[i] = i;
			//System.out.print(allNumbers[i]);
		}
		
		for(int i=2; i<=NUMAR_MAX;i++) {
			if(allNumbers[i] != 0) {
			numarCurent = allNumbers[i];
			//System.out.print(numarCurent + ",");
			for(int j=i+1;j<=NUMAR_MAX;j++) {
				if(allNumbers[j] % numarCurent == 0) {
					allNumbers[j] = 0;
				}
			}
			}
		}
		
		for(int i=0;i<=NUMAR_MAX;i++) {
			result = result +allNumbers[i];
		}
		
		System.out.println("Suma numerelor prime pana la " + NUMAR_MAX + " este " + result);
	}
}
