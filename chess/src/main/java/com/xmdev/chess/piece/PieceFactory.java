package com.xmdev.chess.piece;

import com.xmdev.chess.common.File;
import com.xmdev.chess.common.Location;

import java.util.HashMap;
import java.util.Map;

public final class PieceFactory {

    private PieceFactory() { }

    public static Map<Location, AbstractPiece> getPieces() {
        Map<Location, AbstractPiece> pieces = new HashMap<>();

        // rooks
        pieces.put(new Location(File.A, 1), new Rook(PieceColor.WHITE));
        pieces.put(new Location(File.H, 1), new Rook(PieceColor.WHITE));
        pieces.put(new Location(File.A, 8), new Rook(PieceColor.BLACK));
        pieces.put(new Location(File.H, 8), new Rook(PieceColor.BLACK));

        // knights
        pieces.put(new Location(File.B, 1), new Knight(PieceColor.WHITE));
        pieces.put(new Location(File.G, 1), new Knight(PieceColor.WHITE));
        pieces.put(new Location(File.B, 8), new Knight(PieceColor.BLACK));
        pieces.put(new Location(File.G, 8), new Knight(PieceColor.BLACK));

        // bishops
        pieces.put(new Location(File.C, 1), new Bishop(PieceColor.WHITE));
        pieces.put(new Location(File.F, 1), new Bishop(PieceColor.WHITE));
        pieces.put(new Location(File.C, 8), new Bishop(PieceColor.BLACK));
        pieces.put(new Location(File.F, 8), new Bishop(PieceColor.BLACK));

        // queens
        pieces.put(new Location(File.D, 1), new Queen(PieceColor.WHITE));
        pieces.put(new Location(File.D, 8), new Queen(PieceColor.BLACK));

        // kings
        pieces.put(new Location(File.E, 1), new King(PieceColor.WHITE));
        pieces.put(new Location(File.E, 8), new King(PieceColor.BLACK));

        // pawns
        for (File file : File.values()) {
            pieces.put(new Location(file, 2), new Pawn(PieceColor.WHITE));
            pieces.put(new Location(file, 7), new Pawn(PieceColor.BLACK));
        }

        return pieces;
    }
}
