
/*
Vasiki Konneh
CS231
Project 2

*/

import java.util.ArrayList;
import java.util.Random;
import java.util.List;
import java.util.Collections;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LifeSimulation{
	public static void main(String[] args) throws InterruptedException{
		
        int myRow;
        int myCol;
        myRow = Integer.parseInt(args[0]);
        myCol = Integer.parseInt(args[1]);
		    Landscape lifesim = new Landscape(myRow, myCol);
	
		  Random gen = new Random();
        double density = 0.3;
         LandscapeDisplay dis = new LandscapeDisplay(lifesim, 8);



		for (int i = 0; i < lifesim.getRows(); i++) {
            for (int j = 0; j < lifesim.getCols(); j++ ) { 
                lifesim.getCell( i, j ).setAlive(gen.nextDouble() <= density );
            }
        }

        	
		for (int iterations = 0; iterations < 10; iterations++) {
            lifesim.advance();
            dis.repaint();
            Thread.sleep(250);


        
        	}
    }
  }
		