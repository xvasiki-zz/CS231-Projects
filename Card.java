/**
 * File: Card.java
 * Author: Vasiki Konneh
 * Date: 09/10/2019
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Collections;

public class Card {
	Random g = new Random();
	private int myCard = g.nextInt(11)+1;
	

// a constructor with the value of the card, possibly doing range checking.
	public Card(int v){
		this.myCard = v;
	} 
//return the numeric value of the card
	public int getValue(){
		return this.myCard;
	}

	
	}

	