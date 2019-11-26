package blackjack;

import java.awt.Color;
import java.awt.Font;

import cse131.ArgsProcessor;
import sedgewick.StdDraw;

public class BlackJack {
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(1000, 750);
		StdDraw.setXscale(-4, 4);
		StdDraw.setYscale(-4, 4);
		
		
		
		ArgsProcessor ap = new ArgsProcessor(args);
		
		Font f = new Font("Roman", Font.ROMAN_BASELINE, 70);
		StdDraw.setFont(f);
//		StdDraw.text(0, 0, "WELCOME TO BLACKJACK!");
//		System.out.println("Welcome to Blackjack!");

		StdDraw.show(2000);
		StdDraw.clear();
		Cards.changeFontSize(45);
		StdDraw.text(0, 0, "What is your name?");
		StdDraw.show(2000);
		String name = "Peter";//ap.nextString("What is your name?");
		StdDraw.clear();
		Cards.changeFontSize(30);
		StdDraw.text(0, 0, "How many other players are there at the table?");
		StdDraw.show(2000);
		int playerTotal = 2;//ap.nextInt("How many other players are there at the table?")+2;
		String tbl = "";
		if (playerTotal == 2) tbl = name + " is the only person at the table";
		if (playerTotal == 3) tbl = name + " is at the table with one other person";
		if (playerTotal > 3) tbl = name + " is playing with " + (playerTotal-2)+ " other people at the table";
		StdDraw.clear();
		StdDraw.text(0, 0, tbl);
		StdDraw.show(2000);
		StdDraw.clear();
		StdDraw.text(0, 0, "How much money do you wish to start with?");
		StdDraw.show(2000);
		double balance = 500;//ap.nextDouble("How much money do you wish to start with? (enter dollar amount)");
		
		if (balance<5) {
			StdDraw.clear();
			StdDraw.text(0, 0, "You must be able to afford the table minimum of 5 chips.");
		}
		while (balance<5) {
			balance = ap.nextDouble("Please enter a valid starting balance.");
		}

		int totalCards = 52;
		int[][] player = new int [playerTotal][totalCards];
				// player[][0] = player number (output value)
				// player[n][] = player number (array value)
				// player[n][1] = player n's first card (deckValue)
				// player[n][2] = player n's second card (deckValue)
				// player[n][3] = player n's count (suitValue)
				// player[n][e] = any future cards that player n may ask for
				// player[n][49] = does player n have blackjack (0 or 1)
				// player[n][50] = is it possible for the player to choose double (0 or 1)
		for (int i=0; i<playerTotal; ++i) {
			player[i][0]=i;
		}
		StdDraw.clear();
		StdDraw.text(0, 1.5, "Your balance is " + balance + " dollars");
		//System.out.println("Your balance is " + balance + " dollars");
		//System.out.println("There are " + (playerTotal-2) + " autonomous players playing.");

		StdDraw.show(3000);
		StdDraw.clear();
		
		int gameNum = 0;
		int wins = 0;
		int minBet = 5;
		Cards.defaultCanvas(gameNum+1, wins, balance, minBet);

		Card[] shuffledCards = Cards.shuffleDeck();

