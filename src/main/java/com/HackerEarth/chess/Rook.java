package com.HackerEarth.chess;

public class Rook extends Piece{

    public Rook(boolean available, int x, int y, String color, String name) {
        super(available, x, y, color, name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public boolean isValid(Board board, int fromX, int fromY, int toX, int toY) {
        if(super.isValid(board, fromX, fromY, toX, toY) == false)
            return false;
        if(toX == fromX)
            return true;
        if(toY == fromY)
            return true;
        return false;
    }
}