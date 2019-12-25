/**
 * File: Simulation.java
 * Author: Vasiki Konneh
 * Date: 09/10/2019
 */

public class Simulation{

public static void main(String[] args) {
	
	int dW = 0;
	int pW = 0;
	int tie = 0;
	for(int i=0; i<1000; i++){
		Blackjack bj = new Blackjack();
		// bj.reset(true);
		bj.playerTurn(); 
		bj.dealerTurn();
		bj.game(true);
		if(bj.game(true) == 0){tie++;}
		if(bj.game(true) == 1){pW++;}
		if(bj.game(true) == -1){dW++;}
		// System.out.println("---End Game---"+"\n");
	}
	System.out.println("Ties: " + tie +". "+ "Percentage: " + (tie/10.0) + "%" + "\n" + 
		"Player's Wins: " + pW + ". "+ "Percentage: " + (pW/10.0) + "%" + "\n" + 
		"Dealer's Wins: " + dW + ". "+ "Percentage: " + (dW/10.0) + "%" );
	
}
}