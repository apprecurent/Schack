package schack.engine;

import schack.Board;
import schack.Color;
import schack.Position;
import schack.entities.Bishop;
import schack.entities.Knight;
import schack.entities.Queen;
import schack.entities.Rook;

public class Engine implements IEngine {
    @Override
    public Position getMove(Position position) {
        return null;
    }

    public static void main(String[] args) {
        Board board = new Board();

        System.out.println(board.toString());

        /*
        System.out.println(board.getSquares().get(0).getPiece().getRowSquares());
        System.out.println(board.getSquares().get(0).getPiece().getColumnSquares());
        System.out.println(board.getSquares().get(0).getPiece().getDiagonalOneSquares());
        System.out.println(board.getSquares().get(0).getPiece().getDiagonalTwoSquares());
         */

        System.out.println(board.getSquares().get(0).getPiece().getAccessibleSquares());
        System.out.println();
        System.out.println(board.getSquares().get(8).getPiece().getAffectedSquares());
        System.out.println();
        System.out.println(board.getSquares().get(24).getPiece().getAffectedSquares());
        System.out.println();
        System.out.println(board.getSquares().get(40).getPiece().getAffectedSquares());
    }
}
