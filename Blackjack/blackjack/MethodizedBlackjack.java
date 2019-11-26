package blackjack;

import cse131.ArgsProcessor;

public class MethodizedBlackjack {

	private Player p;
	private int totalPlayers;
	private ArgsProcessor ap;
	private double minBet;
	
	public static void main(String[] args) {
		ArgsProcessor ap = new ArgsProcessor(args);
		Player p = new Player("Pete", 100, ap);
		MethodizedBlackjack MGMGrand = new MethodizedBlackjack(p, 0, 5, ap);
		MGMGrand.play(p);
	}
	
	public MethodizedBlackjack(Player p, int otherGamblers, double minBet, ArgsProcessor ap) {
		this.p=p;
		this.totalPlayers=otherGamblers+2;
		this.ap=ap;
		this.minBet=minBet;
	}
	
	public void play(Player p) {
		while(!turn(p));
		return;
	}
	
	public boolean turn(Player p) {
		if(p.getBalance()<minBet) return true;
		Card ace = new Card(1);
		Card ten = new Card(10);
		p.addCard(ace);
		p.addCard(ten);
		System.out.println(p.getBalance());;
		p.placeBet(minBet);
		System.out.println(p.getCards());
		p.checkBlackjack();
		System.out.println("You got blackjack?: "+p.checkBlackjack());
		p.finishRound(false, true);
		System.out.println(p.getBalance());
		return true;
		
		
		
		//return false;
	}
	
	
	
	
}
