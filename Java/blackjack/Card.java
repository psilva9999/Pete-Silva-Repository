package blackjack;

import java.awt.Font;
import java.awt.*;
import java.util.HashSet;
import java.util.LinkedList;

public class Card {

	private int index;	 
	private int number;	 // 1 --> 13 - used to find name
	private int value;
	private boolean ace; // used to check if ace
	private String cardChar; // ♠	♥	♦	♣	
	private String name;
	
	public Card(int index) {
		this.index = index;
		this.number = index % 13 + 1;
		if(number>10) {
			this.value = 10;
		}
		if(number==1) {
			value = 11;
			ace = true;
		}
		setFaceUp(index);
		
	}
	
	private void setFaceUp(int index) {
		String[][] deck = new String[4][13];
		System.out.println(deck[0][0]);
		func(73);
		String[] cards = {	"🂡","🂱","🃁","🃑",
							"🂢","🂲","🃂","🃒",
							"🂣","🂳","🃃","🃓",
							"🂤","🂴","🃄","🃔",
							"🂥","🂵","🃅","🃕",
							"🂦","🂶","🃆","🃖",
							"🂧","🂷","🃇","🃗",
							"🂨","🂸","🃈","🃘",
							"🂩","🂹","🃉","🃙",
							"🂪","🂺","🃊","🃚",
							"🂫","🂻","🃋","🃛",
							"🂭","🂽","🃍","🃝",
							"🂮","🂾","🃎","🃞"};
		// index = 0 - 51, every 4 should go into the index
//		for(int i = 0; i<51; ++i) {
//			deck[i%4][13%(i)]=cards[i];
//		}
//		String[] orderedDeck = new String[52];
//		int w = 0;
//		for(int i = 0; i<4; ++i) {
//			for(int j = 0; j<13; ++j) {
//				orderedDeck[w] = deck[i][j];
//				System.out.println(orderedDeck[w]);
//			}
//		}
	
		
	}
	
	private void func(int n) {
		if(n>0) {
			func(n/5);
			System.out.print(n % 5);
		}
	}
	
	
	public boolean checkAce() {
		return ace;
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card newCard = new Card(1);
//		Card[] deck = new Card[52];
//		for(int i = 0; i<52; ++i) {
//			deck[i]= new Card(i);
//			//System.out.print(deck[i].index+"	"+deck[i].number);
//			//System.out.println();
//		}
	}

}
