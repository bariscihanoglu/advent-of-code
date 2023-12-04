package day3;

import java.util.ArrayList;
import java.util.Scanner;

class Symbol {
	ArrayList<Integer> adjacentNums = new ArrayList<Integer>();
	int row;
	int col;
	
	public Symbol(int row, int col) {
		this.row = row;
		this.col = col;
	}
	
	public void addAdjacentNum(int num) {
		adjacentNums.add(num);
	}
	
	public String toString() {
		return "Symbol at row: " + row + " and col: "+ col;
	}
}

public class EngineSchematicPartTwo {
	final static int COLSIZE = 140;
	final static int ROWSIZE = 140;
	static char[][] arr = new char[ROWSIZE][];
	static ArrayList<Symbol> gears = new ArrayList<Symbol>();
	
	private static void setTwoDimArray(Scanner input) {
		int row = 0;
		String line;
		
		while(input.hasNextLine()) {
			line = input.nextLine();
			arr[row] = new char[COLSIZE];
			for(int i = 0; i < line.length(); i++)
			{
				arr[row][i] = line.charAt(i);
			}
			row++;
		}
	}
	
	private static boolean isNum(char c)
	{
		return (c >= 48 && c <= 57) ? true : false;
	}
	
	private static boolean isSymbol(char c)
	{
		return c == '*' ? true : false;
	}
	
	private static boolean isGear(Symbol s) {
		int cntNum = 0;
		if(isNum(arr[s.row - 1][s.col - 1]))
		{
			cntNum++;
			if(!isNum(arr[s.row - 1][s.col]) && isNum(arr[s.row - 1][s.col + 1]))
			{
				cntNum++;
			}
		}
		
		
		
		if(cntNum == 2)
		{
			System.out.println(s.toString());
			return true;
		}
			
		else
		{
			System.out.println(s.toString() + " " + cntNum);
			return false;
		}
	}
	
	public static void findGears() {
		for(int r = 0; r < ROWSIZE; r++)
		{
			for(int c = 0; c < COLSIZE; c++)
			{
				if(isSymbol(arr[r][c]))
				{
					Symbol s = new Symbol(r, c);
					if(isGear(s))
					{
						gears.add(s);
					}
				}
			}
		}
	}
	
	public static void findSumGears(Scanner input)
	{
		setTwoDimArray(input);
		findGears();
		
		System.out.println(gears);
	}
	
}
