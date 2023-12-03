package day3;

import java.util.Scanner;

public class EngineSchematicPartOne {
	
	final static int COLSIZE = 140;
	final static int ROWSIZE = 140;
	
	private static boolean isSymbol(char c)
	{
		return c != '.' && !(c >= 48 && c <= 57) ? true : false;
	}
	
	public static int calculate(char[][] input) {
		int result = 0;
		boolean isPartNumber;
		for(int r = 0; r < ROWSIZE; r++)
		{
			for(int c = 0; c < COLSIZE; c++)
			{
				String num = "";
				isPartNumber = false;
				while(input[r][c] >= 48 && input[r][c] <= 57)
				{
					num += input[r][c];
					if(!isPartNumber)
					{
						if(r == 0)
						{
							if(c == 0)
							{
								if(isSymbol(input[r][c+1]) || isSymbol(input[r+1][c]) || isSymbol(input[r+1][c+1]))
									isPartNumber = true;
							}
							else
							{
								if(isSymbol(input[r][c-1]) || isSymbol(input[r][c+1]) || isSymbol(input[r+1][c]) || isSymbol(input[r+1][c+1]) || isSymbol(input[r+1][c-1]))
									isPartNumber = true;
							}
						}
						else if(c == 0)
						{
							if(isSymbol(input[r-1][c]) || isSymbol(input[r][c+1]) || isSymbol(input[r+1][c]) || isSymbol(input[r+1][c+1]) || isSymbol(input[r-1][c+1]))
								isPartNumber = true;
						}
						else if (c == COLSIZE - 1)
						{
							if(r == ROWSIZE - 1)
							{
								if(isSymbol(input[r][c - 1]) || isSymbol(input[r - 1][c]) || isSymbol(input[r - 1][c - 1]))
									isPartNumber = true;
							}
							else
							{
								if(isSymbol(input[r][c-1]) || isSymbol(input[r-1][c]) || isSymbol(input[r+1][c]) || isSymbol(input[r - 1][c - 1]) || isSymbol(input[r + 1][c - 1]))
									isPartNumber = true;
							}
						}
						else if(r == ROWSIZE - 1)
						{
							if(isSymbol(input[r][c-1]) || isSymbol(input[r-1][c]) || isSymbol(input[r][c+1]) || isSymbol(input[r - 1][c+1]) || isSymbol(input[r - 1][c-1]))
								isPartNumber = true;
						}
						else
						{
							if(isSymbol(input[r][c-1]) || isSymbol(input[r-1][c]) || isSymbol(input[r][c+1]) || isSymbol(input[r+1][c]) || isSymbol(input[r - 1][c+1]) || isSymbol(input[r - 1][c-1]) || isSymbol(input[r + 1][c+1]) || isSymbol(input[r + 1][c-1]))
								isPartNumber = true;
						}
					}
					
					if(c == ROWSIZE - 1 || !(input[r][c + 1] >= 48 && input[r][c + 1] <= 57))
					{
						if(isPartNumber)
						{
							result += Integer.parseInt(num);
						}
						break;
					}
					c++;
				}	
			}
		}
		return result;
	}
	
	public static char[][] getTwoDimArray(Scanner input) {
		int row = 0;
		char[][] myArr = new char[ROWSIZE][];
		String line;
		
		while(input.hasNextLine()) {
			line input.nextLine();
			myArr[row] = new char[COLSIZE];
			for(int i = 0; i < line.length(); i++)
			{
				myArr[row][i] = line.charAt(i);
			}
			row++;
		}
		return myArr;
	}
	
	public static int findSumOfPartNumbers(Scanner input) {
		char[][] myArr;
		
		myArr = getTwoDimArray(input);
		
		return calculate(myArr);
		
	}
}
