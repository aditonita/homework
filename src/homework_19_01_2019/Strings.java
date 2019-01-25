package homework_19_01_2019;

public class Strings {

	private String string;

	public Strings(String string) {
		this.string = string;
	}

	public int IndexOf(char c) {
		int i = 0;
		int result = -1;
		while (i < this.string.length()) {
			if (this.string.charAt(i) == c) {
				result = i;
				break;
			}
			i++;
		}
		return result;
	}

	public boolean Palindrom() {
		boolean result = false;
		StringBuilder string = new StringBuilder(this.string);
		
		if (this.string.equals(string.reverse().toString())) {
			result = true;
		}

		return result;
	}
}
