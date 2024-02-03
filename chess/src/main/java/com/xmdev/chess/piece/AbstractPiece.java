package com.xmdev.chess.piece;

import com.xmdev.chess.common.Location;
import com.xmdev.chess.squares.Square;

import java.util.List;
import java.util.Map;

public abstract class AbstractPiece {
    protected String name;
    protected PieceColor pieceColor;
    protected Square currentSquare;

    public AbstractPiece(PieceColor pieceColor) {
        this.pieceColor = pieceColor;
    }

    public String getName() {
        return name;
    }

    public PieceColor getPieceColor() {
        return pieceColor;
    }

    public Square getCurrentSquare() {
        return currentSquare;
    }

    public void setCurrentSquare(Square currentSquare) {
        this.currentSquare = currentSquare;
    }

    public void getMoves(List<Location> candidates, Map<Location, Square> squareMap, Location current, int fileOffset, int rankOffset) {}

    @Override
    public String toString() {
        return "AbstractPiece{" +
                "name='" + name + '\'' +
                ", pieceColor=" + pieceColor +
                ", currentSquare=" + currentSquare +
                '}';
    }
}
