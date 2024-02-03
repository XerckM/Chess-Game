package com.xmdev.chess.piece;

import com.xmdev.chess.board.Board;
import com.xmdev.chess.common.Location;
import com.xmdev.chess.common.LocationFactory;
import com.xmdev.chess.squares.Square;

import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Knight extends AbstractPiece implements Movable {
    public Knight(PieceColor pieceColor) {
        super(pieceColor);
        this.name = "Knight";
    }

    @Override
    public List<Location> getValidMoves(Board board) {
        List<Location> moveCandidates = Collections.emptyList();
        Map<Location, Square> squareMap = board.getLocationSquareMap();
        Location current = this.getCurrentSquare().getLocation();

        getMoves(moveCandidates, squareMap, current, 2, 1);
        getMoves(moveCandidates, squareMap, current, 2, -1);
        getMoves(moveCandidates, squareMap, current, -2, 1);
        getMoves(moveCandidates, squareMap, current, -2, -1);

        return moveCandidates;
    }

    @Override
    public void getMoves(
            List<Location> candidates,
            Map<Location, Square> squareMap,
            Location current,
            int fileOffset, int rankOffset) {
        Location next = LocationFactory.build(current, fileOffset, rankOffset);
        if (squareMap.containsKey(next)) {
            if (squareMap.get(next).isOccupied()) {
                if (squareMap.get(next).getCurrentPiece().pieceColor.equals(this.getPieceColor())) return;
                candidates.add(next);
                return;
            }
            candidates.add(next);
        }
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
