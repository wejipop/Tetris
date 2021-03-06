import java.util.Timer;
import java.util.TimerTask;

public class Main {
	
	public static void main(String[] Args){
		//Create board
		int width = 12;
		int height = 18;
		Board gameBoard = new Board(width, height);
		gameBoard.randomizeNewPiece();
		
		//Create Drawer
		Drawer drawer = new Drawer(gameBoard);
				
		Timer timer = new Timer();

		timer.schedule( new TimerTask() {
			int counter = 0;
		    public void run() {
		    	counter++;
		    	if(counter == 10){
		    		gameBoard.moveActivePiece("down");
		    		counter = 0;
		    	}
		    	gameBoard.printBoardWithPiece();
		    	drawer.refresh();
		    }
		 }, 0, 100);
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