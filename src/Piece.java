
public abstract class Piece {
	
	//Fields common to all the Pieces
	protected int x, y, rotationState;
	protected String color;
	protected int[][][] form;
	
	//All pieces follow the move algorithm
	public void move(int[][] boardMatrix, String move){
		int newX = getNewX(move);
		int newY = getNewY(move);
		if(validMove(get2D_Representation(), boardMatrix, newX, newY)){
			x = newX;
			y = newY;
		}
	}
	
	//Getters
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
	public int[][] get2D_Representation(int simulatedRotation){
		return form[simulatedRotation];
	}
	
	
	//Simulates a new rotation state and makes sure it is a valid move
	public void rotate(int[][] boardMatrix){
		int newState = (rotationState == form.length - 1? 0 : rotationState + 1);
		if(validMove(get2D_Representation(newState), boardMatrix, x, y)){
			rotationState = newState;
		}
	}
	
	//Checks if there is any conflicts between the board and the piece
	//Takes a 2D representation of both piece and board, plus desired coordinates
	public boolean validMove(int[][] pieceArray, int[][] boardMatrix, int newX, int newY){
		for(int i=0; i<pieceArray.length; i++){
			for(int j=0; j<pieceArray[0].length; j++){
				if(pieceArray[i][j] == 1 && boardMatrix[newY+i][newX+j] != 0){
					return false;
				}
			}
		}
		return true;
	}
}

