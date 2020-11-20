package schack.assets.entities;

import schack.Board;
import schack.Square;

import java.util.List;

public class Queen extends Piece {

    public Queen(Board board, Square square) {
        super(board, square);
    }

    @Override
    public List<Square> getAccessibleSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedSquares() {
        return null;
    }

}
