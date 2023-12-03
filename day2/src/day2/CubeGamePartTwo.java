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
			
			while(inputReader.hasNextLine())
			{
				int r = 1, g = 1, b = 1;
				String line = inputReader.nextLine();
				
				String[] reveals = line.split(":|;");
				
				for(int i = 1; i < reveals.length; i++) {
					
					String[] reveal = reveals[i].split(",");
					
					for(int j = 0; j < reveal.length; j++) {
						int count = Integer.parseInt(reveal[j].replaceAll("[\\D]", ""));
						if(reveal[j].contains("red") && count > r) {
							r = count;
						}
						else if(reveal[j].contains("green") && count > g) {
							g = count;
						}
						else if(count > b) {
							b = count;
						}
					}
				}
				result += r * g * b;
			}
			System.out.println("Total: " + result);
			inputReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}

}
