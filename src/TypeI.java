
public class TypeI extends Piece{
	
	TypeI(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		rotationState = 0;
		
		int[][][] I = 
			{
				{
					{0,0,1,0},
					{0,0,1,0},
					{0,0,1,0},
					{0,0,1,0}
				},
				{
					{0,0,0,0},
					{1,1,1,1},
					{0,0,0,0},
					{0,0,0,0}
				}
			};
		
		//Assign the right form
		form = I;
	}
	
	
	@Override
	public boolean validMove(int[][] boardMatrix, int newX, int newY){
		return false;
	}
}
