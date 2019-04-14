package homework_16_03_2019;

public class ShellHelp {

	public static void help() {
		helpDir();
		helpCd();
		helpCp();
		helpMkdir();
		helpMv();
		helpCat();
		helpRm();
		helpFind();
		helpTree();
	}

	public static void helpDir(String... string) {
		if (string.length == 0) {
			System.out.println(
					"command: dir\n  print all files and directories from current directory\ncommand: dir path\n"
							+ "  print all files and directories under directory\n  path is a directory not a file");
		}
		if (string.length > 0) {
			for (String e : string) {
				System.out.println(e);
			}
		}
	}

	public static void helpCd() {
		System.out.println(
				"command: cd path\n  path is a directory\n  if path is a file or not exist will return current path");
	}

	public static void helpCp() {
		System.out.println(
				"command: cd source target\n will copy the source file to target file\n  any other input will throw an error");
	}

	public static void helpMkdir() {
		System.out.println("command: mkdir path\n  create a new directory and all path to them");
	}

	public static void helpMv() {
		System.out.println("command: mv source target\n move a file from source to path\n "
				+ "if directory path don't exist an exception is thrown");
	}

	public static void helpCat() {
		System.out.println("command: cat file\n list all lines from file\n if file not exist an exception is thrown");
	}

	public static void helpRm() {
		System.out.println(
				"command: rm file\n delete a file from disk\n if directory is not empty an exception is thrown");
	}

	public static void helpTree() {
		System.out.println("command: tree\n  print all directories unde current directory\n"
				+ "tree path\n  print all directories unde path\n if directory not exist an excetion is thrown");
	}

	public static void helpFind() {
		System.out.println("comand: find string\n  recurency search for a file that contain string in name ");
	}

}
