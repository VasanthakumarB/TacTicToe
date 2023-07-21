package p1;

import java.util.Random;
import java.util.Scanner;

public class TicTacToe {
	// TODO Auto-generated method stub
	public static void printBoard(char c[][]) {
		System.out.println(" " + c[0][0] + " | " + c[0][1] + " | " + c[0][2]);
		System.out.println("---|---|---");
		System.out.println(" " + c[1][0] + " | " + c[1][1] + " | " + c[1][2]);
		System.out.println("---|---|---");
		System.out.println(" " + c[2][0] + " | " + c[2][1] + " | " + c[2][2]);
		System.out.println("---|---|---");
	}

	public static boolean playerTurn1(char board[][], Scanner sc, char sympol) {
		System.out.println("Enter the Move (1-9) or 0-Quit:");
		int p1;
		while (true) {
			p1 = sc.nextInt();
			if (p1 == 0)
				return true;
			if (ValidMove(board, p1)) {
				break;
			} else {
				System.out.println("Enter the Valid Move :");
			}
		}
		System.out.println("Player "+sympol+" Move :" + p1);
		placeMove(board, p1, sympol);
		printBoard(board);
		return false;
	}

	public static boolean ValidMove(char board[][], int p) {
		switch (p) {
		case 1:
			return board[0][0] == '1';
		case 2:
			return board[0][1] == '2';
		case 3:
			return board[0][2] == '3';
		case 4:
			return board[1][0] == '4';
		case 5:
			return board[1][1] == '5';
		case 6:
			return board[1][2] == '6';
		case 7:
			return board[2][0] == '7';
		case 8:
			return board[2][1] == '8';
		case 9:
			return board[2][2] == '9';
		default:
			return false;
		}
	}

	public static void placeMove(char board[][], int p, char sympol) {
		switch (p) {
		case 1:
			board[0][0] = sympol;
			break;
		case 2:
			board[0][1] = sympol;
			break;
		case 3:
			board[0][2] = sympol;
			break;
		case 4:
			board[1][0] = sympol;
			break;
		case 5:
			board[1][1] = sympol;
			break;
		case 6:
			board[1][2] = sympol;
			break;
		case 7:
			board[2][0] = sympol;
			break;
		case 8:
			board[2][1] = sympol;
			break;
		case 9:
			board[2][2] = sympol;
			break;
		}
	}

