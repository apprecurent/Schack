package schack.entities;

import schack.Board;
import schack.Color;
import schack.Square;

import java.util.List;

public class Pawn extends Piece{
    public Pawn(Color color, Square square) {
        super(color, square);
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
    @Override
    public char abbreviation() {
        return 'P';
    }
}
