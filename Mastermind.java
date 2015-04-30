import java.util.*;
import java.text.*;

public class Mastermind {  
	
    public static void main(String[] args) 
    {
       Board board = new Board();
       String code = generateCode();
       boolean gameover = false;
       Scanner input = new Scanner(System.in);
       String guess = board.getPlayerGuess(input);
       
       do{
       	guess = board.getPlayerGuess(input);
       	if (!(guess.equals("QUIT"))){
       		gameover = board.processGuess(guess, code );
       		board.printBoard();
       	}
       }while (!gameover && (board.getCount() < 10) && !guess.equals("QUIT"));
       
       if (gameover)
       	System.out.println("You guessed the code correctly in " + board.getCount() + "moves");
       	else if (guess.equals("QUIT"))
       		System.out.println("Please play again");
       	else
       		System.out.println("Sorry - too many guesses");
    }
   
	public static String generateCode()
	{
		Random gen = new Random();
		int num = 0;
		char[] secretCode = new char[4];
		String secretString = "" + secretCode;
		char[] colors = {'R','B','G','Y'};
		for(int x = 0; x < colors.length; x++)
		{ 
			num = gen.nextInt(4);
			secretCode[x] = colors[num];
			System.out.println(secretString);
		}
		return secretString;
      }
     
}//End
