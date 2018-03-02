package com.HackerEarth.chess;

import java.util.ArrayList;
import java.util.List;

public class Player {


    public final int PAWNS = 8;
    public final int BISHOPS = 2;
    public final int ROOKS = 2;
    public boolean white;

    private List<Piece> pieces = new ArrayList<>();

    public Player(boolean white) {

        super();
        this.white = white;

    }

    public List<Piece> getPieces() {
        return pieces;
    }


    public void initializePieces(){

        if(this.white == true){

            for(int i=0; i<PAWNS; i++){ // draw pawns
                pieces.add(new Pawn(true,i,1, "White",  "WP"));
            }

            pieces.add(new Rook(true, 0, 0, "White",  "WR"));
            pieces.add(new Rook(true, 7, 0, "White",  "WR"));
            pieces.add(new Bishop(true, 2, 0, "White",  "WB"));
            pieces.add(new Bishop(true, 5, 0, "White",  "WB"));
            pieces.add(new Horse(true, 1, 0, "White",  "WH"));
            pieces.add(new Horse(true, 6, 0, "White",  "WH"));
            pieces.add(new Queen(true, 3, 0, "White",  "WQ"));
            pieces.add(new King(true, 4, 0, "White",  "WK"));
        }
        else{
            for(int i=0; i<PAWNS; i++){ // draw pawns
                pieces.add(new Pawn(true,i,6, "Black",  "BP"));
            }
            pieces.add(new Rook(true, 0, 7, "Black",  "BR"));
            pieces.add(new Rook(true, 7, 7, "Black",  "BR"));
            pieces.add(new Bishop(true, 2, 7, "Black",  "BB"));
            pieces.add(new Bishop(true, 5, 7, "Black",  "BB"));
            pieces.add(new Horse(true, 1, 7, "Black",  "BH"));
            pieces.add(new Horse(true, 6, 7, "Black",  "BH"));
            pieces.add(new Queen(true, 3, 7, "Black",  "BQ"));
            pieces.add(new King(true, 4, 7, "Black",  "BK"));
        }

    }
}