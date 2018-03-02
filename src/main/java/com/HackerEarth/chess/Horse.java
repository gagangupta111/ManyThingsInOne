package com.HackerEarth.chess;

public class Horse extends Piece{

    public Horse(boolean available, int x, int y, String color, String name) {
        super(available, x, y, color, name);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;

        if(toX != fromX - 1 && toX != fromX + 1 && toX != fromX + 2 && toX != fromX - 2)
            return false;
        if(toY != fromY - 2 && toY != fromY + 2 && toY != fromY - 1 && toY != fromY + 1)
            return false;

        Spot spot = board.getSpot(toX, toY);
        if ( spot.piece.getColor().equals(getColor()) ){
            return false;
        }
        return true;
    }

}
