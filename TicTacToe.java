import java.util.Scanner;
import java.util.Arrays;

public class TicTacToe
{
	private char[][] b=new char[4][4];//b is the board array

	//initializes board and makes the array row 1-3 empty and column 1-3 empty
	public void board()
	{
		for(int r=1;r<4;r++) 
		{
			for(int c=1;c<4;c++) 
			{
				b[r][c]=(' ');
			}
		}
	}

	//switches players after each turn
	public char switchP(char p)//p is player
	{
		char t;//t is the turn

		t=('X');

		if(p==('O'))
		
			t=('X');
		
		if(p==('X'))
		
			t=('O');

		return t;
	}

	//outputs the array that is the board
	public void showBoard()
	{
		System.out.println();
		System.out.println("1 "+b[1][1]+" |"+b[1][2]+"|"+b[1][3]);
	    System.out.println("  --+-+--");
	    System.out.println("2 "+b[2][1]+" |"+b[2][2]+"|"+b[2][3]);
	    System.out.println("  --+-+--");
	    System.out.println("3 "+b[3][1]+" |"+b[3][2]+"|"+b[3][3]);
	    System.out.println("  1  2  3 ");
	}

	//changes space in the array board after each turn to the new one
	public void updateBoard(char p,int r,int c)//p is player, r is row, c is column
	{
		b[r][c]=p;
	}
	
	//checks to see if the space on the board has been selected
	public boolean checkBoard(int r,int c)
	{
		if((r>4||c>4)||(r<1||c<1))
			return true;
		else if(b[r][c]=='X'||b[r][c]=='O')
			return true;
			return false;
	}

	//checks different combinations of the array being filled to see if the user has won
	public boolean winningBoard() //put it the "0" winning board -- you already have the if "X" winning board
	{
		if(b[1][1]==b[1][2]&&b[1][2]==b[1][3]&&(b[1][1]==('X')||b[1][1]==('O'))) //if(b[1][1]==b[1][2]&&b[1][2]==b[1][3]&&(b[1][1]==('X')
			return true;
		else if(b[1][1]==b[2][1]&&b[2][1]==b[3][1]&&(b[1][1]==('X')||b[1][1]==('O'))) //code the winning board for "O"--row 1
				return true;
		else if(b[1][1]==b[2][2]&&b[2][2]==b[3][3]&&(b[1][1]==('X')||b[1][1]==('O'))) //code the winning board for "O"--row 2
			return true;
		else if(b[1][2]==b[2][2]&&b[2][2]==b[3][2]&&(b[1][2]==('X')||b[1][2]==('O'))) //code the winning board for "O"--row3
			return true; 
		else if(b[1][3]==b[2][3]&&b[2][2]==b[3][3]&&(b[1][3]==('X')||b[1][3]==('O'))) //code the winning board for "O"
			return true;
		else if(b[2][1]==b[2][2]&&b[2][2]==b[2][3]&&(b[2][1]==('X')||b[2][1]==('O'))) //code the winning board for "O"
			return true;
		else if(b[3][1]==b[3][2]&&b[3][2]==b[3][3]&&(b[3][1]==('X')||b[3][1]==('O'))) //code the winning board for "O"
			return true;
		else if(b[3][1]==b[2][2]&&b[2][2]==b[1][3]&&(b[3][1]==('X')||b[3][1]==('O'))) //code the winning board for "O"
			return true;
		else
			return false;
	}

	
	//checks to see if there is a draw
	public boolean scratch()
	{
		for(int r=1;r<4;r++)
		{
			for(int c=1;c<4;c++)
			{
				if(b[r][c]==(' '))
					return false;
			}
		}
		return true;
	}
}

//add/check winning boards