
public class TypeL extends Piece {
	TypeL(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		rotationState = 0;
		
		int[][][] L = 
			{
				{
					{0,1,1,0},
					{0,0,1,0},
					{0,0,1,0},
					{0,0,0,0}
				},
				{
					{0,0,0,1},
					{0,1,1,1},
					{0,0,0,0},
					{0,0,0,0}
				},
				{
					{0,0,1,0},
					{0,0,1,0},
					{0,0,1,1},
					{0,0,0,0}
				},
				{
					{0,0,0,0},
					{0,1,1,1},
					{0,1,0,0},
					{0,0,0,0}
				}
			};
		
		//Assign the right form
		form = L;
	}
	
	
	@Override
	public boolean validMove(int[][] boardMatrix, int newX, int newY){
		return false;
	}
}
