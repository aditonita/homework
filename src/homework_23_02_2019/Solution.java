package homework_23_02_2019;

import java.io.*;
import java.io.IOException;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String line;
		String[] client;
		
		try (BufferedReader br = new BufferedReader(new FileReader("..\\homework\\src\\homework_23_02_2019\\clients.txt"))) {
			while ((line = br.readLine()) != null) {
				//System.out.println(line);
				client = line.split("[|\\s+]");
				for(String data: client) {
					//System.out.print(data);
				}
					//System.out.println();
			}
		} catch (IOException e) {
			e.getStackTrace();
		}
	}

}
