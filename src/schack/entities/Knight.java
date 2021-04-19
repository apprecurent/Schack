package schack.entities;

import schack.Board;
import schack.Color;
import schack.Square;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knight extends Piece{
    public Knight(Color color, Square square) {
        super(color, square);
    }

    @Override
    public List<Square> getAccessibleSquares() {
        return null;
    }

    @Override
    public List<Square> getAffectedSquares() {
        List<Square> squares = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            int value = i == 0 ? 1 : -1;
            for (int j = -2; j <= 2; j++) {
                if (j == 0) continue;
                int rowPlus = value * (Math.abs((j%2)) + 1);
                Square square = super.getSquare().getBoard().getSquare(getSquare().getColumn().getId() + j, getSquare().getRow().getId() + rowPlus);
                if (square != null) squares.add(square);
            }
        }

        return squares;
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
        return Collections.emptyList();
    }

    @Override
    public List<Square> getAffectedDiagonalTwoSquares() {
        return Collections.emptyList();
    }

    @Override
    public char abbreviation() {
        return 'N';
    }
}
