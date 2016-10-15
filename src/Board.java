
public class Board {
	//Board fields
	
	private int width, height, initialX, initialY;
	private int[][] boardMatrix;
	private Piece activePiece;
	
	//Constructor
	Board(int width, int height){
		this.width = width;
		this.height = height;	
		boardMatrix  = new int[height][width];
		initialX = width/2-2;
		initialY = 0;
		
		//Initialize to zero (empty board)
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				if(j==0 || j==width-1 || i==height-1)
					// 2 represents the walls
					boardMatrix[i][j] = 2;
				else
					// 0 is empty space
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
	public void setActivePiece(Piece p){
		activePiece = p;
	}
	
	//Helper functions
	//-------------------------------------------------------------------------------------------------
	public void printBoard(){
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				System.out.print(boardMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public void printBoardWithPiece(){
		int[][] pieceArray = activePiece.get2D_Representation();
		for(int i=0; i<height; i++){
			for(int j=0; j<width; j++){
				if(pieceContained(activePiece, j, i) && pieceArray[i-activePiece.y][j-activePiece.x] == 1)
					System.out.print(pieceArray[i-activePiece.y][j-activePiece.x]+" ");
				else if(boardMatrix[i][j] == 0)
					System.out.print("  ");
				else if(boardMatrix[i][j] != 0){
					System.out.print(boardMatrix[i][j]+" ");
				}
			}
			System.out.println();
		}
		System.out.println();
	}
	
	//Checks if active piece is inside given x, y coordinates
	boolean pieceContained(Piece p, int x, int y){
		boolean xContained = p.x <= x && x < p.x + p.get2D_Representation()[0].length;
		boolean yContained = p.y <= y && y < p.y + p.get2D_Representation().length;
		return xContained && yContained;
	}
	
	//Valid moves are left, right, down
	public void moveActivePiece(String move){
		activePiece.move(boardMatrix, move);
	}
	
	//To rotate Piece
	public void rotate(){
		activePiece.rotate(boardMatrix);
	}

	//Generates a new random active piece
	public void randomizeNewPiece(){
		activePiece = null;
		activePiece = PieceFactory.createRandomPiece(initialX, initialY);
	}
	
	//Turns active piece into board wall
	public void freezePiece(){
		//To be implemented
	}
	
	//Eliminates solid rows
	public void checkRows(){
		//To be implemented
	}
}
