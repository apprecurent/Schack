package schack.fields;

import schack.Board;
import schack.Square;

import java.util.ArrayList;
import java.util.List;

public class Column extends Field{
    public Column(Board board, int id) {
        super(board, id);
    }

    public List<Square> getSquares() {
        List<Square> squares = new ArrayList<>();
        for (Square square : getBoard().getSquares()) {
            if (square.getColumn().getId() == getId()) squares.add(square);
        }
        return squares;
    }
}
