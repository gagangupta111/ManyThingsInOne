package com.DesignPattern;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class LUDO {

    public static void main(String[] args) throws InterruptedException {

        System.out.println(" LUDO ");
        GamePlay gamePlay = new GamePlay();
        gamePlay.print();

        while (true) {

            Thread.sleep(1000);
            gamePlay.play();

        }

    }

}

class GamePlay{

    LudoBoard ludoBoard;

    public GamePlay() {

        ludoBoard = new LudoBoard();

    }

    public void print(){

        ludoBoard.print();

    }

    public void play(){

        for (Player player : ludoBoard.list){
            player.play();
        }

    }

}

class Dice{

    private List<Integer> list = new ArrayList<>();

    public List<Integer> throwDice(){

        int number  = getRandomNumberInRange(1, 6);
        list.add(number);

        while (number == 6 && list.size() != 3){
            number  = getRandomNumberInRange(1, 6);
            list.add(number);
        }

        if (number == 6 && list.size() == 3){
            list = new ArrayList<>();
        }

        Collections.sort(list);
        return list;
    }

    private int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;

    }

}

class Player{

    private String color;
    private List<Piece> pieces = new ArrayList<>();
    private Dice dice = new Dice();
    private LudoBoard ludoBoard;

    public LudoBoard getLudoBoard() {
        return ludoBoard;
    }

    public void setLudoBoard(LudoBoard ludoBoard) {
        this.ludoBoard = ludoBoard;
    }

    public List<Piece> getPieces() {
        return pieces;
    }

    public void setPieces(List<Piece> pieces) {
        this.pieces = pieces;
    }

    public Player(String color) {

       this.color = color;

    }

    public void play(){

        System.out.println(color + " is playing!");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        switch (color){

            case Piece.RED:

                List<Integer> list = dice.throwDice();

                for (Integer integer : list){

                    if (integer.intValue() == 1){

                        for (Piece piece : pieces){

                            if (!piece.playing){
                                piece.playing = true;
                                piece.getSpot().getPiece().remove(piece);
                                ludoBoard.spots[3][0].setPiece(piece);
                                break;
                            }

                        }

                    }

                }

                break;

        }

        ludoBoard.print();
        System.out.println(color + " played !");
        System.out.println();
    }

}


class LudoBoard{

    public Spot[][] spots = new Spot[9][9];
    public List<Player> list = new ArrayList<>();

    public LudoBoard() {

        spots = new Spot[9][9];


        Player player1 = new Player(Piece.RED);
        player1.setLudoBoard(this);

        Player player2 = new Player(Piece.GREEN);
        player2.setLudoBoard(this);

        Player player3 = new Player(Piece.BLUE);
        player3.setLudoBoard(this);

        Player player4 = new Player(Piece.YELLOW);
        player4.setLudoBoard(this);

        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);

        for (int i = 0; i < 9; i++){

            for (int j = 0; j < 9; j++){

                if ( (i >= 0 && i <= 2 && j == 2) || (i >= 0 && i <= 2 && j == 6) || (i >= 6 && i <= 8 && j == 2) || (i >= 6 && i <= 8 && j == 6)
                        || (i >= 3 && i <= 5 && j >= 3 && j <= 5 ) )
                    spots[i][j] = null;
                else {

                    spots[i][j] = new Spot(i, j);

                    if ( (i >= 0 && i <= 2 && j >= 0 && j <= 1) ) {
                        Piece piece = new Piece(Piece.RED);
                        spots[i][j].setPiece(piece);
                        piece.setSpot(spots[i][j]);
                        player1.getPieces().add(piece);
                    }

                    if ( (i >= 0 && i <= 2 && j >= 7 && j <= 8) ) {
                        Piece piece = new Piece(Piece.BLUE);
                        spots[i][j].setPiece(piece);
                        piece.setSpot(spots[i][j]);
                        player2.getPieces().add(piece);
                    }

                    if ( (i >= 6 && i <= 8 && j >= 0 && j <= 1) ) {
                        Piece piece = new Piece(Piece.YELLOW);
                        spots[i][j].setPiece(piece);
                        piece.setSpot(spots[i][j]);
                        player3.getPieces().add(piece);
                    }

                    if ( (i >= 6 && i <= 8 && j >= 7 && j <= 8) ) {
                        Piece piece = new Piece(Piece.GREEN);
                        spots[i][j].setPiece(piece);
                        piece.setSpot(spots[i][j]);
                        player4.getPieces().add(piece);
                    }

                }

            }

        }

    }

    public void print(){

        for (int i = 0; i < 9; i++){

            for (int j = 0; j < 9; j++){

                if ( spots[i][j] != null ){

                    if (spots[i][j].getPiece() != null){

                        String color = spots[i][j].getColors().trim();
                        while (color.length() < 7){
                            color = color + " ";
                        }
                        System.out.printf( color );

                    }else System.out.printf( "[" + "" + "]" + "     ");

                }else System.out.printf( "X" + "" + "Y" + "     ");

            }
            System.out.println();

        }

        System.out.println();

    }

}

class Spot{

    private int i;
    private int j;
    private List<Piece> pieces = null;

    public String getColors(){

        String color = " ";
        for (Piece piece: pieces){
            color = color + piece.getColor();
        }

        return color;

    }

    public List<Piece> getPiece() {
        return pieces;
    }

    public void setPiece(Piece piece) {

        if (pieces == null){
            pieces = new ArrayList<>();
        }

        this.pieces.add(piece);
    }

    public Spot(int i, int j) {
        this.i = i;
        this.j = j;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }

    public int getJ() {
        return j;
    }

    public void setJ(int j) {
        this.j = j;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Spot spot = (Spot) o;

        if (i != spot.i) return false;
        if (j != spot.j) return false;
        return pieces != null ? pieces.equals(spot.pieces) : spot.pieces == null;
    }

    @Override
    public int hashCode() {
        int result = i;
        result = 31 * result + j;
        result = 31 * result + (pieces != null ? pieces.hashCode() : 0);
        return result;
    }
}


class Piece{

    public static final String RED = "R";
    public static final String GREEN = "G";
    public static final String YELLOW = "Y";
    public static final String BLUE = "B";

    public boolean playing;

    private String color;
    private Spot spot;

    public Spot getSpot() {
        return spot;
    }

    public void setSpot(Spot spot) {
        this.spot = spot;
    }

    public Piece(String color) {
        this.color = color;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Piece piece = (Piece) o;

        if (playing != piece.playing) return false;
        if (color != null ? !color.equals(piece.color) : piece.color != null) return false;
        return spot != null ? spot.equals(piece.spot) : piece.spot == null;
    }

    @Override
    public int hashCode() {
        int result = (playing ? 1 : 0);
        result = 31 * result + (color != null ? color.hashCode() : 0);
        result = 31 * result + (spot != null ? spot.hashCode() : 0);
        return result;
    }
}


