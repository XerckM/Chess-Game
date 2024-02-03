package com.xmdev.chess.board;

import com.xmdev.chess.common.File;
import com.xmdev.chess.common.Location;
import com.xmdev.chess.piece.AbstractPiece;
import com.xmdev.chess.piece.PieceColor;
import com.xmdev.chess.piece.PieceFactory;
import com.xmdev.chess.squares.Square;
import com.xmdev.chess.squares.SquareColor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Board {
    private static final Integer BOARD_SIZE = 8;
    private final Map<Location, Square> locationSquareMap;
    Square[][] boardSquares = new Square[BOARD_SIZE][BOARD_SIZE];
    private final List<AbstractPiece> whitePieces = new ArrayList<>();
    private final List<AbstractPiece> blackPieces = new ArrayList<>();

    public Board() {
        locationSquareMap = new HashMap<>();
        Map<Location, AbstractPiece> pieces = PieceFactory.getPieces();
        for (int i = 0; i < boardSquares.length; i++) {
            int column = 0;
            SquareColor currentColor = (i % 2 == 0) ? SquareColor.LIGHT : SquareColor.DARK;
            for (File file : File.values()) {
                Square newSquare = new Square(currentColor, new Location(file, BOARD_SIZE - i));
                if (pieces.containsKey(newSquare.getLocation())) {
                    AbstractPiece piece = pieces.get(newSquare.getLocation());
                    newSquare.setCurrentPiece(piece);
                    newSquare.setOccupied(true);
                    piece.setCurrentSquare(newSquare);
                    if (piece.getPieceColor().equals(PieceColor.BLACK)) {
                        blackPieces.add(piece);
                    } else {
                        whitePieces.add(piece);
                    }
                }
                locationSquareMap.put(newSquare.getLocation(), newSquare);
                boardSquares[i][column] = newSquare;
                currentColor = (currentColor == SquareColor.DARK) ? SquareColor.LIGHT : SquareColor.DARK;
                column++;
            }
        }
    }

    public Map<Location, Square> getLocationSquareMap() {
        return locationSquareMap;
    }

    public List<AbstractPiece> getWhitePieces() {
        return whitePieces;
    }

    public List<AbstractPiece> getBlackPieces() {
        return blackPieces;
    }

    public void printBoard() {
        for (int i = 0; i < boardSquares.length; i++) {
            System.out.print(BOARD_SIZE - i + " ");
            for (int j = 0; j < boardSquares[i].length; j++) {
                if (boardSquares[i][j].isOccupied()) {
                    AbstractPiece piece = boardSquares[i][j].getCurrentPiece();
                    System.out.print(piece.getName().charAt(0) + " ");
                } else {
                    // empty square
                    System.out.print("— ");
                }
            }
            System.out.println();
        }

        System.out.print(" ");
        for (File file : File.values()) {
            System.out.print(" " + file.name());
        }
        System.out.println();
    }
}
