package day4;

import java.util.ArrayList;
import java.util.Scanner;

public class FlashCardsPartOne {
	static final int WINNINGNUMSSIZE = 10;
	static final int HASNUMSSIZE = 25;
	
	static ArrayList<int[]> winningNums = new ArrayList<int[]>();
	static ArrayList<int[]> hasNums = new ArrayList<int[]>();
	
	private static void readFromFile(Scanner input) {
		int col;
		
		while(input.hasNextLine())
		{
			input.findInLine("Card\s+\\d+:");
			
			// get winning nums
			int[] winningNumsArr = new int[WINNINGNUMSSIZE];
			col = 0;
			while(input.hasNextInt())
			{
				winningNumsArr[col++] = input.nextInt();
//				System.out.println("myArr" + winningNumsArr[col - 1]);
			}
			winningNums.add(winningNumsArr);
			
			input.next();
			
			// get has nums
			col = 0;
			int[] hasNumsArr = new int[HASNUMSSIZE];
			while(input.hasNextInt())
			{
				hasNumsArr[col++] = input.nextInt();
//				System.out.println("hasnumarr" + hasNumsArr[col-1]);
			}
			hasNums.add(hasNumsArr);
			
			if(input.hasNextLine())
				input.skip("\\R");
		}
	}
	
	private static boolean existsInArr(int[] arr, int num) {
		for(int i = 0; i < arr.length; i++)
		{
			if(arr[i] == num)
				return true;
		}
		return false;
	}
	
	private static double calculate() {
		int result = 0;
		for(int i = 0; i < hasNums.size(); i++)
		{
			double lineWorth = 0.5;
			int[] hasNumsArr = hasNums.get(i);
			int[] winningNumsArr = winningNums.get(i);
			
			for(int num: hasNumsArr)
			{
				if(existsInArr(winningNumsArr, num))
				{
					lineWorth *= 2;
//					System.out.println("Found " + num);
				}
			}
			
			result += lineWorth;
		}
		return result;
	}
	
	public static int calculateTotalPoints(Scanner input)
	{
		readFromFile(input);
		int result = (int)calculate();
		
		return result;
	}
	
}
