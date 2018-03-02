package com.HackerEarth.chess;

import java.util.List;

public class Queen extends Piece{

    public Queen(boolean available, int x, int y, String color, String name) {
        super(available, x, y, color, name);
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {

        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        //diagonal
        // check if the spots in between are empty.
        if(toX - fromX == toY - fromY){
            List<Spot> spots = board.getAllDiagonalSpots(fromX, fromY, toX, toY);
            for (Spot spot : spots){
                if (spot != null){
                    return false;
                }
            }
        }

        Spot spot = board.getSpot(toX, toY);
        if ( spot.piece.getColor().equals(getColor()) ){
            return false;
        }

        return true;

    }

}
