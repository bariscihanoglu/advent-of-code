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
				int r = 1, g = 1, b = 1;
				ArrayList<String> revealsList = new ArrayList<String>();
				line = inputReader.nextLine();
				
				System.out.println(line);
				
				String[] reveals = line.split(":|;");
				for(String reveal : reveals)
				{
					revealsList.add(reveal);
					//System.out.println("RevealsList '" + revealsList + "'");
				}
				
				for(int i = 1; i < reveals.length; i++) {
					String[] reveal = reveals[i].split(",");
					for(int j = 0; j < reveal.length; j++) {
						if(reveal[j].contains("red") && Integer.parseInt(reveal[j].replaceAll("[\\D]", "")) > r) {
							r = Integer.parseInt(reveal[j].replaceAll("[\\D]", ""));
						}
						else if(reveal[j].contains("green") && Integer.parseInt(reveal[j].replaceAll("[\\D]", "")) > g) {
							g = Integer.parseInt(reveal[j].replaceAll("[\\D]", ""));
						}
						else if(reveal[j].contains("blue") && Integer.parseInt(reveal[j].replaceAll("[\\D]", "")) > b) {
							b = Integer.parseInt(reveal[j].replaceAll("[\\D]", ""));
						}
					}
				}
				result += r * g * b;
				
				System.out.println("Total: " + result);
			}
			inputReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}

}
