/**
 * File: Deck.java
 * Author: Vasiki Konneh
 * Date: 09/10/2019
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Collections;

public class Deck{
	ArrayList <Card> myDeck;

	//builds deck
	public Deck(){
		build();

	} 

	//builds a deck of 52 cards, 4 each of cards with values 2-9 and 11,
	// and 16 cards with the value 10. 
	public void build(){
		myDeck = new ArrayList<Card>();
		for(int i=0;i<12; i++){

			//if x is between 2 and 9 or is 11
			if((2<=i && i<=9) || i==11 ){
				Card card1 = new Card(i); 
				Card card2 = new Card(i);
				Card card3 = new Card(i);
				Card card4 = new Card(i);
			
				myDeck.add(card1);
				myDeck.add(card2);
				myDeck.add(card3);
				myDeck.add(card4);
			}

			else if(i==10){
				for(int j=0; j<16; j++){
					Card card0 = new Card(i);
					myDeck.add(card0);
				}
			}

		}
	} 
	
	//returns the number of cards in the deck.
	public int size(){
		return myDeck.size();
	} 
	
	//returns the top card (position zero) and removes it from the deck.
	public Card deal(){
		return myDeck.remove(0);
	} 
	
	//(optional) returns the card at position i and removes it from the deck.
	public Card pick(int i){
		return myDeck.remove(i);

	} 

	//shuffles deck
	//pick randomly from first deck, put in second deck
	public void shuffle(){
		ArrayList<Card> shuffled = new ArrayList<Card>();
		Random g = new Random();
		
		for(int i=0; i<myDeck.size(); i++){
			//create random number that represent the index
			int index = g.nextInt(52);
			shuffled.add(myDeck.get(index));
			// myDeck.remove(index);
		}
		myDeck.clear();
		myDeck = shuffled;
	}
	
	//returns a String that has the contents of the deck "written" in a nice format (so that you can see the ordering of the card values).
	String string = "";
	public String toString(){
		for(int i=0; i<myDeck.size(); i++){
			string += "[" + myDeck.get(i).getValue() + "]";
		}
	return string;
	}


	public static void main(String[] args){
		Deck deck = new Deck();

		deck.shuffle();
		System.out.println("Shuffled deck: " + deck.toString() + "\n" + "its size: " + deck.size());
		System.out.println("\n");

		System.out.println("original deck: " + deck.toString() + "\n" + "its size: " + deck.size());
		System.out.println("\n");

		deck.deal();
		System.out.println("1st item removed: " + deck.toString() + "\n" + "its size: " + deck.size());
		System.out.println("\n");

		deck.pick(5);
		System.out.println("5th idex removed: " + deck.toString() + "\n" + "its size: " + deck.size());
		System.out.println("\n");
			
	} 
}