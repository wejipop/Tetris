import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	public static void main(String[] Args){
		//Create board
		int width = 20;
		int height = 18;
		Board gameBoard = new Board(width, height);
		gameBoard.randomizeNewPiece();
		
		//Setup I/O handler
		InputOutputHandler io = new ConsoleHandler(gameBoard);
		io.sendDrawingSignal();
		io.handleInputListeners();
		
		
		Timer timer = new Timer();

		timer.schedule( new TimerTask() {
		    public void run() {
		       gameBoard.moveActivePiece("down");
		       gameBoard.printBoardWithPiece();
		    }
		 }, 0, 1000);
	}
	
	public static void printArray(int[][] A){
		for(int i=0; i<A.length; i++){
			for(int j=0; j<A[0].length; j++){
				System.out.print(A[i][j]+" ");
			}
			System.out.println();
		}
	}
}



//Main Loop Sample Structure
//Foo::UpdateEach();
//world->Update();
//world->Render();
//context->Sync();