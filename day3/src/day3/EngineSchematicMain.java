package day3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EngineSchematicMain {

	public static void main(String[] args) {
		File input = new File("input.txt");
		try {
			Scanner sc = new Scanner(input);
			
			System.out.println(EngineSchematicPartOne.findSumOfPartNumbers(sc));
			
		} catch (FileNotFoundException e) {
			System.out.println("File cannot found.");
			e.printStackTrace();
		}

	}

}
