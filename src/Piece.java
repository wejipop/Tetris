import java.util.*;

public abstract class Piece {
	
	//Fields common to all the Pieces
	protected int x, y, rotationState;
	protected String color;
	protected int[][][] form;
	
	//All pieces follow the move algorithm
	public void move(int[][] boardMatrix, String move){
		int newX = getNewX(move);
		int newY = getNewY(move);
		if(validMove(boardMatrix, newX, newY)){
			x = newX;
			y = newY;
		}
	}
	
	public int getNewX(String move){
		int newX = x;
		switch(move){
			case "left":
				newX--;
				break;
			case "right":
				newX++;
				break;
		}
		return newX;
	}
	
	public int getNewY(String move){
		int newY = y;
		switch(move){
			case "down":
				newY++;
				break;
		}
		return newY;
	}
	
	public int[][] get2D_Representation(){
		return form[rotationState];
	}
	
	public void rotate(){
		System.out.println(rotationState+" "+form.length);
		rotationState = (rotationState == form.length - 1? 0 : rotationState + 1);
	}
	
	
	//Abstract methods need to be implemented by children pieces
	public abstract boolean validMove(int[][] boardMatrix, int newX, int newY);
	
}
