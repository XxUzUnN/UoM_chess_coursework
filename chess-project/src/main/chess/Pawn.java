package chess;

public class Pawn extends Piece{
	private PieceColour colour;
	private String symbol;

	public Pawn(PieceColour pc){
		if (pc.equals(PieceColour.WHITE)){
			this.colour=PieceColour.WHITE;
			this.symbol="♙";
		}
		else if (pc.equals(PieceColour.BLACK)){
			this.colour=PieceColour.BLACK;
			this.symbol="♟";
		}
	}

	public String getSymbol(){
		return symbol;
	}
	public PieceColour getColour(){
		return colour;
	}

	@Override
	public boolean isLegitMove(int i0, int j0, int i1, int j1) {
		if ((Board.hasPiece(i1, j1)) && (Board.getPiece(i0, j0).getColour()) == (Board.getPiece(i1, j1).getColour())) {
			return false;
		}
		int direction;
		if (Board.getPiece(i0, j0).getColour() == PieceColour.WHITE)
			direction = -1;
		else
			direction = 1;

		if (Board.hasPiece(i1, j1)) {
			if ((direction==1 && Math.abs(j0-j1)==1 && i1-i0==1) || (direction==-1 && Math.abs(j1-j0)==1 && i0-i1==1)) {
				return true;
			}
		}
		else{
			if (j0 == j1) {
				if (i0 == 1 || i0 == 6) {
					if (((i1 - i0 == 1 || i1 - i0 == 2) && direction == 1) || ((i0 - i1 == 1 || i0 - i1 == 2) && direction == -1))
						return true;
				} else
				if ((i1 - i0 == 1 && direction == 1) || (i0 - i1 == 1 && direction == -1))
					return true;
			}
		}
		return false;
	}
}