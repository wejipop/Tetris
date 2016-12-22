public class Board {
	// Board representations constants
	public final int EMPTY_CODE = BoardInfo.EMPTY_CODE;
	public final int PIECE_CODE = BoardInfo.PIECE_CODE;
	public final int WALL_CODE = BoardInfo.WALL_CODE;
	public final int FROZEN_PIECE_CODE = BoardInfo.FROZEN_PIECE_CODE;

	// Board fields
	private int width, height, initialX, initialY;
	private int[][] boardMatrix;
	private int[][] fullBoardMatrix;
	private Piece activePiece, nextPiece;

	// Constructor
	Board(int width, int height) {
		this.width = width;
		this.height = height;
		boardMatrix = new int[height][width];
		fullBoardMatrix = new int[height][width];
		initialX = width / 2 - 2;
		initialY = 0;

		// Initialize to zero (empty board)
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (j == 0 || j == width - 1 || i == height - 1)
					// 2 represents the walls
					boardMatrix[i][j] = WALL_CODE;
				else
					// 0 is empty space
					boardMatrix[i][j] = EMPTY_CODE;
			}
		}
	}

	// Getters
	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	public int[][] getFullBoard() {
		return fullBoardMatrix;
	}

	// Setters
	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public void setActivePiece(Piece p) {
		activePiece = p;
		nextPiece = PieceFactory.createRandomPiece(initialX, initialY);
	}

	// Helper functions
	// -------------------------------------------------------------------------------------------------
	public void updateBoard() {
		int[][] pieceArray = activePiece.get2D_Representation();
		// Update full board with the Piece
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (pieceContained(activePiece, j, i) && pieceArray[i - activePiece.y][j - activePiece.x] == PIECE_CODE)
					fullBoardMatrix[i][j] = pieceArray[i - activePiece.y][j - activePiece.x];
				else
					fullBoardMatrix[i][j] = boardMatrix[i][j];
			}
		}
	}

	public void printBoard() {
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				System.out.print(boardMatrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void printBoardWithPiece() {
		String boardString = "";
		int[][] board = getFullBoard();
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				if (board[i][j] == EMPTY_CODE)
					boardString += "  ";
				else
					boardString += board[i][j] + " ";
			}
			boardString += "\n";
		}
		System.out.println(boardString);
	}

	// Checks if active piece is inside given x, y coordinates
	boolean pieceContained(Piece p, int x, int y) {
		boolean xContained = p.x <= x && x < p.x + p.get2D_Representation()[0].length;
		boolean yContained = p.y <= y && y < p.y + p.get2D_Representation().length;
		return xContained && yContained;
	}

	// Valid moves are left, right, down
	public void moveActivePiece(String move) {
		activePiece.move(boardMatrix, move);
		updateBoard();
	}

	// To rotate Piece
	public void rotate() {
		activePiece.rotate(boardMatrix);
		updateBoard();
	}

	// Generates a new random active piece
	public void randomizeNewPiece() {
		activePiece = null;
		setActivePiece(PieceFactory.createRandomPiece(initialX, initialY));
	}

	// Move down active piece before
	public boolean movePreFreeze() {
		boolean check = false;
		int[][] entireBoard = getFullBoard();

		for (int i = 0; i < entireBoard.length; i++) {
			for (int j = 0; j < entireBoard[0].length; j++) {
				if (entireBoard[i][j] == PIECE_CODE
						&& (entireBoard[i + 1][j] == FROZEN_PIECE_CODE || entireBoard[i + 1][j] == WALL_CODE)) {
					check = true;
					break;
				}
			}
		}

		return check;
	}

	// Turns active piece into frozen piece
	public void freezePiece() {
		int[][] pieceArray = activePiece.get2D_Representation();
		for (int i = 0; i < pieceArray.length; i++) {
			for (int j = 0; j < pieceArray[0].length; j++) {
				// Make all the 1's into 2's
				if (pieceArray[i][j] == PIECE_CODE)
					boardMatrix[activePiece.y + i][activePiece.x + j] = FROZEN_PIECE_CODE;
			}
		}
		checkRows();
		setActivePiece(nextPiece);
		updateBoard();
	}

	// Eliminates solid rows
	public void checkRows() {
		// Empty all necessary rows
		for (int i = boardMatrix.length - 2; i >= 0; i--) {
			if (rowContainsOnly(boardMatrix[i], FROZEN_PIECE_CODE))
				emptyRow(boardMatrix[i]);
		}
		// Bring all empty rows down
		for (int i = boardMatrix.length - 2; i >= 0; i--) {
			if (rowContainsOnly(boardMatrix[i], EMPTY_CODE)) {
				for (int j = i; j > 0; j--)
					switchRows(j, j - 1, boardMatrix);
			}
		}
	}

	// Functions necessary for checkRows algorithm
	// --------------------------------------------------------------------
	private void emptyRow(int[] row) {
		for (int i = 0; i < row.length; i++)
			if (row[i] != WALL_CODE)
				row[i] = EMPTY_CODE;
	}

	private boolean rowContainsOnly(int[] row, int value) {
		for (int i : row) {
			if (i != WALL_CODE && i != value)
				return false;
		}
		return true;
	}

	private void switchRows(int i, int j, int[][] board) {
		int[] temp = board[i];
		board[i] = board[j];
		board[j] = temp;
	}
	// ---------------------------------------------------------------------
}