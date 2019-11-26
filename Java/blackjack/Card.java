package blackjack;

import java.util.LinkedList;

public class Card {

	private int index;
	private int value;
	private String name;
	
	public Card(int index) {
		this.index = index;
		this.value = index % 13;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Card[] deck = new Card[52];
		for(int i = 0; i<52; ++i) {
			deck[i]= new Card(i);
		}
		System.out.print(1);
	}

}
