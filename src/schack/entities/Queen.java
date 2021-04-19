package schack.entities;

import schack.Board;
import schack.Color;
import schack.Square;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Queen extends Piece{
    public Queen(Color color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> getAccessibleSquares() {
        List<Square> squares = new ArrayList<>(this.getAffectedSquares());
        squares.removeIf(square -> square.hasPiece() && square.getPiece().getColor() == this.getColor());
        return squares;
    }

    @Override
    public List<Square> getAffectedSquares() {
        Set<Square> squares = new LinkedHashSet<>();
        squares.addAll(this.getAffectedColumnSquares());
        squares.addAll(this.getAffectedRowSquares());
        squares.addAll(this.getAffectedDiagonalOneSquares());
        squares.addAll(this.getAffectedDiagonalTwoSquares());

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
        return new ArrayList<>(super.getDiagonalOneSquares());
    }

    @Override
    public List<Square> getAffectedDiagonalTwoSquares() {
        return new ArrayList<>(super.getDiagonalTwoSquares());
    }

    @Override
    public char abbreviation() {
        return 'Q';
    }
}
