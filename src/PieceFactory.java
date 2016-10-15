import java.util.Random;

public class PieceFactory {
	//Fields with Piece Information
	private final static String[] colors = {"red", "yellow", "green", "blue", "orange", "teal"};
	private final static String[] pieces = {"I", "J", "L", "O", "S", "T", "Z"};
	private static Random randomGenerator = new Random();
	 
	//Returns a Piece with given specifications
	public static Piece createPiece(String type, String color, int x, int y){
		switch(type){
		case "I":
			return new TypeI(x, y, color);
		case "J":
			return new TypeJ(x, y, color);
		case "L":
			return new TypeL(x, y, color);
		case "O":
			return new TypeO(x, y, color);
		case "S":
			return new TypeS(x, y, color);
		case "T":
			return new TypeT(x, y, color);
		case "Z":
			return new TypeZ(x, y, color);
		default:
			return null;
		}
	}
	
	//Randomizes color and type of piece
	public static Piece createRandomPiece(int x, int y){
		String randomColor = colors[randomGenerator.nextInt(colors.length)];
		String randomType = pieces[randomGenerator.nextInt(pieces.length)];
		return createPiece(randomType, randomColor, x, y);
	}
}
