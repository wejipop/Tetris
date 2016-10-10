
public class Tetris {
	
	public static void main(String[] Args){
		Piece p = new TypeI(0,0,"red");
		for(int i=0; i<10; i++)
			p.rotate();
	}
}
