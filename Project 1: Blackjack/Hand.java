/**
 * File: Hand.java
 * Author: Vasiki Konneh
 * Date: 09/10/2019
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Collections;


public class Hand{ 
	private ArrayList<Card> myHand;


	//initialize the ArrayList.
	public Hand(){ 
		this.myHand = new ArrayList<Card>();
	}

	//reset the hand to empty.
	public void reset(){ 
		for(int i=0; i< myHand.size(); i++){
			myHand.remove(i);
		}
	} 

	//add the card object to the hand.
	public void add(Card card){ 
		myHand.add(card);
	} 
	
	//returns the number of cards in the hand.
	public int size(){ 
		return myHand.size();
	} 

	//returns the card with index i. Cast as appropriate.
	public Card getCard(int x){ 
		return myHand.get(x);
	} 
	
	//returns the sum of the values of the cards in the hand.
	public int getTotalValue(){
		int sum = 0;
		for(int i=0; i<myHand.size(); i++){
			sum += myHand.get(i).getValue();
		}
		return sum;
	} 

//returns a String that has the contents of the hand "written" in a nice format. This will override the default toString method in the Object class.	
	public String toString(){
		String string = "";
		for(int i=0; i<myHand.size(); i++){
			string += "["+myHand.get(i).getValue()+"]";
			System.out.println("["+myHand.get(i).getValue()+"]");
		}
		return string;
	} 
	
	public static void main(String[] args){
		
	}
}