	public static boolean winningMove(char board[][],char sympol){
		boolean b=false;
		if((board[0][0]==sympol && board[0][1]==sympol &&board[0][2]==sympol)||
			(board[1][0]==sympol&&board[1][1]==sympol&&board[1][2]==sympol)||
			(board[2][0]==sympol&&board[2][1]==sympol&&board[2][2]==sympol)||
			(board[0][0]==sympol&&board[1][1]==sympol&&board[2][2]==sympol)||
			(board[2][0]==sympol&&board[1][1]==sympol&&board[0][2]==sympol)||
			(board[0][0]==sympol&&board[1][0]==sympol&&board[2][0]==sympol)||
			(board[0][1]==sympol&&board[1][1]==sympol&&board[2][1]==sympol)||
			(board[0][2]==sympol&&board[1][2]==sympol&&board[2][2]==sympol)){
			System.out.println("Yay Player "+sympol+"  is Won ");
			b=true;
		}else{
			b=false;
		}
		return b;
	}
	public static boolean playerTurn2(char board[][],Scanner sc,char sympol){
		System.out.println("Enter the Player 2 (1-9) 0-Quit");
		int p2;
		while(true){
			p2=sc.nextInt();
			if(p2==0)return true;
			if(ValidMove(board,p2)){break;
			}else{
				System.out.println("Enter the Player 2 (1-9) 0-Quit");
			}
		}
		System.out.println("Player "+sympol+" Move :"+p2);
		placeMove(board,p2,sympol);
		printBoard(board);
		return false;
	}
	public static void makeMove(char board[][],Scanner sc){
		int count=0;
		while(true){
			if(playerTurn1(board,sc,'X'))break;
			if(winningMove(board,'X'))break;
			if(gameDie(board)) break;
			computerMove(board);
			if(winningMove(board,'O'))break;
			if(gameDie(board))break;
		}
	}
	public static void computerMove(char board[][]){
		int com;
		Random r=new Random();
		while(true){
		int temp,temp1,temp2;
		com=r.nextInt(9)+1;
		temp=WinMove(board,'O');//is a computer winning Move
		temp1=BlockMove(board,'X');
		temp2=trickyMove(board);
		if(temp!=-1)com=temp;
		else if(temp1!=-1)com=temp1;
		else if(temp2!=-1)com=temp2;
		if(ValidMove(board,com))break;
		}
		System.out.println("Computer Move:"+com);
		placeMove(board,com,'O');
		printBoard(board);
		}
	public static int WinMove(char[][] board, char symbol) {
		if(board[0][0]==symbol && board[0][1]==symbol && board[0][2]=='3') 		return 3;
		else if(board[0][0]==symbol && board[0][2]==symbol && board[0][1]=='2') return 2;
		else if(board[0][1]==symbol && board[0][2]==symbol && board[0][0]=='1')	return 1;
		
		else if(board[1][0]==symbol && board[1][1]==symbol && board[1][2]=='6') return 6;
		else if(board[1][0]==symbol && board[1][2]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[1][2]==symbol && board[1][0]=='4')	return 4;
		
		else if(board[2][0]==symbol && board[2][1]==symbol && board[2][2]=='9') return 9;
		else if(board[2][0]==symbol && board[2][2]==symbol && board[2][1]=='8') return 8;
		else if(board[2][1]==symbol && board[2][2]==symbol && board[2][0]=='7')	return 7;
		
		else if(board[0][0]==symbol && board[1][0]==symbol && board[2][0]=='7') return 7;
		else if(board[0][0]==symbol && board[2][0]==symbol && board[1][0]=='4') return 4;
		else if(board[1][0]==symbol && board[2][0]==symbol && board[0][0]=='1') return 1;
		
		else if(board[0][1]==symbol && board[1][1]==symbol && board[2][1]=='8') return 8;
		else if(board[0][1]==symbol && board[2][1]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[2][1]==symbol && board[0][1]=='2') return 2;
		
		else if(board[0][2]==symbol && board[1][2]==symbol && board[2][2]=='9') return 9;
		else if(board[0][2]==symbol && board[2][2]==symbol && board[1][2]=='6') return 6;
		else if(board[1][2]==symbol && board[2][2]==symbol && board[0][2]=='3') return 3;
		
		else if(board[0][0]==symbol && board[1][1]==symbol && board[2][2]=='9') return 9;
		else if(board[0][0]==symbol && board[2][2]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[2][2]==symbol && board[0][0]=='1') return 1;
		
		else if(board[0][2]==symbol && board[1][1]==symbol && board[2][0]=='7') return 7;
		else if(board[0][2]==symbol && board[2][0]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[2][0]==symbol && board[0][2]=='3') return 3;
		else return -1;
	}

