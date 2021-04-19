package schack;

import schack.entities.Piece;
import schack.exception.NoPieceException;
import schack.fields.Column;
import schack.fields.Diagonal;
import schack.fields.Row;

import java.awt.*;

public class Square {

    private Row row;
    private Column column;
    private Piece piece;

    public Square(Row row, Column column) {
        this.row = row;
        this.column = column;
    }

    public void setPiece(Piece piece) {
        this.piece = piece;
    }

    public Piece getPiece() {
        try {
            if (!hasPiece()) throw new NoPieceException();
        } catch (NoPieceException e) {
            System.out.println(this + " does not contain a Piece");
        }
        return this.piece;
    }

    public boolean hasPiece() {
        return this.piece != null;
    }

    public Board getBoard() {
        return this.column.getBoard();
    }

    public Row getRow() {
        return row;
    }

    public Column getColumn() {
        return column;
    }

    public Diagonal getDiagonalOne() {
        return getBoard().getDiagonals().get(column.getId() + row.getId());
    }

    public Diagonal getDiagonalTwo() {
        return getBoard().getDiagonals().get(22+row.getId()-column.getId());
    }

    public String toString() {
        String pieceString = hasPiece() ?  ": "+ piece.toString() : ": X";
        String string = "[" +column.getId() + ", " + row.getId()  + pieceString + "]";
        return string;
    }


}
