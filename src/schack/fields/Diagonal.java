package schack.fields;

import schack.Board;
import schack.Square;

import java.util.ArrayList;
import java.util.List;

public class Diagonal extends Field{
    public Diagonal(Board board, int id) {
        super(board, id);
    }

    public List<Square> getSquares() {
        List<Square> squares = new ArrayList<>();
        for (Square square : getBoard().getSquares()) {
            if (getId() < 15) {
                if (square.getColumn().getId() + square.getRow().getId() == getId()) {
                    squares.add(square);
                }
            } else {
                if (22+square.getRow().getId()-square.getColumn().getId() == getId()) {
                    squares.add(square);
                }
            }
        }
        return squares;
    }
}
