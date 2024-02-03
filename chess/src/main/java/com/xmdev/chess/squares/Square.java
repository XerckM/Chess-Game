package com.xmdev.chess.squares;

import com.xmdev.chess.common.Location;
import com.xmdev.chess.piece.AbstractPiece;

public class Square {
    private final SquareColor color;
    private final Location location;
    private boolean isOccupied;
    private AbstractPiece currentPiece;

    public Square(SquareColor color, Location location) {
        this.color = color;
        this.location = location;
        this.isOccupied = false;
    }

    public void reset() {
        this.isOccupied = false;
        this.currentPiece = null;
    }

    public AbstractPiece getCurrentPiece() {
        return currentPiece;
    }

    public void setCurrentPiece(AbstractPiece currentPiece) {
        this.currentPiece = currentPiece;
    }

    public boolean isOccupied() {
        return isOccupied;
    }

    public void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    public SquareColor getColor() {
        return color;
    }

    public Location getLocation() {
        return location;
    }

    @Override
    public String toString() {
        return "Square{" +
                "color=" + color +
                ", location=" + location +
                ", isOccupied=" + isOccupied +
                '}';
    }
}
