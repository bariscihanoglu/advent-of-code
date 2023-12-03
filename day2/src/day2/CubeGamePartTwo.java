package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CubeGamePartTwo {
	
	public static void PartTwo() {
		File input = new File("input.txt");
		try {
			Scanner inputReader = new Scanner(input);
			int result = 0;
			String line;
			
			while(inputReader.hasNextLine())
			{
				ArrayList<String> revealsList = new ArrayList<String>();
				line = inputReader.nextLine();
				
				System.out.println(line);
				
				String[] reveals = line.split(":|;");
				for(String reveal : reveals)
				{
					revealsList.add(reveal);
				}
				
				
				// Integer.parseInt([STRING].replaceAll("[\\D]", ""));
				
				
				System.out.println("Total: " + result);
			}
			inputReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}

}
