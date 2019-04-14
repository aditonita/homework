package homework_16_03_2019;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.NotDirectoryException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;

public class ShellCommands {
	public static void dir(String path) {
		try {
			Files.list(Paths.get(path)).forEach(e -> System.out.println(e));
		} catch (NotDirectoryException e) {
			ShellHelp.helpDir("Path is not a directory type \"man dir\" for help");
		} catch (NoSuchFileException e) {
			ShellHelp.helpDir("Path does not exist type \"man dir\" for help");
			;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String cd(String path, String currentPath) {
		if(Files.isDirectory(Paths.get(path))) {
		return path;
		}else {
			ShellHelp.helpCd();
			return currentPath;
		}
		
	}

	public static String cp(String fromPath, String toPath) {
		try {
			return Files.copy(Paths.get(fromPath), Paths.get(toPath)).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "File not copied type \"man cp\" for help";
	}

	public static String mkdir(String path) {
		if(!Files.isDirectory(Paths.get(path))) {
		try {
			return Files.createDirectories(Paths.get(path)).toAbsolutePath().toString() + "   created";
		} catch (IOException e) {
			e.printStackTrace();
		}
		}else {
			return path + "   exist";
		}
		return path + "   not created type \"man mkdir\" for help";
	}

	public static String mv(String fromPath, String toPath) {
		try {
			return Files.move(Paths.get(fromPath), Paths.get(toPath)).toString();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fromPath + " not moved type \"man mv\" for help";
	}

	public static void cat(String path) {
		try {
			Files.lines(Paths.get(path)).forEach(l -> System.out.println(l));
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("file not exist type \"man cat\" for help");
		}
	}

	public static void rm(String path) {
		try {
			if(Files.deleteIfExists(Paths.get(path))) {
				System.out.println(path + " deleted");
			}else {
				System.out.println(path + " not exist. nothing to delete.");
			}
		} catch (IOException e) {
			System.out.println(path + " not deleted type \"man rm\" for help");
			e.printStackTrace();
		}
	}

	public static void tree(String path) {
		try {
			Files.walk(Paths.get(path)).forEach(e ->{if(e.toFile().isDirectory()) 
				                                     System.out.println(e.toAbsolutePath().toString());});
		} catch (IOException e) {
			System.out.println("for help type \"man tree\"");
			e.printStackTrace();
		}
	}

	public static void find(String string, String path) {
		try {
			Files.walk(Paths.get(path)).map(f -> {if(f.toFile().isFile()) return f.toAbsolutePath().toString();
			                                      return "";})
			                           .filter(e -> e.contains(string))
			                           .forEach(p -> System.out.println(p));
			                           
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
