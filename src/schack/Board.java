package schack;

import schack.fields.Column;
import schack.fields.Diagonal;
import schack.fields.Row;

import java.util.List;

public class Board {

    private List<Row> rows;
    private List<Column> columns;
    private List<Diagonal> diagonals;

    private List<Square> squares;

    public Board() {
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
    }

    public List<Square> getSquares() {
        return squares;
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

}
