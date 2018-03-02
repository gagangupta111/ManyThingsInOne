package com.HackerEarth.chess;


public class King extends Piece{

    public King(boolean available, int x, int y, String color, String name) {
        super(available, x, y, color, name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        if(Math.sqrt(Math.pow(Math.abs((toX - fromX)),2)) + Math.pow(Math.abs((toY - fromY)), 2) != Math.sqrt(2)){
            return false;
        }
        return false;
    }

}