package day2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class CubeGamePartOne {

	public static boolean isPossibleForGame(ArrayList<String> revealsList) {
		for(int i = 1; i < revealsList.size(); i++)
		{
			if(!isPossibleForCubes(revealsList.get(i)))
			{
				System.out.println(revealsList.get(i) + " is not possible!");
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPossibleForCubes(String reveal) {
		String[] cubes = reveal.split(",");
		for(String cube : cubes) {
			if(cube.contains("red") && Integer.parseInt(cube.replaceAll("[\\D]", "")) > 12)
			{
				return false;
			}
			else if(cube.contains("green") && Integer.parseInt(cube.replaceAll("[\\D]", "")) > 13)
			{
				return false;
			}
			else if(Integer.parseInt(cube.replaceAll("[\\D]", "")) > 14)
			{
				return false;
			}
		}
		return true;
	}
	
	public static void PartOne() {
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
				
				if(isPossibleForGame(revealsList))
					result += Integer.parseInt(revealsList.get(0).replaceAll("[\\D]", ""));
				
				
				System.out.println("Total: " + result);
			}
			inputReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}

}
