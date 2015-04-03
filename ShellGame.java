/**
 * @(#)ShellGame.java
 *
 *
 * @Derick Warshaw // Lab 5 // COSC1337
 * @version 1.00 2014/2/27
 */

import javax.swing.JOptionPane; // to display using message dialogue box
import java.text.DecimalFormat; // to format message dialogue box
import java.util.Random; 		// for generating random number

public class ShellGame
{

    public static void main(String[] args)
    {
    	// variable initializations here
    	String ShellInput;
    	int shell = 0;
    	int game = 1;
    	int hideStone = 0;
    	int wins = 0;
    	int losses = 0;
    	double winnings = 0;

    	// create decimal format object for use with purse values
		DecimalFormat formatter = new DecimalFormat("#0.00");

    	// welcome dialogue box for Welcome to Shell Game
		JOptionPane.showMessageDialog(null, "Welcome to the Shell Game " +
			                                "\n  Press OK to Continue");

		// loop that allows the game to be played 5 times
		while (game <= 5)
		{

			// create random object
			Random rNumber = new Random();

			// get random integer and assign it to stone
			hideStone = rNumber.nextInt(3) + 1;

			// get input from user and store selection in ShellInput
			ShellInput = JOptionPane.showInputDialog(
			"Which shell is the stone under?\n" +
	    	"  /   \\         /   \\        /   \\\n" +
	    	" /     \\       /     \\      /     \\\n" +
	    	"/   1  \\    /   2  \\    /   3   \\\n");

			// parsing string input from JOptionPane to an int to store in shell
			shell = Integer.parseInt(ShellInput);

			// verify that the user enters a valid number to choose shell
			while (shell < 1 || shell > 3)
			{
				JOptionPane.showMessageDialog(null,"Please choose shell 1, 2 " +
					                               "or 3.");

				// get input from user and store selection in ShellInput
				ShellInput = JOptionPane.showInputDialog(
				"Which shell is the stone under?\n" +
	    		"  /   \\         /   \\        /   \\\n" +
	    		" /     \\       /     \\      /     \\\n" +
	    		"/   1  \\    /   2  \\    /   3   \\\n");

				// parsing string input from JOptionPane to int
				shell = Integer.parseInt(ShellInput);
			}

         	////////////////////////////////////////////////////////////////////
    		// if the user CORRECTLY guesses which shell the stone is under
    		////////////////////////////////////////////////////////////////////

			if (shell == hideStone)
			{

				JOptionPane.showMessageDialog(null,"You picked the correct" +
					                               " shell!");

				// increment game
				game++;

				// increment wins
				wins++;

				// user wins $1.00
				winnings+= 1.0;

			}

			////////////////////////////////////////////////////////////////////
    		// if the user INCORRECTLY guesses which shell the stone is under
    		////////////////////////////////////////////////////////////////////

			else if (shell != hideStone)
			{
				JOptionPane.showMessageDialog(null,"You picked the wrong" +
					                               " shell!");

				// increment game
				game++;

				// increment losses
				losses++;

				// user loses $2.00
				winnings-= 2.0;

			}


		}

		// display the score screen with wins and losses
		JOptionPane.showMessageDialog(null,"Thank you for playing!\n" +
			                               "This is your record:\n\n"  + wins +
			                               " wins and " + losses + " losses\n");

		// if the winnings value was positive
		if (winnings > 0)
		{

			JOptionPane.showMessageDialog(null, "You won $" +
			                                  formatter.format(winnings) + "!");

		}

		// if the winnings value was negative
		if (winnings < 0)
		{

			JOptionPane.showMessageDialog(null, "You owe $" +
			                                  formatter.format(winnings * - 1) +
			                                    "!\nBetter luck next time!");
		}

        System.exit(0);
    }


}