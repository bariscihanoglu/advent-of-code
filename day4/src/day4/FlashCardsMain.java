package day4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FlashCardsMain {

	public static void main(String[] args) {
		File input = new File("input.txt");
		try {
			Scanner sc = new Scanner(input);
			FlashCardsPartOne.calculateTotalPoints(sc);
		} catch (FileNotFoundException e) {
			System.out.println("File not found!");
		}

	}

}
