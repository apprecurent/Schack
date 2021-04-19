package schack;

import schack.entities.*;
import schack.fields.Column;
import schack.fields.Diagonal;
import schack.fields.Row;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private List<Row> rows;
    private List<Column> columns;
    private List<Diagonal> diagonals;

    private List<Square> squares;
    private List<Piece> blackPieces;
    private List<Piece> whitePieces;

    public Board() {

        rows = new ArrayList<>();
        columns = new ArrayList<>();
        diagonals = new ArrayList<>();
        squares = new ArrayList<>();
        blackPieces = new ArrayList<>();
        whitePieces = new ArrayList<>();

        for (int i = 0; i < 8; i++) {
            rows.add(new Row(this, i));
            columns.add(new Column(this, i));
        }

        for (int i = 0; i < 30; i++) {
            diagonals.add(new Diagonal(this, i));
        }

        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                squares.add(new Square(rows.get(i), columns.get(j)));
            }
        }

        this.startPositions();

    }

    public void startPositions() {
        blackPieces.add(new Rook(Color.BLACK, getSquare(0, 0)));
        blackPieces.add(new Knight(Color.BLACK, getSquare(1, 0)));
        blackPieces.add(new Bishop(Color.BLACK, getSquare(2, 0)));
        blackPieces.add(new King(Color.BLACK, getSquare(3, 0)));
        blackPieces.add(new Queen(Color.BLACK, getSquare(4, 0)));
        blackPieces.add(new Bishop(Color.BLACK, getSquare(5, 0)));
        blackPieces.add(new Knight(Color.BLACK, getSquare(6, 0)));
        blackPieces.add(new Rook(Color.BLACK, getSquare(7, 0)));
        for (int i = 0; i < 8; i++) {
            blackPieces.add(new Pawn(Color.BLACK, getSquare(i, 1)));
        }
        whitePieces.add(new Rook(Color.WHITE, getSquare(0, 7)));
        whitePieces.add(new Knight(Color.WHITE, getSquare(1, 7)));
        whitePieces.add(new Bishop(Color.WHITE, getSquare(2, 7)));
        whitePieces.add(new Queen(Color.WHITE, getSquare(3, 7)));
        whitePieces.add(new King(Color.WHITE, getSquare(4, 7)));
        whitePieces.add(new Bishop(Color.WHITE, getSquare(5, 7)));
        whitePieces.add(new Knight(Color.WHITE, getSquare(6, 7)));
        whitePieces.add(new Rook(Color.WHITE, getSquare(7, 7)));
        for (int i = 0; i < 8; i++) {
            whitePieces.add(new Pawn(Color.WHITE, getSquare(i, 6)));
        }

        for (Piece blackPiece : blackPieces) {
            getSquare(blackPiece.getSquare().getColumn().getId(), blackPiece.getSquare().getRow().getId()).setPiece(blackPiece);
        }
        for (Piece whitePiece : whitePieces) {
            getSquare(whitePiece.getSquare().getColumn().getId(), whitePiece.getSquare().getRow().getId()).setPiece(whitePiece);
        }
    }

    public List<Square> getSquares() {
        return squares;
    }

    public Square getSquare(int columnId, int rowId) {
        for (Square square : squares) {
            if (square.getColumn().getId() == columnId && square.getRow().getId() == rowId) return square;
        }
        return null;
    }

    public List<Row> getRows() {
        return rows;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public List<Diagonal> getDiagonals() {
        return diagonals;
    }

    public Row getRow(int id) {
        return rows.get(id);
    }

    public Column getColumn(int id) {
        return columns.get(id);
    }

    public Diagonal getDiagonal(int id) {
        return diagonals.get(id);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Row row : rows) {
            for (Square square : row.getSquares()) {
                sb.append(square.toString());
            }
            sb.append("\n");
        }
        return sb.toString();
    }

}
