package blackjack;

import java.awt.Color;
import java.awt.Font;

import sedgewick.StdDraw;

public class Cards {

	/**  
	 * @return an array of integers assending from 1 to 52 times (1 time for each suit)
	 */
	public static Card[] newDeck(){		
		Card[] deck = new Card [52];
		for (int i = 0; i<52; ++i) {
			deck[i]= new Card(i);
		}
		return deck;
	}
	
	/**
	 * @return an randomized version of newDeck()
	 */
	public static Card[] shuffleDeck() {
		Card [] deck = newDeck();
		for (int i = 0; i<52; ++i) {
			int c = (int)(Math.random()*(i+1));
			Card t = deck[i];
			deck[i]=deck[c];
			deck[c]=t;
		}
		return deck;
	}
	
	/**
	 * 
	 * @param deckCardVal value of the card. Should be between 1 and 52 inclusively
	 * @param x center x value
	 * @param y center y value
	 */
	public static void faceUp(int deckCardVal, double x, double y) {
		String cardSuit=""; 
		int suitCardVal = deckCardVal;
		if (deckCardVal<14) {
			cardSuit="♦"; StdDraw.setPenColor(Color.RED); 
		}
		if (deckCardVal>13&&deckCardVal<27) {
			cardSuit="♥"; StdDraw.setPenColor(Color.RED); suitCardVal-=13;
		}
		if (deckCardVal>26&&deckCardVal<40) {
			cardSuit="♣"; StdDraw.setPenColor(Color.BLACK); suitCardVal-=26;
		}
		if (deckCardVal>39) {
			cardSuit="♠"; StdDraw.setPenColor(Color.BLACK); suitCardVal-=39;
		}
		
		Font f = new Font("Roman", Font.ROMAN_BASELINE, 50);
		StdDraw.setFont(f);
		String v = ""+suitCardVal;
		String s = cardSuit;
		if (suitCardVal==1) v = "A"; 
		if (suitCardVal==11) v = "J";
		if (suitCardVal==12) v = "Q";
		if (suitCardVal==13) v = "K";
//		double r=0.1;
		if (suitCardVal==1) StdDraw.text(x, y, s);
		if (suitCardVal==2) {
			StdDraw.text(x, y-0.7, s);
			StdDraw.text(x, y+0.7, s);
		}
		if (suitCardVal==3) {
			StdDraw.text(x, y, s);
			StdDraw.text(x, y-0.7, s);
			StdDraw.text(x, y+0.7, s);
		}
		if (suitCardVal==4) {
			StdDraw.text(x+.35, y-0.7, s);
			StdDraw.text(x+.35, y+0.7, s);
			StdDraw.text(x-.35, y-0.7, s);
			StdDraw.text(x-.35, y+0.7, s);
		}
		if (suitCardVal==5) {
			StdDraw.text(x, y, s);
			StdDraw.text(x+.35, y-0.7, s);
			StdDraw.text(x+.35, y+0.7, s);
			StdDraw.text(x-.35, y-0.7, s);
			StdDraw.text(x-.35, y+0.7, s);
		}
		if (suitCardVal==6) {
			StdDraw.text(x+.35, y, s);
			StdDraw.text(x+.35, y-0.7, s);
			StdDraw.text(x+.35, y+0.7, s);
			StdDraw.text(x-.35, y, s);
			StdDraw.text(x-.35, y-0.7, s);
			StdDraw.text(x-.35, y+0.7, s);
		}
		if (suitCardVal==7) {
			StdDraw.text(x, y, s);
			StdDraw.text(x+.5, y, s);
			StdDraw.text(x+.25, y-0.7, s);
			StdDraw.text(x+.25, y+0.7, s);
			StdDraw.text(x-.5, y, s);
			StdDraw.text(x-.25, y-0.7, s);
			StdDraw.text(x-.25, y+0.7, s);
		}
		if (suitCardVal==8) {
			StdDraw.text(x+.4, y+(1.0/3.0), s);
			StdDraw.text(x+.4, y-1, s);
			StdDraw.text(x+.4, y+1, s);
			StdDraw.text(x+.4, y-(1.0/3.0), s);
			StdDraw.text(x-.4, y+(1.0/3.0), s);
			StdDraw.text(x-.4, y-1, s);
			StdDraw.text(x-.4, y+1, s);
			StdDraw.text(x-.4, y-(1.0/3.0), s);
		}
		if (suitCardVal==9) {
			StdDraw.text(x, y, s);
			StdDraw.text(x+.4, y+(1.0/3.0), s);
			StdDraw.text(x+.4, y-1, s);
			StdDraw.text(x+.4, y+1, s);
			StdDraw.text(x+.4, y-(1.0/3.0), s);
			StdDraw.text(x-.4, y+(1.0/3.0), s);
			StdDraw.text(x-.4, y-1, s);
			StdDraw.text(x-.4, y+1, s);
			StdDraw.text(x-.4, y-(1.0/3.0), s);
		}
		if (suitCardVal==10) {
			StdDraw.text(x, y-(2.0/3.0), s);
			StdDraw.text(x, y+(2.0/3.0), s);
			StdDraw.text(x+.4, y+(1.0/3.0), s);
			StdDraw.text(x+.4, y-1, s);
			StdDraw.text(x+.4, y+1, s);
			StdDraw.text(x+.4, y-(1.0/3.0), s);
			StdDraw.text(x-.4, y+(1.0/3.0), s);
			StdDraw.text(x-.4, y-1, s);
			StdDraw.text(x-.4, y+1, s);
			StdDraw.text(x-.4, y-(1.0/3.0), s);
		}
		if (suitCardVal==11) {
			f = new Font("Roman", Font.ROMAN_BASELINE, 150);
			StdDraw.setFont(f);
			StdDraw.text(x, y, "J");
		}
		if (suitCardVal==12) {
			f = new Font("Roman", Font.ROMAN_BASELINE, 150);
			StdDraw.setFont(f);
			StdDraw.text(x, y, "Q");
		}
		if (suitCardVal==13) {
			f = new Font("Roman", Font.ROMAN_BASELINE, 150);
			StdDraw.setFont(f);
			StdDraw.text(x, y, "K");
		}

		f = new Font("Roman", Font.ROMAN_BASELINE, 35);
		StdDraw.setFont(f);
		StdDraw.rectangle(x, y, .9, 1.75);
		if(suitCardVal<14&&suitCardVal!=10) {
			StdDraw.text(x+.75, y+1.45, v);
			StdDraw.text(x-.75, y-1.55, v);
			f = new Font("Roman", Font.ROMAN_BASELINE, 25);
			StdDraw.setFont(f);
			StdDraw.text(x+.75, y+1.1, s);
			StdDraw.text(x-.75, y-1.2, s);
		}
		if(suitCardVal==10) {
			StdDraw.text(x+.7, y+1.45, v);
			StdDraw.text(x-.7, y-1.55, v);
			f = new Font("Roman", Font.ROMAN_BASELINE, 25);
			StdDraw.setFont(f);
			StdDraw.text(x+.7, y+1.1, s);
			StdDraw.text(x-.7, y-1.2, s);
		}
		StdDraw.setPenColor(Color.BLACK);
	}
	
