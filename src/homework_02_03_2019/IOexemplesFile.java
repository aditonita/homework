package homework_02_03_2019;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
//import java.io.FileFilter;
//import java.io.FilenameFilter;
import java.io.IOException;
import java.util.Date;

public class IOexemplesFile {

	public static void main(String[] args) {
		/*
		 * 1. Write a program to get a list of all file/directory names from the given.
		 * 
		 * 2. Write a program to get specific files by extensions from a specified
		 * folder. 3. Write a program to check if a file or directory specified by
		 * pathname exists or not. 4. Write a program to check if a file or directory
		 * has read and write permission. 5. Write a program to check if given pathname
		 * is a directory or a file. 6. Write a program to compare two files
		 * lexicographically. 7. Write a program to get last modified time of a file. 8.
		 * Write program to read input from java console. 9. Write a program to get file
		 * size in bytes, kb, mb. 10. Write a program to read contents from a file into
		 * byte array. 11. Write a program to read a file content line by line. 12.
		 * Write a program to read a plain text file. 13. Write a program to read a file
		 * line by line and store it into a variable. 14. Write a program to store text
		 * file content line by line into an array. 15. Write a program to write and
		 * read a plain text file. 16. Write a program to append text to an existing
		 * file. 17. Write a program to read first 3 lines from a file. 18. Write a
		 * program to find the longest word in a text file. 19. Write a program to
		 * extract all the words (only) from a text file and sort them by number of
		 * occurrences in the file.
		 */

		// System.out.println(File.listRoots()[0]);
		// System.out.println(System.getProperty("user.dir"));


//		File file1 = new File("D:\\github\\homework\\src\\homework_02_03_2019");
//		File file2 = new File("D:\\github\\homework\\src\\homework_02_03_2019\\file");
//		File file3 = new File("D:\\github\\homework\\src\\homework_02_03_2019\\hiddenfile");
//		File file4 = new File("D:\\github\\homework\\src\\homework_02_03_2019\\readonlyfile");
//		File file5 = new File("D:\\github\\homework\\src\\homework_02_03_2019\\execute");

		/*
		 * System.out.println(file1.pathSeparator);
		 * System.out.println(file1.pathSeparatorChar);
		 * System.out.println(file1.separator); System.out.println(file1.separatorChar);
		 * 
		 * System.out.println(file1.canExecute());
		 * System.out.println(file2.canExecute());
		 * 
		 * System.out.println(file1.canWrite()); System.out.println(file2.canWrite());
		 * System.out.println(file3.canWrite()); System.out.println(file4.canWrite());
		 * 
		 * System.out.println(file1.exists()); System.out.println(file2.exists());
		 * System.out.println(file5.exists());
		 * 
		 * System.out.println(file1.getAbsolutePath());
		 * System.out.println(file2.getAbsolutePath());
		 * 
		 * try { System.out.println(file1.getCanonicalFile());
		 * System.out.println(file2.getCanonicalFile());
		 * 
		 * System.out.println(file1.getCanonicalPath());
		 * System.out.println(file2.getCanonicalPath()); } catch (IOException e) {
		 * e.printStackTrace(); }
		 * 
		 * System.out.println(file1.getName()); System.out.println(file2.getName());
		 * 
		 * System.out.println(file1.getParent()); System.out.println(file2.getParent());
		 * 
		 * System.out.println(file1.getParentFile());
		 * System.out.println(file2.getParentFile());
		 * 
		 * System.out.println(file1.getPath()); System.out.println(file2.getPath());
		 * 
		 * System.out.println(file1.isDirectory());
		 * System.out.println(file2.isDirectory());
		 * 
		 * System.out.println(file1.isFile()); System.out.println(file2.isFile());
		 * 
		 * System.out.println(file1.isHidden()); System.out.println(file2.isHidden());
		 * System.out.println(file3.isHidden());
		 * 
		 * System.out.println(new Date(file1.lastModified())); System.out.println(new
		 * Date(file2.lastModified()));
		 * 
		 * System.out.println(file1.length()); System.out.println(file2.length());
		 * 
		 * System.out.println(file1.list()[0]); System.out.println(file2.list());
		 * 
		 * System.out.println(file1.listFiles()[0]);
		 * System.out.println(file2.listFiles());
		 * 
		 * System.out.println(file1.listRoots()[1]);
		 * System.out.println(file2.listRoots());
		 * 
		 * 
		 * System.out.println(file1.list((d, s) ->
		 * s.toLowerCase().endsWith("file")).length); System.out.println(file1.list(new
		 * FilenameFilter() {
		 * 
		 * @Override public boolean accept(File dir, String name) { if
		 * (name.toLowerCase().endsWith("file")) { return true; } return false; }
		 * 
		 * }).length);
		 * 
		 * System.out.println(file1.listFiles(d ->
		 * d.getName().endsWith("file")).length); System.out.println(file1.listFiles(new
		 * FileFilter() {
		 * 
		 * @Override public boolean accept(File pathname) { if
		 * (pathname.getName().endsWith("file")) { return true; } return false; }
		 * 
		 * }).length);
		 * 
		 * System.out.println(file1.toURI()); System.out.println(file2.toURI());
		 */
	}

}
