package schack.entities;

import schack.Board;
import schack.Square;

import java.util.List;

public class Knight extends Piece{
    public Knight(Square square) {
        super(square);
    }

    @Override
    public List<Square> getAccessibleSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedRowSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedColumnSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedDiagonalOneSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedDiagonalTwoSquares() {
        return null;
    }
}