	public static int trickyMove(char board[][]){
		if(board[1][1]=='5') return 5;
		else if(board[2][0]=='7') return 7;
		else if(board[2][2]=='9') return 9;
		else if(board[0][2]=='3') return 3;
		else if(board[0][0]=='1') return 1;
		else if(board[0][1]=='2') return 2;
		else if(board[1][0]=='4') return 4;
		else if(board[1][2]=='6') return 6;
		else if(board[2][1]=='8') return 8;
		else return -1;
	}
	public static int BlockMove(char board[][],char symbol){
		if(board[0][0]==symbol && board[0][1]==symbol && board[0][2]=='3') 		return 3;
		else if(board[0][0]==symbol && board[0][2]==symbol && board[0][1]=='2') return 2;
		else if(board[0][1]==symbol && board[0][2]==symbol && board[0][0]=='1')	return 1;
		
		else if(board[1][0]==symbol && board[1][1]==symbol && board[1][2]=='6') return 6;
		else if(board[1][0]==symbol && board[1][2]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[1][2]==symbol && board[1][0]=='4')	return 4;
		
		else if(board[2][0]==symbol && board[2][1]==symbol && board[2][2]=='9') return 9;
		else if(board[2][0]==symbol && board[2][2]==symbol && board[2][1]=='8') return 8;
		else if(board[2][1]==symbol && board[2][2]==symbol && board[2][0]=='7')	return 7;
		
		else if(board[0][0]==symbol && board[1][0]==symbol && board[2][0]=='7') return 7;
		else if(board[0][0]==symbol && board[2][0]==symbol && board[1][0]=='4') return 4;
		else if(board[1][0]==symbol && board[2][0]==symbol && board[0][0]=='1') return 1;
		
		else if(board[0][1]==symbol && board[1][1]==symbol && board[2][1]=='8') return 8;
		else if(board[0][1]==symbol && board[2][1]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[2][1]==symbol && board[0][1]=='2') return 2;
		
		else if(board[0][2]==symbol && board[1][2]==symbol && board[2][2]=='9') return 9;
		else if(board[0][2]==symbol && board[2][2]==symbol && board[1][2]=='6') return 6;
		else if(board[1][2]==symbol && board[2][2]==symbol && board[0][2]=='3') return 3;
		
		else if(board[0][0]==symbol && board[1][1]==symbol && board[2][2]=='9') return 9;
		else if(board[0][0]==symbol && board[2][2]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[2][2]==symbol && board[0][0]=='1') return 1;
		
		else if(board[0][2]==symbol && board[1][1]==symbol && board[2][0]=='7') return 7;
		else if(board[0][2]==symbol && board[2][0]==symbol && board[1][1]=='5') return 5;
		else if(board[1][1]==symbol && board[2][0]==symbol && board[0][2]=='3') return 3;
		else if(board[0][0]==symbol && board[2][2]==symbol && board[1][2]=='6') return 6;
		else return -1;
	}
	public static boolean gameDie(char board[][]){
		if((board[0][0]!='1')&&(board[0][1]!='2')&&(board[0][2]!='3')
				&& board[1][0]!='4'&& board[1][1]!='5'&& board[1][2]!='6'
				&& board[2][0]!='7'&& board[2][1]!='8'&& board[2][2]!='9'){
			System.out.println("Game Die...");
			return true;
		}else{
			return false;
		}
	}
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out
					.println("Choose Option:\n1.Player to Player\n2.Player to Computer");
			int n = sc.nextInt();
			if (n == 1) {
				String s="";
				do {
					char board[][] = { { '1', '2', '3' }, { '4', '5', '6' },
							{ '7', '8', '9' } };
					printBoard(board);
					while (true) {
						if (playerTurn1(board, sc, 'X'))
							break;
						if (winningMove(board, 'X'))
							break;
						if(gameDie(board))
							break;
						if (playerTurn2(board, sc, 'O'))
							break;
						if (winningMove(board, 'O'))
							break;
						if(gameDie(board))
							break;
					}
					System.out.println("Are you Play Again (Y)es or (N)o");
					s=sc.next();
				} while (s.equalsIgnoreCase("y"));
				System.out.println("Thank you for Playing");
				break;
			} else if (n == 2) {
				String s;
				do{
					char board[][] = { { '1', '2', '3' }, { '4', '5', '6' },
							{ '7', '8', '9' } };
					printBoard(board);
					int count=0;
					printBoard(board);
					makeMove(board,sc);
					System.out.println("Are you Play Again (Y)es or (N)o");
					s=sc.next();
				}while(s.equalsIgnoreCase("y"));
				System.out.println("Thank you for Playing..");
				break;
			}else{
				System.out.println("Please Enter 1 or 2 ");
			}
		}
	}
}