package com.xmdev.chess.piece;

import com.xmdev.chess.board.Board;
import com.xmdev.chess.common.Location;
import com.xmdev.chess.squares.Square;

import java.util.Collections;
import java.util.List;

public class Queen extends AbstractPiece implements Movable {

    private Movable bishop;
    private Movable rook;

    public Queen(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "Queen";
    }

    public Queen(PieceColor pieceColor, Movable bishop, Movable rook) {
        super(pieceColor);
        this.bishop = bishop;
        this.rook = rook;
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = Collections.emptyList();
        moveCandidates.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));
        moveCandidates.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        return moveCandidates;
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public void makeMove(Square square) {
        Square currentSquare = this.getCurrentSquare();
        this.setCurrentSquare(square);
        currentSquare.reset();
    }

}
