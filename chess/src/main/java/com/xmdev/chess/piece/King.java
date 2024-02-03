package com.xmdev.chess.piece;

import com.xmdev.chess.board.Board;
import com.xmdev.chess.common.Location;
import com.xmdev.chess.squares.Square;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class King extends AbstractPiece implements Movable {

    private final Movable rook;
    private final Movable bishop;

    public King(PieceColor pieceColor, Movable bishop, Movable rook) {
        super(pieceColor);
        this.name = "King";
        this.bishop = bishop;
        this.rook = rook;
    }

    public King(PieceColor pieceColor) {
        this(pieceColor, new Bishop(pieceColor), new Rook(pieceColor));
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = Collections.emptyList();
        Location current = this.getCurrentSquare().getLocation();
        moveCandidates.addAll(rook.getValidMoves(board, this.getCurrentSquare()));
        moveCandidates.addAll(bishop.getValidMoves(board, this.getCurrentSquare()));

        return moveCandidates.stream()
                .filter(candidate ->
                        (Math.abs(candidate.getFile().ordinal() - current.getFile().ordinal()) == 1 &&
                                Math.abs(candidate.getRank() - current.getRank()) == 1))
                .collect(Collectors.toList());
    }

    @Override
    public List<Location> getValidMoves(Board board, Square square) {
        return null;
    }

    @Override
    public void makeMove(Square square) {
        System.out.println(this.getName() + "-> makeMove()");
    }

}
