package com.HackerEarth.chess;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Board {

    public static final String BLACK = "Black";
    public static final String WHITE = "White";

    private Spot[][] spots = new Spot[8][8];

    public Board() {
        super();
        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                this.spots[i][j] = new Spot(i, j);
            }
        }
    }

    public Spot getSpot(int x, int y) {
        return spots[x][y];
    }

    public List<Spot> getAllDiagonalSpots(int fromX, int fromY, int toX, int toY) {

        List<Spot> spots = new ArrayList<>();
        // diagonal up
        if (fromX < toX && fromY < toY) {
            while (fromX != fromY && toX != toY) {
                spots.add(getSpot(fromX++, fromY++));
            }
        }

        if (fromX < toX && fromY > toY) {
            while (fromX != fromY && toX != toY) {
                spots.add(getSpot(fromX++, fromY--));
            }
        }

        if (fromX > toX && fromY < toY) {
            while (fromX != fromY && toX != toY) {
                spots.add(getSpot(fromX--, fromY++));
            }
        }

        if (fromX > toX && fromY > toY) {
            while (fromX != fromY && toX != toY) {
                spots.add(getSpot(fromX--, fromY--));
            }
        }

        return spots;

    }

    public List<Spot> getAllStraightSpots(int fromX, int fromY, int toX, int toY) {

        List<Spot> spots = new ArrayList<>();

        if (fromX == toX && fromY < toY) {
            while (fromY != toY && fromY + 1 != toY) {
                spots.add(getSpot(fromX, ++fromY));
            }
        }

        if (fromX == toX && fromY > toY) {
            while (fromY != toY && fromY - 1 != toY) {
                spots.add(getSpot(fromX, --fromY));
            }
        }

        if (fromY == toY && fromX < toX) {
            while (fromX != toX && fromX + 1 != toX) {
                spots.add(getSpot(++fromX, fromY));
            }
        }

        if (fromY == toY && fromX > toX) {
            while (fromX != toX && fromX - 1 != toX) {
                spots.add(getSpot(--fromX, fromY));
            }
        }

        return spots;

    }

    public void print() {

        for (int i = 0; i < spots.length; i++) {
            for (int j = 0; j < spots.length; j++) {
                if (this.spots[i][j].piece == null) {
                    System.out.print("--");
                } else {
                    System.out.print(this.spots[i][j].piece.getName());
                }

            }
        }
    }

}
