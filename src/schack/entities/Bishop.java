package schack.entities;

import schack.Board;
import schack.Color;
import schack.Square;

import java.util.*;

public class Bishop extends Piece {
    public Bishop(Color color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> getAccessibleSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedSquares() {
        Set<Square> squares = new LinkedHashSet<>();
        squares.addAll(this.getAffectedDiagonalOneSquares());
        squares.addAll(this.getAffectedDiagonalTwoSquares());

        return new ArrayList<>(squares);
    }

    @Override
    public List<Square> getAffectedRowSquares() {
        return Collections.emptyList();
    }

    @Override
    public List<Square> getAffectedColumnSquares() {
        return Collections.emptyList();
    }

    @Override
    public List<Square> getAffectedDiagonalOneSquares() {
        return new ArrayList<>(super.getDiagonalOneSquares());
    }

    @Override
    public List<Square> getAffectedDiagonalTwoSquares() {
        return new ArrayList<>(super.getDiagonalTwoSquares());
    }

    @Override
    public char abbreviation() {
        return 'B';
    }
}
