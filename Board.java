

import java.util.*;
import java.text.*;

public class Board {  

	private int numMoves;
	private String[] board = new String[10];
	
	//Main method
    public Board()
    {
       numMoves = 0;
    }
    
    public boolean processGuess(String guess, String code)
    {
    	String result = "";
    	String guessCopy = guess;
    	String codeCopy = code;
    	for (int pos = 0; pos < 4; pos++)
    	{
    		if (guess.charAt(pos) == code.charAt(pos))
    		{
    			result = result + 'P';
    			code = code.substring(0,pos) + 'X' +
    				code.substring(pos+1);
    			guess = guess.substring(0,pos) + 'X' +
    				guess.substring(pos+1);
    		}
    	}
    	for (int pos = 0; pos < 4; pos++)
    	{
    		int loc = code.indexOf(guess.charAt(pos));
    		if (loc != -1 && (guess.charAt(pos) != 'X'))
    		{
    			result = result + 'C';
    			code = code.substring(0,loc) + 'X' +
    				code.substring(loc+1);
    		}
    		else if (guess.charAt(pos) != 'X')
    		{
    			result = result + " ";
    		}
    	}
    	char[] resultCode = result.toCharArray();
    	Arrays.sort(resultCode);
    	result = new String(resultCode);
    
    	if (result.equals("PPPP"))
    		return true;
    		else
    		return false;
    	}
    	
    	public void printBoard()
    	{
    		for (int row = 0; row < numMoves; row++) 
    		{
				for (int col = 0; col < 4; col++)
				 {
					System.out.print(board[row] + col + " ");
    		   	 }
    	    }
    	}
    
    	public int getCount()
    	{
    		return numMoves;
    	}
    	
    	public String getPlayerGuess(Scanner input)
    	{	
    	    String answer = input.nextLine();
    		return answer;
    	}
}
