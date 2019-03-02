package homework_09_02_2019;

import java.util.*;

public class Hobby {

	private String hobby;
	private int frequency;
	private List<String> adresses = new ArrayList<String>();

	public Hobby(String hobby, int frequency, List<String> adresses) {
		this.hobby = hobby;
		this.frequency = frequency;
		this.adresses = adresses;
	}

	public String getHobby() {
		return hobby;
	}

	public int getFrequency() {
		return frequency;
	}

	public List<String> getAdresses() {
		return adresses;
	}
}
