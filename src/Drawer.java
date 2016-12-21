import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Drawer {

	private final int BLOCK_DIMENSION = 80;
	private Panel p;
	private Frame f;
	int[][] board;

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
	class Panel extends JPanel {
		Panel() {
			repaint();
		}

		public void paint(Graphics g) {
			super.paintComponent(g);
			for (int i = 0; i < board.length; i++) {
				for (int j = 0; j < board[0].length; j++) {
					if(board[i][j] == BoardInfo.WALL_CODE){
						g.setColor(Color.GREEN);
						g.fillRect(j * BLOCK_DIMENSION, i * BLOCK_DIMENSION, BLOCK_DIMENSION, BLOCK_DIMENSION);
					}
					else if(board[i][j] == BoardInfo.FROZEN_PIECE_CODE){
						g.setColor(Color.BLACK);
						g.fillRect(j * BLOCK_DIMENSION, i * BLOCK_DIMENSION, BLOCK_DIMENSION, BLOCK_DIMENSION);
						
					}
					else if (board[i][j] == BoardInfo.PIECE_CODE) {
						g.setColor(Color.RED);
						g.fillRect(j * BLOCK_DIMENSION, i * BLOCK_DIMENSION, BLOCK_DIMENSION, BLOCK_DIMENSION);
						
					}
				}
			}
		}

		public void refresh() {
			repaint();
		}

	}

	Drawer(int[][] board) {
		this.board = board;
		p = new Panel();
		f = new Frame(p);
	}

	public void refresh() {
		p.refresh();

	}
}
