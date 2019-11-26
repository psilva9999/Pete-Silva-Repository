package blackjack;

public class Card {
	private int value;
	private int number;
	private boolean ace;
	private String suit;
	private int numInDeck;
	
	public Card(int numberInDeck) {
		numInDeck=numberInDeck;
		if (numberInDeck<14) {suit="♦"; number=numberInDeck;}
		if (numberInDeck>13&&numberInDeck<27) {suit="♥"; number-=13;}
		if (numberInDeck>26&&numberInDeck<40) {suit="♣"; number-=26;}
		if (numberInDeck>39) {suit="♠"; number-=39;}
		if (number>1&&number<10) {value=number;}
		if (number==1) {ace=true; value=11;}
		if (number>9) {value=10;}
	}
	public int getNumInDeck() {return numInDeck;}
	public int getLowAceValue() {
		if(ace) return 1;
		else return value;
	}
	public int getValue() {return value;}
	public int getNumber() {return number;}
	public String getSuit() {return suit;}
	public String toString() {
		if(number==1) return "A"+suit;
		if(number==11) return "J"+suit;
		if(number==12) return "Q"+suit;
		if(number==13) return "K"+suit;
		return number+suit;
	}
}
