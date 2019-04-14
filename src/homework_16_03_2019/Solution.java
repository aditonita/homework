package homework_16_03_2019;

import java.nio.file.Paths;
import java.util.*;

public class Solution {

	static String currentPath;

	public static void main(String[] args) {
		String commandLine = null;
		String[] commandArgs;
		String command = "";
		Scanner sc = new Scanner(System.in);
		currentPath = Paths.get("").toAbsolutePath().toString();
		System.out.println("type exit for exit\n help for commands accepted\n");
		while (!command.equals("exit")) {
			System.out.print(currentPath + "$");
			commandLine = sc.nextLine();
			commandArgs = commandLine.split(" ");
			if (commandArgs.length > 0) {
				command = commandArgs[0];
			}

			switch (command) {
			case "dir":
				if (commandArgs.length == 1) {
					ShellCommands.dir(currentPath);
				}
				if (commandArgs.length == 2) {
					ShellCommands.dir(commandArgs[1]);
				}
				if (commandArgs.length > 2) {
					ShellHelp.helpDir("More than one argument type \"man help\"");
				}
				break;
			case "cd":
				if (commandArgs.length == 2) {
					currentPath = ShellCommands.cd(commandArgs[1], currentPath);
				} else {
					System.out.println("invalid argument, for help type man cd");
				}
				break;
			case "cp":
				if (commandArgs.length == 3) {
					String target = ShellCommands.cp(commandArgs[1], commandArgs[2]);
					System.out.println(target);
				} else {
					System.out.println("invalid argument, for help type man cp");
				}
				break;
			case "mkdir":
				if (commandArgs.length == 2) {
					System.out.println(ShellCommands.mkdir(commandArgs[1]));
				} else {
					System.out.println("invalid argument, for help type man mkdir");
				}
				break;
			case "mv":
				if (commandArgs.length == 3) {
					System.out.println(ShellCommands.mv(commandArgs[1], commandArgs[2]));
				} else {
					System.out.println("invalid argument, for help type man mv");
				}
				break;
			case "cat":
				if (commandArgs.length == 2) {
					ShellCommands.cat(commandArgs[1]);
				} else {
					System.out.println("invalid argument, for help type man cat");
				}
				break;
			case "rm":
				if (commandArgs.length == 2) {
					ShellCommands.rm(commandArgs[1]);
				} else {
					System.out.println("invalid argument, for help type man rm");
				}
				break;
			case "tree":
				switch (commandArgs.length) {
				case 1:
					ShellCommands.tree(currentPath);
					break;
				case 2:
					ShellCommands.tree(commandArgs[1]);
					break;
				default:
					System.out.println("invalid argument, for help type man tree");
				}
				break;
			case "find":
				if (commandArgs.length == 2) {
					ShellCommands.find(commandArgs[1], currentPath);
				} else {
					System.out.println("invalid argument, for help type man find");
				}
				break;
			case "help":
				ShellHelp.help();
				break;
			case "man":
				if (commandArgs.length == 2) {
					switch (commandArgs[1]) {
					case "dir":
						ShellHelp.helpDir();
						break;
					case "cd":
						ShellHelp.helpCd();
						break;
					case "cp":
						ShellHelp.helpCp();
						break;
					case "mkdir":
						ShellHelp.helpMkdir();
						break;
					case "mv":
						ShellHelp.helpMv();
						break;
					case "cat":
						ShellHelp.helpCat();
						break;
					case "rm":
						ShellHelp.helpRm();
						break;
					case "tree":
						ShellHelp.helpTree();
						break;
					case "find":
						ShellHelp.helpFind();
						break;
					}
				} else {
					ShellHelp.help();
				}
				break;
			case "exit":
				break;
			default:
				System.out.println("type help");
			}
		}
	}

}
