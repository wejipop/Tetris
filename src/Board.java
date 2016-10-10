
public class Board {
	//Board fields
	private int width = 0;
	private int height = 0;
	private int[][] boardMatrix;
	private P activePiece;
	
	//Constructor
	Board(int width, int height){
		this.width = width;
		this.height = height;	
		boardMatrix  = new int[height][width];
		
		//Initialize to zero (empty board)
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				boardMatrix[i][j] = 0;
			}
		}
	}
	
	//Getters
	public int getWidth(){
		return width;
	}
	public int getHeight(){
		return height;
	}
	
	//Setters
	public void setWidth(int width){
		this.width = width;
	}
	public void setHeight(int height){
		this.height = height;
	}
	
	
	//Helper functions
	public void printBoard(){
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				System.out.print(boardMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	//Valid moves are left, right, down
	public void moveActivePiece(String move){
		activePiece.move(boardMatrix, move);
	}
	
}
