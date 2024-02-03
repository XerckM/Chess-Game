package com.xmdev.chess.piece;

import com.xmdev.chess.board.Board;
import com.xmdev.chess.common.Location;
import com.xmdev.chess.squares.Square;

import java.util.List;

public interface Movable {
    List<Location> getValidMoves(Board board);
    List<Location> getValidMoves(Board board, Square square);
    void makeMove(Square square);
}
