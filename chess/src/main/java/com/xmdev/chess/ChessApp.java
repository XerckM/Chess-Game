package com.xmdev.chess;

import com.xmdev.chess.board.Board;
import com.xmdev.chess.piece.Movable;

public class ChessApp
{
    public static void main(String[] args) {
        Board board = new Board();
        board.printBoard();
        board.getWhitePieces().forEach(System.out::println);
    }

    public static void printPiece(Movable piece) {
        piece.getValidMoves(null);
    }
}
