/*
Vasiki Konneh
CS231
Project 2
*/

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.*;
import javax.swing.*;


public class Cell{ 
	boolean alive;
	double rand = Math.random();

	//randomly determines Cell's alive state
	public Cell(){ 
		this.alive = false;
		// if (rand < 0.5){
		// 	this.alive = false;
		// }
		// else{this.alive = true;}
	}

	public Cell(boolean alive){
		this.alive = true;
	}

	//let me know if its alive or dead
	public boolean getAlive(){ 
		return this.alive;
	}

	//Reset the cell to dead.
	public void reset(){ 
		this.alive = false;
	}

	public void setAlive(boolean alive){ 
		this.alive = alive; 
	}

	
	public String toString(){ 
		String state = "";
		if(alive == true){
			state = "1";
		}
			else{
				state = "0";
			}
		return state;
	}

	public void draw(Graphics g, int x, int y, int scale){
		// g.drawRect(x,y,scale,scale);
		if(this.alive == true){
			g.setColor(Color.yellow);
            g.fillRect(x, y, scale, scale);
		}

		else {
            g.setColor(Color.black);
            g.fillRect(x, y, scale, scale);
        }
	}

// Any live cell with fewer than two live neighbours dies, as if by underpopulation.
// Any live cell with two or three live neighbours lives on to the next generation.
// Any live cell with more than three live neighbours dies, as if by overpopulation.
// Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.
//create a 2D array (like in Landscape); copy contents of original, into the second 2D array	
	public void updateState(ArrayList<Cell> neighbors){
		int aliveCount = 0;
		for (int i=0; i<neighbors.size(); i++) {
			if (neighbors.get(i).getAlive() == true){
				aliveCount++;
			}
		}
		// System.out.println("Total live count: " + aliveCount);

		for (int count = 0; count < neighbors.size(); count++) {
                if (this.alive == true) {
                    if (aliveCount == 2 || aliveCount == 3) {
                        this.alive = true;
                    } else {
                        this.alive = false;
                    }
                } 

                else {
                    if (aliveCount == 3) {
                        this.alive = true;
                    } else {
                        this.alive = false;
                    }
                }
        }
}


	// public static void main(String[] args) {
	// 	Cell cell = new Cell();
	// 	System.out.println(cell.getAlive());
	// 	cell.reset();
	// 	cell.setAlive(true);
	// 	System.out.println(cell.toString());
	// }
}



