import javax.swing.JFrame;

public class ConsoleHandler implements InputOutputHandler{
	
	//Fields necessary for console handling
	private ConsoleKeyListener listener;
	private JFrame gameFrame;
	private Board gameBoard;
	private int[][] fullGameBoard;
	
	ConsoleHandler(Board gameBoard) {
		this.gameBoard = gameBoard;
		listener = new ConsoleKeyListener(gameBoard, this);
		gameFrame = new JFrame();
	}
	
	@Override
	public void handleInputListeners() {
		gameFrame.setTitle("Tetris");
		gameFrame.setSize(500, 500);
		gameFrame.setVisible(true);
		gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gameFrame.add(listener);
	}

	@Override
	public void sendDrawingSignal() {
		fullGameBoard = gameBoard.getFullBoard();
		gameBoard.printBoardWithPiece();
	}

}
