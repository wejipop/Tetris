
public class TypeO extends Piece{
	
	TypeO(int x, int y, String color){
		this.x = x;
		this.y = y;
		this.color = color;
		rotationState = 0;
		
		int[][][] A = 
				{
					{
						{0,0,0,0},
						{0,1,1,0},
						{0,1,1,0},
						{0,0,0,0}
					}
				};
		
		form = A;
	}
	
	
	@Override
	public boolean validMove(int[][] boardMatrix, int newX, int newY){
		return false;
	}
}
