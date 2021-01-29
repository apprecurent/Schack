package schack.fields;

import schack.Board;

public class Field {

    private Board board;
    private int id;

    public Field(Board board, int id) {
        this.board = board;
        this.id = id;
    }

    public Row getRow() {
        if (this instanceof Row) return (Row) this;
        if (this instanceof Column) {
            return this.getBoard().getRow(this.id);
        } else if (true) {
            
        }

        // check for right diagonal

        return null;
    }

    public Column getColumn() {
        if (this instanceof Row) return this.getBoard().getColumn(this.id);
        if (this instanceof Column) return (Column) this;

        // check for right diagonal

        return null;
    }

    public Diagonal getDiagonal() {

        // check for right diagonal

        return null;
    }

    public int getId() {
        return this.id;
    }

    public Board getBoard() {
        return this.board;
    }
}
