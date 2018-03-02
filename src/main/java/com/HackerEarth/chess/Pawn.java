package com.HackerEarth.chess;

public class Pawn extends Piece{

    public Pawn(boolean available, int x, int y, String color, String name) {
        super(available, x, y, color, name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {

        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        // check if the pawn can move ahead and there is no one in space between.
        if (toY == fromY+1){
            if (toX == fromX+1 || toX == fromX-1 || toX == fromX){
                // till now move is valid, check if other is not occupied and if occupied it is opposite
                Spot spot = board.getSpot(toX, toY);
                if (spot.isBlack()){
                    return true;
                }else {
                    return false;
                }
            }
        }

        if (toY == fromY-1){
            if (toX == fromX+1 || toX == fromX-1 || toX == fromX){
                // till now move is valid, check if other is not occupied and if occupied it is opposite
                Spot spot = board.getSpot(toX, toY);
                if (spot.isWhite()){
                    return true;
                }else {
                    return false;
                }
            }
        }

        if (fromY == 1 && toY == fromY+2){

            if (fromX == fromY){
                Spot spot = board.getSpot(fromX, fromY+1);
                if (spot.piece != null){
                    return false;
                }

                spot = board.getSpot(toX, toY);
                if (spot.isBlack()){
                    return true;
                }else {
                    return false;
                }
            }

        }

        if (fromY == 6 && toY == fromY-2){

            if (fromX == fromY){
                Spot spot = board.getSpot(fromX, fromY-1);
                if (spot.piece != null){
                    return false;
                }

                spot = board.getSpot(toX, toY);
                if (spot.isWhite()){
                    return true;
                }else {
                    return false;
                }
            }

        }

        return false;

    }
}
