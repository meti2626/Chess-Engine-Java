package com.chess.engine.pieces;

import com.chess.engine.Alliance;
import com.chess.engine.board.Board;
import com.chess.engine.board.Move;
import com.chess.engine.board.Tile;
import com.google.common.collect.ImmutableList;

import java.util.ArrayList;
import java.util.List;

public class Knight extends Piece
{


    private final static  int[] CANDIDATE_MOVE_COORDINATE = {-17 ,-15,-10, -6, 6 , 10, 15 , 17};

    Knight(int piecePosition, Alliance pieceAlliance) {
        super(piecePosition, pieceAlliance);
    }


    @Override
    public List<Move> calculateLegalMoves(Board board) {

        int candidateDestitionCoordinate;
        List<Move> legalMoves = new ArrayList<>();

        for(final int currentCandidate : CANDIDATE_MOVE_COORDINATE)
        {
                candidateDestitionCoordinate = this.piecePosition  + currentCandidate;

           if(true /*isValidTileCoordinate*/)
           {
               final Tile candidateDestinationTile = board.getTile(candidateDestitionCoordinate);

               if(!candidateDestinationTile.isTileOccupied())
               {
                    legalMoves.add(new Move());
               }
               else{
                   final Piece pieceDestination = candidateDestinationTile.getPiece();
                   final Alliance pieceAlliance = pieceDestination.getPieceAlliance();

                   if(this.pieceAlliance != pieceAlliance)
                   {
                       legalMoves.add(new Move());

                   }
               }
           }

        }

return ImmutableList.copyOf(legalMoves);


    }
}

