package com.DesignPattern.SnakeAndLadder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SnakeAndLadder {

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

    SnakeLadder snakeLadder;

    public GamePlay() {

        snakeLadder = new SnakeLadder();

    }

    public void print(){

        snakeLadder.print();

    }

    public void play(){

        for (Player player : snakeLadder.list){
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
    private SnakeLadder snakeLadder;

    public SnakeLadder getSnakeLadder() {
        return snakeLadder;
    }

    public void setSnakeLadder(SnakeLadder snakeLadder) {
        this.snakeLadder = snakeLadder;
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

                List<Integer> list = dice.throwDice();
                for (Integer integer : list){

                    if (integer.intValue() == 1){

                        for (Piece piece : pieces){

                            if (!piece.playing){
                                piece.playing = true;
                                break;
                            }

                        }

                    }else {

                        for (Piece piece : pieces){

                            Spot spot = piece.getSpot();
                            int i = spot.getI();
                            int j = spot.getJ();

                            if ( (9 - j) >= integer ){
                                j = j + integer;
                                spot.getPiece().remove(piece);
                                spot = snakeLadder.spots[i][j];
                                spot.setPiece(piece);
                            }else {

                                int gap = 9 - j;
                                int more  = integer - gap - 1;
                                j = more;
                                i = i + 1;
                                spot.getPiece().remove(piece);
                                spot = snakeLadder.spots[i][j];
                                spot.setPiece(piece);
                            }

                        }

                    }

                }

        snakeLadder.print();
        System.out.println(color + " played !");
        System.out.println();
    }

}


class SnakeLadder {

    public Spot[][] spots;
    public List<Player> list = new ArrayList<>();

    public SnakeLadder() {

        spots = new Spot[10][10];

        Player player1 = new Player(Piece.RED);
        player1.setSnakeLadder(this);

        Player player2 = new Player(Piece.GREEN);
        player2.setSnakeLadder(this);

        Player player3 = new Player(Piece.BLUE);
        player3.setSnakeLadder(this);

        Player player4 = new Player(Piece.YELLOW);
        player4.setSnakeLadder(this);

        list.add(player1);
        list.add(player2);
        list.add(player3);
        list.add(player4);

        int count = 1;
        for (int i = 0; i < 10; i++){
            for (int j = 0; j < 10; j++){

                    spots[i][j] = new Spot(i, j);

            }
        }

        Piece piece = new Piece(Piece.RED);
        spots[0][0].setPiece(piece);
        piece.setSpot(spots[0][0]);
        player1.getPieces().add(piece);

        piece = new Piece(Piece.GREEN);
        spots[0][0].setPiece(piece);
        piece.setSpot(spots[0][0]);
        player2.getPieces().add(piece);

        piece = new Piece(Piece.BLUE);
        spots[0][0].setPiece(piece);
        piece.setSpot(spots[0][0]);
        player3.getPieces().add(piece);

        piece = new Piece(Piece.YELLOW);
        spots[0][0].setPiece(piece);
        piece.setSpot(spots[0][0]);
        player4.getPieces().add(piece);

        // initializing snakes
        Snake snake = new Snake(spots[1][1], spots[3][3]);
        spots[1][1].setSnake(snake);
        spots[3][3].setSnake(snake);

        snake = new Snake(spots[2][1], spots[3][5]);
        spots[2][1].setSnake(snake);
        spots[3][5].setSnake(snake);

        snake = new Snake(spots[5][1], spots[6][3]);
        spots[5][1].setSnake(snake);
        spots[6][3].setSnake(snake);

        snake = new Snake(spots[8][6], spots[9][4]);
        spots[8][6].setSnake(snake);
        spots[9][4].setSnake(snake);

        snake = new Snake(spots[5][6], spots[7][4]);
        spots[5][6].setSnake(snake);
        spots[7][4].setSnake(snake);

        // initializing ladders
        Ladder ladder = new Ladder(spots[5][5], spots[8][5]);
        spots[5][5].setLadder(ladder);
        spots[8][5].setLadder(ladder);

        ladder = new Ladder(spots[2][5], spots[4][5]);
        spots[2][5].setLadder(ladder);
        spots[4][5].setLadder(ladder);

        ladder = new Ladder(spots[5][6], spots[7][4]);
        spots[5][6].setLadder(ladder);
        spots[7][4].setLadder(ladder);

        ladder = new Ladder(spots[3][6], spots[4][9]);
        spots[3][6].setLadder(ladder);
        spots[4][9].setLadder(ladder);

        ladder = new Ladder(spots[4][7], spots[6][9]);
        spots[4][7].setLadder(ladder);
        spots[6][9].setLadder(ladder);

        ladder = new Ladder(spots[8][1], spots[8][4]);
        spots[8][1].setLadder(ladder);
        spots[8][4].setLadder(ladder);

        ladder = new Ladder(spots[8][8], spots[9][8]);
        spots[8][8].setLadder(ladder);
        spots[9][8].setLadder(ladder);

    }

    public void print(){

        Spot spot = null;
        String print = "";
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                spot = spots[i][j];
                print = print + (10*spot.getI() + spot.getJ() + 1);
                print = print + spot.getColors();
                while (print.length() < 10){
                    print = print + " ";
                }
                System.out.printf(print);
                print = "";

            }System.out.println();

        }
    }

}

class Spot{

    private int i;
    private int j;
    private List<Piece> pieces = null;
    private Snake snake;
    private Ladder ladder;

    public Snake getSnake() {
        return snake;
    }

    public void setSnake(Snake snake) {
        this.snake = snake;
    }

    public Ladder getLadder() {
        return ladder;
    }

    public void setLadder(Ladder ladder) {
        this.ladder = ladder;
    }

    public String getColors(){

        String color = "_";
        for (Piece piece: pieces){
            color = color + piece.getColor();
        }


        if (snake != null){
            if (snake.getFrom() == this){
                color = color + "SF" + snake.getId();
            }else if (snake.getTo() == this){
                color = color + "ST" + snake.getId();
            }
        }

        if (ladder != null){
            if (ladder.getFrom() == this){
                color = color + "LF" + ladder.getId();
            }else if (ladder.getTo() == this){
                color = color + "LT" + ladder.getId();
            }
        }
        return color;

    }

    public List<Piece> getPiece() {
        return pieces;
    }

    public void setPiece(Piece piece) {

        this.pieces.add(piece);
    }

    public Spot(int i, int j) {
        this.i = i;
        this.j = j;
        pieces = new ArrayList<>();

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

class Snake{

    private static int count = 0;
    private int id;
    private Spot from;
    private Spot to;

    public int getId() {
        return id;
    }

    public Snake(Spot from, Spot to) {
        this.from = from;
        this.to = to;
        id = count;
        count++;
    }

    public Spot getFrom() {
        return from;
    }

    public void setFrom(Spot from) {
        this.from = from;
    }

    public Spot getTo() {
        return to;
    }

    public void setTo(Spot to) {
        this.to = to;
    }
}

class Ladder{

    private static int count = 0;
    private int id;
    private Spot from;
    private Spot to;

    public Ladder(Spot from, Spot to) {
        this.from = from;
        this.to = to;
        id = count;
        count++;
    }

    public int getId() {
        return id;
    }

    public Spot getFrom() {
        return from;
    }

    public void setFrom(Spot from) {
        this.from = from;
    }

    public Spot getTo() {
        return to;
    }

    public void setTo(Spot to) {
        this.to = to;
    }
}
