package schack.entities;

import schack.Board;
import schack.Color;
import schack.Square;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class Piece {

    private Square square;
    private List<Piece> checkablePieces;
    private Color color;

    private Piece() {
        checkablePieces = new ArrayList<>();
    }

    public Piece(Color color, Square square) {
        this();
        this.color = color;
        this.square = square;
    }

    public List<Square> getRowSquares() {
        List<Square> squares = new ArrayList<>(this.getSquare().getRow().getSquares());
        squares.remove(this.getSquare());
        List<Square> removeSquares = new ArrayList<>();

        for (int i = squares.size() - 1; i >= 0; i--) {
            Square square = squares.get(i);
            if (square.hasPiece() && !square.getPiece().equals(this)) {


                // Same Row
                if (square.getRow().equals(this.getSquare().getRow())) {
                    // Lower column id (more left)
                    if (square.getColumn().getId() < this.getSquare().getColumn().getId()) {
                        List<Square> belowRowSquares = this.getSquare().getRow().getSquares().subList(0, this.getSquare().getColumn().getId());
                        for (int j = belowRowSquares.size() - 1; j >= 0; j--) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(0, j));
                                break;
                            }
                        }
                        // Higher column id (more right)
                    } else {
                        List<Square> belowRowSquares = this.getSquare().getRow().getSquares().subList(this.getSquare().getColumn().getId() + 1, this.getSquare().getColumn().getSquares().size());
                        for (int j = 0; j < belowRowSquares.size(); j++) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(j + 1, belowRowSquares.size()));
                                break;
                            }
                        }
                    }
                }
            }
        }
        squares.removeAll(removeSquares);
        return squares;
    }

    public List<Square> getColumnSquares() {
        List<Square> squares = new ArrayList<>(this.getSquare().getColumn().getSquares());
        squares.remove(this.getSquare());
        List<Square> removeSquares = new ArrayList<>();
        for (int i = squares.size() - 1; i >= 0; i--) {
            Square square = squares.get(i);
            if (square.hasPiece() && !square.getPiece().equals(this)) {
                // Same column
                if (square.getColumn().equals(getSquare().getColumn())) {
                    // Lower row id (higher up)
                    if (square.getRow().getId() < this.getSquare().getRow().getId()) {
                        List<Square> belowRowSquares = this.getSquare().getColumn().getSquares().subList(0, this.getSquare().getRow().getId());
                        for (int j = belowRowSquares.size() - 1; j >= 0; j--) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(0, j));
                                break;
                            }
                        }
                        // Higher row id (lower down)
                    } else {
                        List<Square> belowRowSquares = this.getSquare().getColumn().getSquares().subList(this.getSquare().getRow().getId() + 1, this.getSquare().getRow().getSquares().size());
                        for (int j = 0; j < belowRowSquares.size(); j++) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(j + 1, belowRowSquares.size()));
                                break;
                            }
                        }
                    }
                }
            }
        }
        squares.removeAll(removeSquares);
        return squares;
    }

    public List<Square> getDiagonalOneSquares() {
        Set<Square> setSquares = new LinkedHashSet<>(this.getSquare().getDiagonalOne().getSquares());
        setSquares.remove(this.getSquare());
        List<Square> squares = new ArrayList<>(setSquares);
        List<Square> removeSquares = new ArrayList<>();

        for (int i = squares.size() - 1; i >= 0; i--) {
            Square square = squares.get(i);
            if (square.hasPiece() && !square.getPiece().equals(this)) {

                // First diagonal
                if (square.getDiagonalOne().equals(this.getSquare().getDiagonalOne())) {

                    // More left
                    if (square.getColumn().getId() < this.getSquare().getColumn().getId()) {

                        // Reversed sublist from rook as the squares of a diagonal are attained in reversed order
                        List<Square> belowRowSquares = this.getSquare().getDiagonalOne().getSquares().subList(this.getSquare().getDiagonalOne().getSquares().indexOf(this.getSquare()) + 1, this.getSquare().getDiagonalOne().getSquares().size());
                        for (int j = 0; j < belowRowSquares.size(); j++) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(j + 1, belowRowSquares.size()));
                                break;
                            }
                        }
                        // More right
                    } else {
                        List<Square> belowRowSquares = this.getSquare().getDiagonalOne().getSquares().subList(0, this.getSquare().getDiagonalOne().getSquares().indexOf(this.getSquare()));
                        for (int j = belowRowSquares.size() - 1; j >= 0; j--) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(0, j));
                                break;
                            }
                        }
                    }
                }
            }
        }
        squares.removeAll(removeSquares);

        return squares;
    }

    public List<Square> getDiagonalTwoSquares() {
        Set<Square> setSquares = new LinkedHashSet<>(this.getSquare().getDiagonalTwo().getSquares());
        setSquares.remove(this.getSquare());
        List<Square> squares = new ArrayList<>(setSquares);
        List<Square> removeSquares = new ArrayList<>();

        for (int i = squares.size() - 1; i >= 0; i--) {
            Square square = squares.get(i);
            if (square.hasPiece() && !square.getPiece().equals(this)) {

                if (square.getDiagonalTwo().equals(this.getSquare().getDiagonalTwo())) {
                    // More left
                    if (square.getColumn().getId() < this.getSquare().getColumn().getId()) {

                        // Reversed sublist from rook as the squares of a diagonal are attained in reversed order

                        List<Square> belowRowSquares = this.getSquare().getDiagonalTwo().getSquares().subList(0, this.getSquare().getDiagonalTwo().getSquares().indexOf(this.getSquare()));
                        for (int j = belowRowSquares.size() - 1; j >= 0; j--) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(0, j));
                                break;
                            }
                        }
                        // More right
                    } else {
                        List<Square> belowRowSquares = this.getSquare().getDiagonalTwo().getSquares().subList(this.getSquare().getDiagonalTwo().getSquares().indexOf(this.getSquare()) + 1, this.getSquare().getDiagonalTwo().getSquares().size());
                        for (int j = 0; j < belowRowSquares.size(); j++) {
                            if (belowRowSquares.get(j).hasPiece()) {
                                if (belowRowSquares.get(j).getPiece() instanceof King && belowRowSquares.get(j).getPiece().getColor() != this.getColor()) continue;
                                removeSquares.addAll(belowRowSquares.subList(j + 1, belowRowSquares.size()));
                                break;
                            }
                        }
                    }
                }
            }
        }
        squares.removeAll(removeSquares);

        return squares;
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


    public Color getColor() {
        return this.color;
    }

    // All the squares
    public abstract List<Square> getAccessibleSquares();

    // All the squares that this piece affects
    public abstract List<Square> getAffectedSquares();

    public abstract List<Square> getAffectedRowSquares();
    public abstract List<Square> getAffectedColumnSquares();
    public abstract List<Square> getAffectedDiagonalOneSquares();
    public abstract List<Square> getAffectedDiagonalTwoSquares();

    // get all the moves that this piece has made
    public List<Square> getMoves() {
        return new ArrayList<>();
    }

    public void setSquare(Square square) {
        this.square = square;
    }

    public Square getSquare() {
        return this.square;
    }

    public abstract char abbreviation();

    public String toString() {
        return String.valueOf(abbreviation());
    }


}