	/**
	 * 
	 * @param cardVal the value of the card in the deck (1-52)
	 * @return the power of the card (aces = 11, 10 J Q K = 10, all else = itself
	 */
	public static int cardPow(int deckCardVal) {
		int cardPow = deckCardVal;
		if (deckCardVal>13&&deckCardVal<27) cardPow-=13;
		if (deckCardVal>26&&deckCardVal<40) cardPow-=26;
		if (deckCardVal>39) cardPow-=39;
		if (deckCardVal==1) cardPow = 11;
		if (deckCardVal>9) cardPow = 10;
		return cardPow;
	}
	
	
	/**
	 * 
	 * @param x x coordinate
	 * @param y y coordinate
	 */
	public static void faceDown(double x, double y) {
		StdDraw.rectangle(x, y, .9, 1.75);
		StdDraw.rectangle(x, y, 0.8, 1.6);
		StdDraw.setPenColor(Color.BLUE);
		cardBack(x-0.8, y-1.6, 1.6);
		StdDraw.setPenColor(Color.black);
	}
	
	public static void defaultCanvas(int gameNum, int wins, double balance, int minBet) {
		StdDraw.clear();
		changeFontSize(10);
		StdDraw.text(-3.6, 3.8, ("Game: " + gameNum));
		StdDraw.text(-3.65, 3.65, ("Wins: " + wins));
		StdDraw.text(-3.5, 3.5, ("Minimum Bet: "+ minBet+" chips"));
		changeFontSize(20);
		StdDraw.text(3.5, 3.5, ("Balance: "+ balance));
	}
	
	public static void changeFontSize(int fontSize) {
		Font f = new Font("Roman", Font.ROMAN_BASELINE, fontSize);
		StdDraw.setFont(f);
	}
	
	
	/**
	 * 
	 * @param llx lower left x value 
	 * @param lly lower left y value
	 * @param w width (height will be 2x the width)
	 */
	public static void cardBack(double llx, double lly, double w) {	
		double l=2*w;
		double d = Math.sqrt(Math.pow(w, 2)+Math.pow(l, 2));
		if (w < .05) return;
		else {
			StdDraw.line(llx, lly,llx+w, lly+l);
			StdDraw.line(llx, lly+l,llx+w, lly);
		}
		StdDraw.show(0);
		cardBack(llx+w/2.0, lly, w/2.0);
		cardBack(llx, lly, w/2.0);
		cardBack(llx+w/2.0, lly+w, w/2.0);
		cardBack(llx, lly+w, w/2.0);
	}
	
	public static void main(String[] args) {
		StdDraw.setCanvasSize(1000, 750);
		StdDraw.setXscale(-4, 4);
		StdDraw.setYscale(-4, 4);
		Card [] deck = shuffleDeck();
		faceUp(deck[0].getNumber(), 1, -2);
		faceUp(deck[1].getNumber(), -1, -2);
		faceUp(deck[2].getNumber(), -1, 2);
		faceDown(1, 2);
	}

}
