package com.HackerEarth.chess;

public class Test {

    public static void main(String[] args){

        System.out.println("Hello!");
        Board board  = new Board();

        Player player = new Player(true);
        player.initializePieces();

        Player player1 = new Player(false);
        player1.initializePieces();

        board.print();

    }

}
