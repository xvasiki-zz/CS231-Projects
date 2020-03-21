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


public class Landscape{
	private int row;
	private int col;
	private Cell[][] cellhold;

	public Landscape(int row, int col){
		this.cellhold = new Cell[row][col];
		for(int i=0; i<row; i++){
			for (int j=0; j<col; j++) {
					cellhold[i][j] = new Cell();
				}
			}		
		}

	public void reset(){
		// int rows = cellhold.length;
		// int cols = cellhold[0].length;
		// for(int i=0; i<rows; i++){
		// 	for(int j=0; j<cols; j++){
		// 		cellhold[i][j].reset() ;
		// 	}
		// }

		for (int i=0; i<row; i++) {
			for (int j=0; j<col; j++) {
				cellhold[i][j].reset();
			}
		}
	}

	public int getRows(){
		return this.cellhold.length;
	}

	public int getCols(){
		return this.cellhold[0].length;
	}

	public Cell getCell(int row, int col){
		return cellhold[row][col];
	}

	public String toString(){
		String s = "";
		int row = cellhold.length;
		int col = cellhold[0].length;
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<col; j++) {
				if(j == 0)
					s += "[";
				s += cellhold[i][j];
				if(j != col-1)
					s += ", ";
				else
					s += "]\n";
			}
		}
		return s;
	}

//check grid side cells and corner cells; add their neighbords to list
	public ArrayList<Cell> getNeighbors(int row, int col){
		
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		int rows = cellhold.length;
		int cols = cellhold[0].length;
		if(row-1 >= 0)
			neighbors.add(cellhold[row-1][col]);
		
		if(row-1 >= 0 && col+1 < cols)
			neighbors.add(cellhold[row-1][col+1]);
		
		if(col+1 < cols)
			neighbors.add(cellhold[row][col+1]);
		
		if(row+1 < rows && col+1 < cols)
			neighbors.add(cellhold[row+1][col+1]);
		
		if(row+1 < rows)
			neighbors.add(cellhold[row+1][col]);
		
		if(row+1 < rows && col-1 >= 0)
			neighbors.add(cellhold[row+1][col-1]);
		
		if(col-1 >= 0)
			neighbors.add(cellhold[row][col-1]);
		
		if(row-1 >= 0 && col-1 >= 0)
			neighbors.add(cellhold[row-1][col-1]);
		
		return neighbors;

			}
			
				
	public void draw(Graphics g, int gridScale){
		//draws all the cells
		for (int i=0; i<this.getRows(); i++) {
			for (int j=0; j<this.getCols(); j++ ) {
				this.cellhold[i][j].draw(g, i*gridScale, j*gridScale, gridScale);
				
			}
			
		}
	}


	public void advance(){//creates new grid, creates new cells in grid, copies alive status from old to new grid, becomes old 
		int rows = this.cellhold.length;
		int cols = this.cellhold[0].length;
		Cell[][] cellhold2 = new Cell[rows][cols];
		Cell newCell = new Cell();
		ArrayList<Cell> neighbors = new ArrayList<Cell>();
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				neighbors.clear();
				neighbors = getNeighbors(i,j);
				newCell = this.cellhold[i][j];
				newCell.updateState(neighbors);
				cellhold2[i][j] = newCell;
			}
		}

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				cellhold2[i][j].updateState(getNeighbors(i,j));
			}
		}
		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				cellhold[i][j] = cellhold2[i][j];}}
		// this.cellhold = cellhold2;


	}

	public static void main(String[] args){
		Landscape landy = new Landscape(Integer.parseInt(args[0]),Integer.parseInt(args[1])); //allows user to choose row/col
		// landy.reset();
		landy.getCell(2,3);
		System.out.println("There are" + " " + landy.getRows() + " " + "rows");
		System.out.println("There are" + " " + landy.getCols() + " " + "columns");
		System.out.println(landy.toString());
		System.out.println(landy.getNeighbors(2,3)); 



	}
}
	