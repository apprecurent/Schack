package schack.fields;

import schack.Board;
import schack.Square;

import java.util.ArrayList;
import java.util.List;

public class Row extends Field {
    public Row(Board board, int id) {
        super(board, id);
    }

    public List<Square> getSquares() {
        List<Square> squares = new ArrayList<>();
        for (Square square : getBoard().getSquares()) {
            if (square.getRow().getId() == getId()) squares.add(square);
        }
        return squares;
    }

}
