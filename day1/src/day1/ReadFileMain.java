package day1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ReadFileMain {
	
	public static boolean isLowercaseLetter(char letter) {
		if((int)letter >= 97 && (int)letter <= 122)
			return true;
		else
			return false;
	}
	
	public static String appendNumericVal(String input) {
		//i know it is now the best way :( tried every way i could
		input = input.replaceAll("one+", "on1e");
		input = input.replaceAll("two+", "tw2o");
		input = input.replaceAll("three+", "thr3ee");
		input = input.replaceAll("four+", "fo4ur");
		input = input.replaceAll("five+", "fi5ve");
		input = input.replaceAll("six+", "si6x");
		input = input.replaceAll("seven+", "se7ven");
		input = input.replaceAll("eight+", "ei8ght");
		input = input.replaceAll("nine+", "ni9ne");
		return input;
	}
	
	public static void main(String[] args) {
		try {
			boolean foundTens;
			int tens, ones, total = 0;
			char letter;
		    File input = new File("input.txt");
		    Scanner inputReader = new Scanner(input);
		    
		    while (inputReader.hasNextLine()) {
		    	tens = 0;
		    	ones = 0;
		    	foundTens = false;
		    	String data = inputReader.nextLine();
		    	data = appendNumericVal(data);
		    	
		        for(int i = 0; i < data.length(); i++)
		        {
		        	letter = data.charAt(i);
		        	if(!isLowercaseLetter(letter))
		        	{
		        		if(!foundTens)
		        		{
		        			tens = Character.getNumericValue(letter);
		        			ones = Character.getNumericValue(letter);
		        			foundTens = true;
		        		}
		        		else
		        			ones = Character.getNumericValue(letter);
		        	}
		        }
		        
		        total += 10*tens + ones;
		        System.out.println("Line '" + data + "'\nResult: " + (10*tens + ones));
		      }
		    
		    System.out.println(total);
		    inputReader.close();
		    } catch (FileNotFoundException e) {
		    	System.out.println("An error occurred.");
		    	e.printStackTrace();
		    }
		
		
	}
}
