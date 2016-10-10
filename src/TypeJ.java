
public class TypeJ extends Piece{
	
	TypeJ(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		rotationState = 0;
		
		int[][][] J = 
			{
				{
					{0,0,1,0},
					{0,0,1,0},
					{0,1,1,0},
					{0,0,0,0}
				},
				{
					{0,1,0,0},
					{0,1,1,1},
					{0,0,0,0},
					{0,0,0,0}
				},
				{
					{0,0,1,1},
					{0,0,1,0},
					{0,0,1,0},
					{0,0,0,0}
				},
				{
					{0,0,0,0},
					{0,1,1,1},
					{0,0,0,1},
					{0,0,0,0}
				}
			};
		
		//Assign the right form
		form = J;
	}
	
	
	@Override
	public boolean validMove(int[][] boardMatrix, int newX, int newY){
		return false;
	}
}
