package schack;

import schack.fields.Column;
import schack.fields.Diagonal;
import schack.fields.Row;

import java.awt.*;

public class Square {

    private Row row;
    private Column column;

    public Square(Row row, Column column) {
        this.row = row;
        this.column = column;
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


}
