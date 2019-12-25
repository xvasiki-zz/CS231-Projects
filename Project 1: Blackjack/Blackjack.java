/**
 * File: Blackjack.java
 * Author: Vasiki Konneh
 * Date: 09/10/2019
 */


import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Collections;


public class Blackjack{
	Deck deck;
	Hand pHand;
	Hand dHand;
	//boolean newDeck = new boolean;

	public Blackjack(){
		this.deck = new Deck();
		this.pHand = new Hand();
		this.dHand = new Hand();
		this.reset(true);
	}

	public void reset(boolean newDeck){
		if(newDeck == true){ deck.build(); deck.shuffle();}
		else{ pHand.reset(); dHand.reset();}
	}

	public void deal(){
		// for(int i=0;i<2;i++){
			pHand.add(deck.deal());
			dHand.add(deck.deal());
		// }
	}

	public String toString(){
		String s = "";
		s+= "Player's hand totals to: " + pHand.size() + "\n" + "Dealer's hand totals to: " + dHand.size();
		return s;
	}

	//draws cards until at least 16, at most 21
	public boolean playerTurn(){
		int totHand = 0;
		for(int i=0; i<pHand.size(); i++){
			totHand += pHand.getCard(i).getValue();
		}

		Card drawnCard;

		while(totHand <= 16) {
			drawnCard = deck.deal();
			pHand.add(drawnCard);
			totHand += drawnCard.getValue();
			// System.out.println(totHand);
		}

		if(totHand <= 21){return true;}
		if(totHand > 21){
			// System.out.println("Dealer BUST!"); 
			return false;
		}
		return true;
	}

	public boolean dealerTurn(){
		int totHand = 0;
		for(int i=0;i<dHand.size();i++){
			totHand += dHand.getCard(i).getValue();
		}

		Card drawnCard;

		while(totHand <= 17) {
			drawnCard = deck.deal();
			dHand.add(drawnCard);
			totHand += drawnCard.getValue();
			// System.out.println(totHand);
		}

		if(totHand <= 21){return true;}
		if(totHand > 21){
			// System.out.println("Dealer BUST!"); 
			return false;
		}
		return true;
	}


	public int game(boolean verbose){
		
		boolean playBust = this.playerTurn();
		boolean dealBust = this.dealerTurn();

		int playerScore = 0;
		int dealerScore = 0;
		int game;
		// deal(); deal();

		
			// reset(true);
			// System.out.println("Final Player Hand: " + pHand.getTotalValue());
			// System.out.println("Final Dealer Hand: " + dHand.getTotalValue());
		

		for(int i=0; i<pHand.size();i++){
			playerScore+=pHand.getCard(i).getValue();
		}

		for(int i=0; i<dHand.size(); i++){
			dealerScore+=dHand.getCard(i).getValue();
		}

		if (playBust || dealBust) {
			if(playBust && dealBust){
				if(playerScore > dealerScore){
					game = 1;
					}
				else if(playerScore < dealerScore){
					game = -1;
					}
				else game = 0;
			}

			else if (playBust == true) {
				game = -1; 
			}
			else{ 
				game = 1; 
			}


		}

		else game = 0;


		if (game == 1 && verbose) {
			// System.out.println("The player won!");
			return 1;
		}

		else if (game ==-1 && verbose) {
			// System.out.println("The dealer won!");
			return -1;
		}

		else{
			if(verbose){
				// System.out.println("It's a tie!");
			}
			return 0;
		}
}

	public static void main(String[] args){
		
		
		for(int i=0; i<3; i++){
			System.out.println("---Start Game---");
			Blackjack bj = new Blackjack();
			System.out.println("player drawing");
			bj.playerTurn(); 
			System.out.println("dealer drawing");
			bj.dealerTurn();
			bj.game(true);
			System.out.println("---End Game---"+"\n");
			
		}
		
	}
	}
