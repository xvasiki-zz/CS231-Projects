/**
 * File: SHuffle.java
 * Author: Vasiki Konneh
 * Date: 09/10/2019
 */

import java.util.ArrayList;
import java.util.Random;

public class Shuffle{



	public static void main(String[] args) {
		 ArrayList<Integer> array = new ArrayList<Integer>();
		 Random g = new Random();

		for(int i=0; i<10; i++){
			int val = g.nextInt(100);
			array.add(val);
			System.out.println("Generated/added value: " + val);
		}

		for (int i=0; i<10; i++) {
			int val = g.nextInt(10);
			if(val < array.size()){
				System.out.println(array.remove(val));
			}
		}
	}
}