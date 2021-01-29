package schack.engine;

import schack.Board;
import schack.Position;
import schack.entities.Queen;

public class Engine implements IEngine {
    @Override
    public Position getMove(Position position) {
        return null;
    }

    public static void main(String[] args) {
        Board board = new Board();

        board.getRow(0).getSquares().get(0).setPiece(new Queen(board.getRow(0).getSquares().get(0)));
        System.out.println(board.toString());
    }
}
