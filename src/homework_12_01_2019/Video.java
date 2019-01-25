package homework_12_01_2019;

import java.util.HashMap;
import java.util.Iterator;

public class Video {

	private String title;
	private boolean checked;
	private HashMap<String, Integer> clientsRate = new HashMap<String, Integer>();

	public Video(String title) {
		this.title=title;
	}
	
	public void videoRented() {
		this.checked = true;
	}
	
	public void videoReturned() {
		this.checked = false;
	}
	
	public double videoRate() {
		double sum = 0;
		String nume;
		
		Iterator<String> iterator = this.clientsRate.keySet().iterator();
		while(iterator.hasNext()){
			nume = iterator.next();
			sum = sum + this.clientsRate.get(nume);
		}
		
		return sum / this.clientsRate.size();
	}
	
	public void getVideoRate(String name, int rate) {
		this.clientsRate.put(name, rate);
	}

	public String getTitle() {
		return title;
	}

	public boolean isChecked() {
		return checked;
	}

}
