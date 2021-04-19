package schack.entities;

import schack.Board;
import schack.Color;
import schack.Square;

import java.util.*;

public class Rook extends Piece{
    public Rook(Color color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> getAccessibleSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedSquares() {
        Set<Square> squares = new LinkedHashSet<>();
        squares.addAll(this.getAffectedColumnSquares());
        squares.addAll(this.getAffectedRowSquares());

        return new ArrayList<>(squares);
    }

    @Override
    public List<Square> getAffectedRowSquares() {
        return new ArrayList<>(super.getRowSquares());
    }

    @Override
    public List<Square> getAffectedColumnSquares() {
        return new ArrayList<>(super.getColumnSquares());
    }

    @Override
    public List<Square> getAffectedDiagonalOneSquares() {
        return Collections.emptyList();
    }

    @Override
    public List<Square> getAffectedDiagonalTwoSquares() {
        return Collections.emptyList();
    }
    @Override
    public char abbreviation() {
        return 'R';
    }
}
