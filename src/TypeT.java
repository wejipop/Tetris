
public class TypeT extends Piece{
	
	TypeT(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		rotationState = 0;
		
		int[][][] T = 
			{
				{
					{0,0,1,0},
					{0,1,1,0},
					{0,0,1,0},
					{0,0,0,0}
				},
				{
					{0,0,1,0},
					{0,1,1,1},
					{0,0,0,0},
					{0,0,0,0}
				},
				{
					{0,0,1,0},
					{0,0,1,1},
					{0,0,1,0},
					{0,0,0,0}
				},
				{
					{0,0,0,0},
					{0,1,1,1},
					{0,0,1,0},
					{0,0,0,0}
				}
			};
		
		//Assign the right form
		form = T;
	}
	
	
	@Override
	public boolean validMove(int[][] boardMatrix, int newX, int newY){
		return false;
	}
	
}
