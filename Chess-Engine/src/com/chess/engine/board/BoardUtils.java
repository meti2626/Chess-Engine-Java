package com.chess.engine.board;

public class BoardUtils {

    private BoardUtils()
    {
        throw new RuntimeException("you cannot instantiate me!");
    }



    public static boolean isValidTieCoordinate(int coordinate) {
        return coordinate >= 0 && coordinate < 64;
    }
}
