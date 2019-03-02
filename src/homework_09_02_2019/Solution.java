package homework_09_02_2019;

import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Map<Person, Hobby> hobbys = new HashMap<Person, Hobby>();
		List<String> adresses = new ArrayList<String>();

		adresses.add("Romania");
		adresses.add("England");
		adresses.add("Australia");

		Hobby hobby = new Hobby("cycling", 2, new ArrayList<String>(adresses));
		hobbys.put(new Person("Ionut", "Luchian", 1090909310102L, "Romania"), hobby);

		adresses.clear();
		adresses.add("USA");
		hobby = new Hobby("swiming", 3, new ArrayList<String>(adresses));
		hobbys.put(new Person("Mary", "Marylou", 2101010078123L, "Mexic"), hobby);

		adresses.clear();
		adresses.add("UK");
		adresses.add("France");
		hobby = new Hobby("jogging", 1, new ArrayList<String>(adresses));
		hobbys.put(new Person("Jhon", "Mclauren", 5020202123456L, "USA"), hobby);

		hobbys.forEach((Person p, Hobby h) -> System.out.println(p.getFirstName() + " - " + h.getHobby()));

	}

}
