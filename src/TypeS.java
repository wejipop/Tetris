
public class TypeS extends Piece{
	
	TypeS(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		rotationState = 0;
		
		int[][][] S = 
			{
				{
					{0,0,1,0},
					{0,0,1,1},
					{0,0,0,1},
					{0,0,0,0}
				},
				{
					{0,0,0,0},
					{0,0,1,1},
					{0,1,1,0},
					{0,0,0,0}
				}
			};
		
		//Assign the right form
		form = S;
	}
	
	
	@Override
	public boolean validMove(int[][] boardMatrix, int newX, int newY){
		return false;
	}
}
