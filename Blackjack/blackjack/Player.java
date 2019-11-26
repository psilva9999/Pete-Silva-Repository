package blackjack;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import cse131.ArgsProcessor;

public class Player {
	private String name;
	private double balance;
	private double stake;
	private ArgsProcessor ap;
	private int numCards;
	private TreeMap<Integer, Card> cards;
	private boolean blackjack;

	public Player(String name , double balance, ArgsProcessor ap) {
		this.name=name;
		this.balance=balance;
		this.cards=new TreeMap<Integer, Card>();
		this.stake=0;
		this.ap=ap;
		this.numCards=0;

	}
	public String getName() {return name;}
	public double getBalance() {return balance;}
	public double getStake() {return stake;}
	public int getNumCards() {return numCards;}
	public TreeMap<Integer, Card> getCards(){return cards;}
	
	public void addCard(Card card) {
		cards.put(card.getNumInDeck(), card);
		++numCards;
	}
	public int getSTDTotal() {
		int sum = 0;
		for(int c: this.cards.keySet()) {
			Card card = new Card(c);
			sum+=card.getValue();
		}
		return sum;
	}
	public boolean placeBet(double minBet) {
		double amount = ap.nextDouble("How much do you wish to bet?");
		if(amount>balance||amount<minBet) return false;
		else {
			stake=amount;
			balance-=amount;
			return true;
		}
	}
	public void finishRound(boolean push, boolean win) {
		if(push) {balance+=stake;}
		else {if(win){balance+=2*stake;}}
		numCards=0;
		cards=new TreeMap<Integer, Card>();
	}
	public boolean checkBlackjack() {
		if(this.getSTDTotal()==21) {
			return true;
		}
		else return false;
	}
	public boolean checkPossDouble(int prevBet) {
		if(prevBet>balance) return false;
		else return true;
	}



}
