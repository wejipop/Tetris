import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

public class ConsoleKeyListener extends JPanel implements KeyListener{
	
	//Private Fields
	private static final long serialVersionUID = 1L;
	private Board gameBoard;
	private InputOutputHandler parentHandler;
	
	public ConsoleKeyListener(Board gameBoard, InputOutputHandler parentHandler){
		this.gameBoard = gameBoard;
		this.parentHandler = parentHandler;
		addKeyListener(this);
		setFocusable(true);
		setFocusTraversalKeysEnabled(false);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if(e.getKeyCode() == KeyEvent.VK_LEFT){
			gameBoard.moveActivePiece("left");
		}
		else if(e.getKeyCode() ==  KeyEvent.VK_RIGHT){
			gameBoard.moveActivePiece("right");
		}
		else if(e.getKeyCode() ==  KeyEvent.VK_DOWN){
			gameBoard.moveActivePiece("down");
		}
		else if(e.getKeyCode() ==  KeyEvent.VK_UP){
			gameBoard.rotate();
		}
		parentHandler.sendDrawingSignal();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

}
