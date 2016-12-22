import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawer {

	private final int BLOCK_DIMENSION = 80;
	private Panel p;
	private Frame f;
	int[][] board;
	Board gameBoard;

	// Helper inner class for custom Frame
	class Frame extends JFrame {
		Frame(JPanel panel) {
			setTitle("GUI");
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize((board[0].length + 4) * BLOCK_DIMENSION, (board.length + 1) * BLOCK_DIMENSION);
			setResizable(false);
			add(panel);
			setVisible(true);

		}
	}

	// Inner class for Canvas/Panel
	class Panel extends JPanel implements KeyListener {

		Panel() {
			repaint();
		}

		public void paint(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if (board[i][j] == BoardInfo.WALL_CODE) {
						g.setColor(Color.GREEN);
						g.fillRect(j * BLOCK_DIMENSION, i * BLOCK_DIMENSION, BLOCK_DIMENSION, BLOCK_DIMENSION);
					} else if (board[i][j] == BoardInfo.FROZEN_PIECE_CODE) {
						g.setColor(Color.BLACK);
						g.fillRect(j * BLOCK_DIMENSION, i * BLOCK_DIMENSION, BLOCK_DIMENSION, BLOCK_DIMENSION);

					} else if (board[i][j] == BoardInfo.PIECE_CODE) {
						g.setColor(Color.RED);
						g.fillRect(j * BLOCK_DIMENSION, i * BLOCK_DIMENSION, BLOCK_DIMENSION, BLOCK_DIMENSION);

					}
				}
			}
		}

		public void refresh() {
			repaint();
		}

		@Override
		public void keyPressed(KeyEvent e) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {
				gameBoard.moveActivePiece("left");
			} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				gameBoard.moveActivePiece("right");
			} else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
				gameBoard.moveActivePiece("down");
			} else if (e.getKeyCode() == KeyEvent.VK_UP) {
				gameBoard.rotate();
			} else if (e.getKeyCode() == KeyEvent.VK_SPACE) {
				// testing key
				boolean check = gameBoard.movePreFreeze();
				while (check == false) {
					gameBoard.moveActivePiece("down");
					check = gameBoard.movePreFreeze();
				}
				gameBoard.freezePiece();
			}
			refresh();

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

	Drawer(Board gameBoard) {
		this.gameBoard = gameBoard;
		board = gameBoard.getFullBoard();
		p = new Panel();
		f = new Frame(p);
		f.addKeyListener(p);
	}

	public void refresh() {
		p.refresh();

	}
}
