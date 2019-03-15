package homework_02_03_2019;

public class ArgumentsExceptionError extends Exception {

	@Override
	public String toString() {
		return "Please enter command:\n help\n exit\n listPath\n listFilterPath\n exists\n checkPermisions\n typePath\n comparePath\n lastModifiedDate\n "
				+ "consoleRead\n fileSize\n readBytes\n readLines\n readTextFile\n readFileIntoVariable\n readFileIntoArray\n readWriteFile\n appendText\n readFirstLines\n "
				+ "longestWord\n wordsOccurrence\n";
	}
	
}
