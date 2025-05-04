package com.chess.engine.board;

import com.chess.engine.pieces.Piece;
import com.google.common.collect.ImmutableMap;

import java.util.HashMap;
import java.util.Map;

public abstract  class Tile
{
    // represent the number of  each tile
    protected final int tileCoordinate; // what does it mean

    private static final Map<Integer , EmptyTile> EMPTY_TILES_CACHE=  createAllPossibleTiles();

    private static Map<Integer, EmptyTile> createAllPossibleTiles() {

        final Map<Integer , EmptyTile> emptyTileMap = new HashMap<>();

        for (int i = 0 ; i < 64 ; i++)
        {
            emptyTileMap.put(i,new EmptyTile(i));
        }

        return ImmutableMap.copyOf(emptyTileMap);
    }

    public static Tile  createTile (final int tileCoordinate, final Piece piece)
    {
        return piece != null ? new OccupiedTile(tileCoordinate , piece) :EMPTY_TILES_CACHE.get(tileCoordinate);
    }



    //individual tile
    private Tile(int tileCoordinate)
    {
        this.tileCoordinate =tileCoordinate;
    }

// tell us weather or not tile is occupied

    public abstract  boolean isTileOccupied();

    // getPeice return peice type
    public abstract Piece getPiece();



    public static final class EmptyTile extends Tile
    {
        // see this clearly , about super key word
        private EmptyTile(final int coordinate)
        {
            // super is accessing the constractor , using tileCordinate
            super(coordinate);
        }

        @Override
        public boolean isTileOccupied()
        {
            return false;
        }

        @Override
        public Piece getPiece()
        {
            return null;
        }

    }


    public static final class OccupiedTile extends Tile
    {

        private final Piece pieceOnTile;

        private OccupiedTile(int tileCoordinate , Piece pieceOnTile )
        {
            super(tileCoordinate);
            this.pieceOnTile=pieceOnTile;
        }

        @Override
        public   boolean  isTileOccupied()
        {
            return true;
        }
        @Override
        public Piece getPiece()
        {
            return this.pieceOnTile;
        }

    }
}



