
/*
Vasiki Konneh
CS231
Project 2
*/

import java.util.*;
import java.awt.*;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;


public class LifeSimulation{
	public static void main(String[] args) throws InterruptedException{
		
        
		Landscape lifesim = new Landscape(100, 100);
		Random gen = new Random();
        double density = 0.9;
        LandscapeDisplay dis = new LandscapeDisplay(lifesim, 8);



		for (int i = 0; i < lifesim.getRows(); i++) {
            for (int j = 0; j < lifesim.getCols(); j++ ) { 
                lifesim.getCell( i, j ).setAlive(gen.nextDouble() <= density );
            }
        }

        	
		for (int iterations = 0; iterations < 100; iterations++) {
            lifesim.advance();
            dis.repaint();
            Thread.sleep(250);


        
        	}
    }
  }
		