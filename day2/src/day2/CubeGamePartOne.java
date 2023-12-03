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
				return false;
			}
		}
		return true;
	}
	
	public static boolean isPossibleForCubes(String reveal) {
		String[] cubes = reveal.split(",");
		for(String cube : cubes) {
			int num = Integer.parseInt(cube.replaceAll("[\\D]", ""));
			if(cube.contains("red") && num > 12)
			{
				return false;
			}
			else if(cube.contains("green") && num > 13)
			{
				return false;
			}
			else if(num > 14)
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
			
			while(inputReader.hasNextLine())
			{
				ArrayList<String> revealsList = new ArrayList<String>();
				String line = inputReader.nextLine();
				
				String[] reveals = line.split(":|;");
				for(String reveal : reveals)
				{
					revealsList.add(reveal);
				}
				
				if(isPossibleForGame(revealsList))
					result += Integer.parseInt(revealsList.get(0).replaceAll("[\\D]", ""));
			}
			
			System.out.println("Total: " + result);
			inputReader.close();
		} catch (FileNotFoundException e) {
			System.out.println("File not found.");
			e.printStackTrace();
		}
	}

}
