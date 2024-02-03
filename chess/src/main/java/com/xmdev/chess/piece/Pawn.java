package com.xmdev.chess.piece;

import com.xmdev.chess.board.Board;
import com.xmdev.chess.common.Location;
import com.xmdev.chess.common.LocationFactory;
import com.xmdev.chess.squares.Square;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Pawn extends AbstractPiece implements Movable {
    private boolean isFirstMove = false;
    public Pawn(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "Pawn";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = Collections.emptyList();
        Location current = this.getCurrentSquare().getLocation();
        moveCandidates.add(LocationFactory
                .build(current, 0, 1));
        if (isFirstMove) {
            moveCandidates.add(LocationFactory
                    .build(current, 0, 2));
            return moveCandidates;
        }

        moveCandidates.add(LocationFactory
                .build(current, 1, 1));
        moveCandidates.add(LocationFactory
                .build(current, -1, 1));

        // filter invalid moves
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        List<Location> validMoves = moveCandidates.stream()
                .filter((squareMap::containsKey))
                .collect(Collectors.toList());

        // verify if pawn is blocked by another piece
        return validMoves.stream().filter((candidate) -> {
            if (candidate.getFile().equals(this.getCurrentSquare().getLocation().getFile()) &&
                    squareMap.get(candidate).isOccupied()) {
                return false;
            }
            return !squareMap.get(candidate).getCurrentPiece().pieceColor.equals(this.getPieceColor());
        }).collect(Collectors.toList());

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
