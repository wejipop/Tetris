
public class Main {
	
	public static void main(String[] Args){
		//Create board
		int width = 20;
		int height = 18;
		Board gameBoard = new Board(width, height);
		gameBoard.randomizeNewPiece();
//		gameBoard.setActivePiece(PieceFactory.createPiece("O", "red", width/2-2, 0));
		
		//Setup I/O handler
		InputOutputHandler io = new ConsoleHandler(gameBoard);
		io.sendDrawingSignal();
		io.handleInputListeners();
	}
}

//Main Loop Sample Structure
//Foo::UpdateEach();
//world->Update();
//world->Render();
//context->Sync();