		int i=0;
		while (balance>=minBet) {
			gameNum=i+1;

			// making each player
			for (int k=0; k<playerTotal; ++k) {
				player[k][49]=0;
			}

			// starting up the game
			System.out.println();
			System.out.println("Game " + gameNum);
			System.out.println("Your balance is: "+balance);
			Cards.defaultCanvas(gameNum, wins, balance, minBet);
			Cards.changeFontSize(30);
			StdDraw.text(0, 0, "How much do you wish to bet?");
			StdDraw.show(500);
			int bet = ap.nextInt("How much do you wish to bet?");
//			
//			while (bet<minBet||bet>balance) {
//				if (bet<minBet) {
//					String betMin = ap.nextString("You must bet the table minimum of 5 chips in order to play. Do you wish to continue to play?(yes or no?)");
//					if (betMin.equals("no")||betMin.equals("No")) {
//						balance = 0;
//						System.out.println(name+" failed to bet the table minimum and has left the table");
//						break;
//					}
//					bet = minBet;
//				}
//				if (bet>balance) {
//					int betTooHigh = ap.nextInt("You do not have enough chips in your balance to place this bet. Please enter a bet that you can afford.");
//					bet = betTooHigh;
//				}
//			}
			balance -=bet;
			Cards.defaultCanvas(gameNum, wins, balance, minBet);
			Cards.changeFontSize(30);
			StdDraw.text(0, 0, "You chose to bet "+bet+" chips");
			//System.out.println("You chose to bet "+bet+" chips");
			StdDraw.show(500);
			
			shuffledCards=Cards.shuffleDeck();

			// initial deal
			int q = 0;
			for (int v=1; v<3; ++v) {
				for (int z=0; z<playerTotal;++z) {
					player[z][v]=shuffledCards[q].getNumber();
					++q;
				}
			}
			Cards.defaultCanvas(gameNum, wins, balance, minBet);
			Cards.changeFontSize(20);
			StdDraw.text(0, -4, (name+"'s Cards"));
			Cards.faceUp(player[1][2], 1, -2);
			Cards.faceUp(player[1][1], -1, -2);
			Cards.changeFontSize(20);
			StdDraw.text(0, 4, "Dealer's Cards");
			Cards.faceUp(player[0][1], -1, 2);
			Cards.faceDown(1, 2);
			
			StdDraw.pause(2000);
			StdDraw.clear();
			for (int z=0; z<playerTotal; ++z) {
				player[z][3] = Cards.cardPow(player[z][1])+Cards.cardPow(player[z][2]);
			}

			System.out.println("The Dealer's face-up card has the value of: "+Cards.cardPow(player[0][1]));
			if (player[0][3]==21) {
				if (Cards.cardPow(player[0][1])==10 || Cards.cardPow(player[0][1])==11) {
					System.out.println("   Dealer checks for Blackjack...");
					System.out.println("       Dealer has Blackjack. Dealer beats all players!");
				}
			}
			else {
				if (Cards.cardPow(player[0][1])==10) {
					System.out.println("   Dealer checks for Blackjack...");
					System.out.println("       Dealer does not have Blackjack");
				}
				if (Cards.cardPow(player[1][3])==21) {
					System.out.println("Your cards have values of:  "+Cards.cardPow(player[1][1])+" and "+Cards.cardPow(player[1][2]));
					System.out.println("    You got Blackjack!");
					player[1][49]=1;
				}
				else {
					System.out.println("Your cards have values of:  "+Cards.cardPow(player[1][1])+" and "+Cards.cardPow(player[1][2]));
					System.out.println("    Your count is:  "+player[1][3]);
				}
				for (int s=2;s<playerTotal;++s) {
					System.out.println("Player "+s+"'s cards have values of:  "+Cards.cardPow(player[s][1])+" and "+Cards.cardPow(player[s][2]));
					System.out.println("   Player "+s+"'s count is:  "+player[s][3]);
				}
				System.out.println();
				String hit = "";
				int e = 4;
				int stand=0;
				//incorporating double
				if (balance>=2*bet) {
					player[1][50]=1;
				}
				//incorporating split
				//	if (player[1][1]==player[1][2]) {
				//	player[1][50]=2;
				//	}
				while (stand<1) {
					if (player[1][3]<21) {
						if (player[1][50]==1) {
							hit = ap.nextString("Your count is: "+player[1][3]+" Do you want to double, hit, or stand? (type either double, hit or stand)");
							if (hit.equals("hit")||hit.equals("Hit")||hit.equals("h")||hit.equals("H")) {
								player[1][e]=shuffledCards[q].getNumber();
								System.out.println("You chose to hit!");
								System.out.println("     Your new card has a value of "+Cards.cardPow(player[1][e]));
								player[1][3]=player[1][3]+Cards.cardPow(player[1][e]);
								System.out.println("     Your count is now: "+player[1][3]);
								++q;
								++e;
								hit="";
								stand = 0;
								player[1][50]=0;
							}
							if (hit.equals("Stand")||hit.equals("stand")||hit.equals("s")||hit.equals("S")) {
								System.out.println("You chose to stand!");
								System.out.println("    Your count remains at: "+player[1][3]);
								stand = 1;
							} 
							if (hit.equals("Double")||hit.equals("double")||hit.equals("d")||hit.equals("D")) {
								player[1][e]=shuffledCards[q].getNumber();
								System.out.println("You chose to double!");
								System.out.println("     Your new card has a value of "+player[1][e]);
								player[1][3]=player[1][3]+player[1][e];
								System.out.println("     Your count is now: "+player[1][3]);
								++q;
								++e;
								stand = 1;
								bet = 2*bet;
							}
						}
						if (player[1][50]==0) {
							hit = ap.nextString("Your count is: "+player[1][3]+" Do you want to hit or stand? (type either hit or stand)");
							if (hit.equals("hit")||hit.equals("Hit")||hit.equals("h")||hit.equals("H")) {
								player[1][e]=shuffledCards[q].getNumber();
								System.out.println("You chose to hit!");
								System.out.println("     Your new card has a value of "+Cards.cardPow(player[1][e]));
								player[1][3]=player[1][3]+Cards.cardPow(player[1][e]);
								System.out.println("     Your count is now: "+player[1][3]);
								++q;
								++e;
								hit="";
								stand = 0;
							}
							if (hit.equals("Stand")||hit.equals("stand")||hit.equals("s")||hit.equals("S")) {
								System.out.println("You chose to stand!");
								System.out.println("    Your count remains at: "+player[1][3]);
								stand = 1;
							} 
						}
					}
					if (player[1][3]>=21) {
						stand = 1;
					}
				}
				for (int k=0; k<playerTotal; ++k) {
					e = 4;
					if (k!=1) {
						if (player[k][3]==21) {
							player[k][49] = 1;
						}
						else {
							while (player[k][3]<17) {
								player[k][e]=shuffledCards[q].getNumber();
								player[k][3]=player[k][3]+player[k][e];
								if (k!=0) {
									System.out.println("Player "+player[k][0]+" chose to hit and has a new card with the value "+Cards.cardPow(player[k][e]));
									System.out.println("    Player "+player[k][0]+"'s count is now: "+player[k][3]);
								}
								if (k==0) {
									System.out.println("The Dealer's hits and has a new card with the value "+Cards.cardPow(player[k][e]));
									System.out.println("    The Dealer's count is now: "+player[k][3]);
								}
								++q;
								++e;
							}
						}
					}
				}
				System.out.println();
				// results
				for (int k=0; k<playerTotal; ++k) {
					if (k==0) {
						if (player[k][3]>21) {
							System.out.println("The Dealer busts! "+ player[k][3]);
							player[k][3]=0;
						}
						else {
							System.out.println("The Dealer got "+player[k][3]);
						}
					}
					if (k==1) {
						if (player[k][49]==1) {
							System.out.println(name+" got Blackjack! (21)");
							System.out.println("    "+name+" beats the Dealer!");
							++wins;
							balance = balance + (double)2.5*bet;
						}
						else {
							if (player[k][3]>21) {										//LOSS
								System.out.println(name+" busts! "+player[k][3]);
								balance = balance;
							}
							else {
								System.out.println(name+" got "+player[k][3]);
								if (player[k][3]>player[0][3]&&player[0][3]!=0) {		//WIN
									System.out.println("    "+name+" beats the Dealer!");
									++wins;
									balance = balance + 2*bet;
								}
								if (player[k][3]==player[0][3]) {						//PUSH
									System.out.println("    "+name+" pushes with "+player[k][3]);
									balance = balance+bet;
								}
								if (player[0][3]==0) {									//WIN
									System.out.println("    the Dealer busts! "+name+" beats the dealer");
									++wins;
									balance = balance + 2*bet;
								}
								if (player[k][3]<player[0][3]) {						//LOSS
									System.out.println("    the Dealer beats "+name);
									balance = balance;
								}
							}
						}
					}
					if (k!=0&&k!=1) {
						if (player[k][3]>22) {
							System.out.println("Player " +player[k][0]+" busts! "+player[k][3]);
						}
						else {
							if (player[k][49]==1) {
								System.out.println("Player " +player[k][0]+" got Blackjack! (21)");
								System.out.println("    Player "+player[k][0]+" beat the dealer!");
							}
							else {
								System.out.println("Player " +player[k][0]+" got "+player[k][3]);
								if (player[k][3]>player[0][3]) {
									System.out.println("    Player "+player[k][0]+" beats the Dealer!");

								}
								if (player[k][3]==player[0][3]) {
									System.out.println("    Player "+player[k][3]+" pushes with "+player[k][3]);
								}
								if (player[k][3]<22&&player[0][3]>21) {
									System.out.println("    the Dealer busts! Player "+player[k][0]+" beats the dealer");
								}
								if (player[k][3]<player[0][3]) {
									System.out.println("    the Dealer beats Player "+player[k][0]);
								}
							}
						}

					}
				}
			}
			if (balance<minBet) {
				System.out.println(name+ " is out of chips and has left the table");
				break;
			}
			String update = ap.nextString("Your balance is "+balance+". Do you wish to play again? (yes or no)");
			if (update.equals("Yes")||update.equals("yes")||update.equals("y")){

			}
			else {
				System.out.println();
				System.out.println(name+" has left the table with "+balance+" chips");
				break;
			}
			++i;
		}
		double humanWins = (double)(1.0*wins)/(1.0*gameNum);
		System.out.println("The fraction of human wins was "+humanWins);
	}


}
