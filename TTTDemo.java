import java.util.Scanner;

//Tic-Tac-Toe Demo 
public class TTTDemo
{
	public static void main(String[] args) //main
	{
		Scanner input =new Scanner(System.in);
		TicTacToe g=new TicTacToe();//g is the game
		char newGame;
		char p='O';//p is player
		int r=0;//r is row
		int c=0;//c is column

		System.out.println("Welcome to the game!"); //greeting

		do //go through
		{
			g.board();
			System.out.println("\nTic Tac Toe\n");

			System.out.println("Player 1 is X"); //player X
			System.out.println("Player 2 is O"); //player O
			
			g.showBoard(); //showtheboeard
			System.out.println();

			while(true)
			{
				p=g.switchP(p);
				System.out.println("\nNow \""+p+"\" make your move."); //player move
				System.out.print("Enter the row: "); //x
				r=input.nextInt();
				System.out.print("Enter the column: "); //y x+y=position
				c=input.nextInt();

				while (g.checkBoard(r,c))
				{
					System.out.println("\nThis space has already been selected. Please enter a different row or column to select a new spot.");//aspace is taken
					g.showBoard();
					System.out.print("Row: ");
					r=input.nextInt();
					System.out.print("Column: ");
					c=input.nextInt();
				}

				g.updateBoard(p, r, c); //show player update board/available&unavailable spaces 
				g.showBoard();

				if(g.winningBoard()) //winningboard
				{
					System.out.println("\nThe winner is "+p+"!"); //name winner
					g.updateBoard(p, r, c); //update to last board winningboard
					g.showBoard(); //show the win/winning board
					break; //stop
				}

				if(g.scratch()) //if a tie
				{ 
					System.out.println("\nThere is no winner. The game is a scratch.");
					g.updateBoard(p, r, c); //update to last
					g.showBoard(); //show the tie on the board
					break; //stop loop
				}  
			}

			System.out.println("\nIf you would like to play again type \"y\" otherwise enter any key to exit."); //newgame?yes/exit
			newGame = input.next().toLowerCase().charAt(0); //if yes=new game
		}

		while(newGame == 'y'); //user wants to continue playing

		System.out.println("Thanks for playing!");
	}
}


