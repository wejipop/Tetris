
public class TypeZ extends Piece{
	
	TypeZ(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		rotationState = 0;
		
		int[][][] Z = 
			{
				{
					{0,0,0,1},
					{0,0,1,1},
					{0,0,1,0},
					{0,0,0,0}
				},
				{
					{0,0,0,0},
					{0,1,1,0},
					{0,0,1,1},
					{0,0,0,0}
				}
			};
		
		//Assign the right form
		form = Z;
	}
	
	
	@Override
	public boolean validMove(int[][] boardMatrix, int newX, int newY){
		return false;
	}
}
