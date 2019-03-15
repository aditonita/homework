package homework_02_03_2019;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public class IOexemples {

	public static void main(String[] args) throws ArgumentsExceptionError {

		String command;
		String path;
		String ext;
		String secondArg;
		String thirdArg = null;
		String compareToPath;
		String inFile;
		String outFile;
		String text;

		if (args.length == 0) {
			throw new ArgumentsExceptionError();
		} else {
			command = args[0];
		}

		if (args.length > 1) {
			secondArg = args[1];
		} else {
			secondArg = System.getProperty("user.dir");
		}

		if (args.length > 2) {
			thirdArg = args[2];
		}

		switch (command) {
		case "listPath":
			path = secondArg;
			listPath(path);
			break;
		case "listFilterPath":
			path = secondArg;
			ext = thirdArg;
			listFilterPath(path, ext);
			break;
		case "exists":
			path = secondArg;
			exists(path);
			break;
		case "checkPermisions":
			path = secondArg;
			checkPermisions(path);
			break;
		case "typePath":
			path = secondArg;
			typePath(path);
			break;
		case "comparePath":
			path = secondArg;
			compareToPath = thirdArg;
			comparePath(path, compareToPath);
			break;
		case "lastModifiedDate":
			path = secondArg;
			lastModifiedDate(path);
			break;
		case "consoleRead":
			consoleRead();
			break;
		case "fileSize":
			path = secondArg;
			fileSize(path);
			break;
		case "readBytes":
			path = secondArg;
			byte[] bytes = null;
			try {
				bytes = readBytes(path);
			} catch (IOException e) {
				e.printStackTrace();
			}
			printBytes(bytes);
			break;
		case "readLines":
			path = secondArg;
			readLines(path);
			break;
		case "readTextFile":
			path = secondArg;
			printLines(readTextFile(path));
			break;
		case "readFileIntoVariable":
			path = secondArg;
			printMap(readFileIntoVariable(path));
			break;
		case "readFileIntoArray":
			path = secondArg;
			printArray(readFileIntoArray(path));
			break;
		case "readWriteFile":
			inFile = secondArg;
			outFile = thirdArg;
			readWriteFile(inFile, outFile);
			break;
		case "appendText":
			path = secondArg;
			text = thirdArg;
			appendText(path, text);
		case "readFirstLines":
			path = secondArg;
			int linesNumber = Integer.parseInt(thirdArg);
			readFirstLines(path, linesNumber);
			break;
		case "longestWord":
			path = secondArg;
			longestWord(path);
		case "wordsOccurrence":
			path = secondArg;
			wordsOccurrence(path);
			break;
		case "help":

			break;
		default:
			System.out.println(
					"enter command:\n help\n exit\n listPath path\n listFilterPath path extension\n exists path\n checkPermisions path\n typePath path\n comparePath path "
							+ "compareToPath\n lastModifiedDate path\n consoleRead\n fileSize path\n readBytes path\n readLines path\n readTextFile path\n "
							+ "readFileIntoVariable path\n readFileIntoArray path\n readWriteFile inFile outFile\n appendText path text\n readFirstLines path linesNumber\n "
							+ "longestWord path\n wordsOccurrence path\n");
		}
	}

// 1. Write a program to get a list of all file/directory names from the given.
	private static void listPath(String path) {
		File file = new File(path);

		for (File item : file.listFiles()) {
			if (item.isDirectory()) {
				System.out.format("d %s%n", item.getName());
			}
			if (item.isFile()) {
				System.out.format("f %s%n", item.getName());
			}
		}
	}

//2. Write a program to get specific files by extensions from a specified folder
	private static void listFilterPath(String path, String ext) {
		File file = new File(path);
		String[] fileList = file.list((d, s) -> s.toLowerCase().endsWith(ext));
		for (String item : fileList) {
			System.out.println(item);
		}
	}

//3. Write a program to check if a file or directory specified by pathname exists or not.
	private static void exists(String path) {
		File file = new File(path);
		String flag = "";
		if (file.isDirectory()) {
			flag = "directory";
		}
		if (file.isFile()) {
			flag = "file";
		}
		if (file.exists()) {
			System.out.println(flag + " " + path + " exists");
		} else {
			System.out.println(flag + " " + path + " is missing");
		}
	}

//4. Write a program to check if a file or directory has read and write permission.
	private static void checkPermisions(String path) {
		String d = "";
		String r = "";
		String w = "";
		String x = "";
		Path file = Paths.get(path);
		if (Files.isDirectory(file)) {
			d = "d";
		} else {
			d = "-";
		}
		if (Files.isReadable(file)) {
			r = "r";
		} else {
			r = "-";
		}
		if (Files.isWritable(file)) {
			w = "w";
		} else {
			w = "-";
		}
		if (Files.isExecutable(file)) {
			x = "x";
		} else {
			x = "-";
		}
		System.out.println(d + r + w + x + "    " + path);
	}

//5. Write a program to check if given pathname is a directory or a file.
	private static void typePath(String path) {
		File file = new File(path);
		if (file.isDirectory()) {
			System.out.format("%s is a dircetory", path);
		}
		if (file.isFile()) {
			System.out.format("%s is a file", path);
		}
	}

//6. Write a program to compare two files lexicographically.
	private static void comparePath(String path, String compareToPath) {
		File file = new File(path);
		if (file.compareTo(new File(compareToPath)) < 0) {
			System.out.format("%s is lexicographically lower then %s", path, compareToPath);
		}
		if (file.compareTo(new File(compareToPath)) > 0) {
			System.out.format("%s is lexicographically higher then %s", path, compareToPath);
		}
		if (file.compareTo(new File(compareToPath)) == 0) {
			System.out.format("%s is lexicographically equal with %s", path, compareToPath);
		}
	}

//7. Write a program to get last modified time of a file. 
	private static void lastModifiedDate(String path) {
		File file = new File(path);
		System.out.println(new Date(file.lastModified()));
	}

///8. Write program to read input from java console.
	private static void consoleRead() {

		System.out.print("Enter username: ");
		Scanner sc = new Scanner(System.in);
		String username = sc.nextLine();
		System.out.format("username: %s", username);

//to use Consloe class run in cmd window: java -cp bin homework_02_03_2019.IOexemples consoleRead
//		String username = "";
//		char[] password = null;
//		String p = "";
//		Console cn;
//		cn = System.console();
//		username = cn.readLine();
//		password = cn.readPassword();
//		cn.flush();
//		for (char c : password) {
//			p += c;
//		}
//		cn.printf("username: %s password: %s", username, p);
	}

//9. Write a program to get file size in bytes, kb, mb	
	private static void fileSize(String path) {
		long size = -1;
		Path file = Paths.get(path);
		try {
			if (!Files.isDirectory(file)) {
				size = Files.size(file);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (size != -1) {
			System.out.println(path + " has " + size + " bytes");
			if (size > 1000) {
				System.out.println(path + " has " + ((float) size / 1000) + " kilobytes");
			}
			if (size > 1000000) {
				System.out.println(path + " has " + ((float) size / 1000000) + " megabytes");
			}
		}
	}

//10. Write a program to read contents from a file into byte array. 
	private static byte[] readBytes(String path) throws IOException {
		int d = 0;
		FileInputStream fis = new FileInputStream(path);
		d = fis.available();
		byte[] b = new byte[d];
		fis.read(b);
		return b;
	}

	private static void printBytes(byte[] bytes) {
		for (int i = 0; i < bytes.length; i++) {
			if (bytes[i] < 16 && bytes[i] >= 0) {
				System.out.format("0%x ", bytes[i]);
			} else {
				System.out.format("%x ", bytes[i]);
			}
		}
	}

//11. Write a program to read a file content line by line. 
	private static void readLines(String path) {
		String line;
		int contor = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			while ((line = reader.readLine()) != null) {
				System.out.println((++contor) + "\t" + line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//12. Write a program to read a plain text file. 
	private static List<String> readTextFile(String path) {
		Path file = Paths.get(path);
		List<String> lines = new ArrayList<>();
		try {
			lines = Files.readAllLines(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	private static void printLines(List<String> lines) {
		lines.forEach(l -> System.out.println(l));
	}

//13. Write a program to read a file line by line and store it into a variable. 
	private static Map<Integer, String> readFileIntoVariable(String path) {
		Map<Integer, String> map = new HashMap<>();
		String line = null;
		int lineNumber = 0;
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			while ((line = reader.readLine()) != null) {
				map.put(++lineNumber, line);
			}
		} catch (IOException ex) {
			ex.getStackTrace();
		}
		return map;
	}

	private static void printMap(Map<Integer, String> map) {
		map.forEach((k, v) -> System.out.format("%d    %s%n", k, v));
	}

//14. Write a program to store text file content line by line into an array. 
	private static String[] readFileIntoArray(String path) {
		int linesNumber = 0;
		String[] lines = null;
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
			while (reader.readLine() != null) {
				linesNumber++;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		lines = new String[linesNumber];
		try (BufferedReader reader = Files.newBufferedReader(Paths.get(path))) {
			for (int i = 0; i < linesNumber; i++) {
				lines[i] = reader.readLine();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return lines;
	}

	private static void printArray(String[] array) {
		for (String item : array) {
			System.out.println(item);
		}
	}

//15. Write a program to write and read a plain text file. 
	private static void readWriteFile(String inFile, String outFile) {
		try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(inFile));
				BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(outFile, true))) {
			int line;
			while ((line = reader.read()) != -1) {
				writer.write(line);
			}
		} catch (IOException ex) {
			ex.getStackTrace();
		}
	}

//16. Write a program to append text to an existing file. 
	private static void appendText(String path, String text) {
		try (BufferedWriter wr = new BufferedWriter(new FileWriter(path, true))) {
			wr.write(text);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//17. Write a program to read first 3 lines from a file. 
	private static void readFirstLines(String path, int linesNumber) {
		try {
			BufferedReader reader = Files.newBufferedReader(Paths.get(path));
			for (int i = 0; i < linesNumber; i++) {
				System.out.println(reader.readLine());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

//18. Write a program to find the longest word in a text file. 
	private static void longestWord(String path) {
		int max = Integer.MIN_VALUE;
		String longestWord = null;
		try {
			for (String line : Files.readAllLines(Paths.get(path))) {
				String[] words = line.split("[(\\s+)(.*)(?*)(,*)(;*)(!+)(:*)]");
				for (String word : words) {
					if (word.length() > max) {
						max = word.length();
						longestWord = word;
					}
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(longestWord);
	}

//19. Write a program to extract all the words (only) from a text file and sort them by number of occurrences in the file.
	private static void wordsOccurrence(String path) {
		Object[] wordsList = null;
		Object[] wordsDistinct = null;
		long wordNumber = 0;
		String patern = "[(\\s+)(\\t+)(.+)(?+)(,+)(;+)(!+)(:+)(\\r\\n|[\\n\\r\\u2028\\u2029\\u0085])?]";
		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			Stream<String> stream = reader.lines();
			Stream<String> words = stream.flatMap(line -> Stream
					.of(line.split(patern)));
			Stream<String> ww = words.distinct();
			Stream<String> uu = ww.sorted();
			wordsDistinct = uu.toArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
			Stream<String> stream = reader.lines();
			Stream<String> words = stream.flatMap(line -> Stream
					.of(line.split(patern)));
			wordsList = words.toArray();
		} catch (IOException e) {
			e.printStackTrace();
		}

		for (Object item1 : wordsDistinct) {
			for (Object item2 : wordsList) {
				if (item1.equals(item2)) {
					wordNumber++;
				}
			}
			System.out.println((String) item1 + " " + wordNumber);
			wordNumber = 0;
		}
	}
}
