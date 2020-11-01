package schack.entities;

import schack.Board;
import schack.Square;

import java.util.ArrayList;
import java.util.List;

public abstract class Piece {

    private Board board;
    private Square square;
    private List<Piece> checkablePieces;

    private Piece() {
        checkablePieces = new ArrayList<>();
    }

    public Piece(Board board, Square square) {
        this();
        this.board = board;
        this.square = square;
    }

    public List<Square> getRowSquares() {
        return this.square.getRow().getSquares();
    }

    public List<Square> getColumnSquares() {
        return this.square.getColumn().getSquares();
    }

    public List<Square> getDiagonalOneSquares() {
        return this.square.getDiagonalOne().getSquares();
    }

    public List<Square> getDiagonalTwoSquares() {
        return this.square.getDiagonalTwo().getSquares();
    }

    /*
    Every time a piece is moved that has the ability to check the king after at least another move is made (Queen, Rook, Bishop),
    we will add all the pieces that are placed on its rows, columns and/or diagonals.

    Thus, whenever one of these added pieces are moved, we can instantly check two things.
    1. Is the King positioned along the row, column or diagonal of which the possible check can be made?
    2. If so, is there another Piece that is between the threatening Piece and this Piece? (this would block the check)

    If both of these are true then this Piece can not be moved.

    This should be repeated for every Piece which is contained in the checkablePieces List.

    Example:
        - WRb2, BRb5, BKb7
        - In this case, the rook and the king are on the same diagonal as the piece which has the possibility to check the King
        - This means that the black rook would be unable to move as it would put the black king in check.
     */
    public void addCheckablePiece(Piece piece) {
        checkablePieces.add(piece);
    }

    // All the squares
    public abstract List<Square> getAccessibleSquares();

    public abstract List<Square> getAffectedSquares();


}
