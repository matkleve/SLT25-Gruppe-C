package org.example;

import java.util.Scanner;

public class TicTacToe {
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private Board board;

    public TicTacToe() {
        playerX = new Player('X');
        playerO = new Player('O');
        currentPlayer = playerX;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();

        while (true) {
            board.print();
            System.out.println("Spieler " + currentPlayer.getMarker() + " ist am Zug.");
            System.out.print("Zeile (1-3): ");
            int x = scanner.nextInt() - 1;
            System.out.print("Spalte (1-3): ");
            int y = scanner.nextInt() - 1;

            if (board.isCellEmpty(x, y)) {
                board.place(x, y, currentPlayer.getMarker());

                if (hasWinner()) {
                    board.print();
                    System.out.println("Spieler " + currentPlayer.getMarker() + " gewinnt!");
                    break;
                }

                if (board.isFull()) {
                    board.print();
                    System.out.println("Unentschieden!");
                    break;
                }

                switchCurrentPlayer();
            } else {
                System.out.println("Feld ist bereits belegt. Nochmal versuchen.");
            }
        }
        scanner.close();
    }

    private void switchCurrentPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    private boolean hasWinner() {
        char[][] c = board.getCells();
        char m = currentPlayer.getMarker();

        for (int i = 0; i < 3; i++) {
            if ((c[i][0] == m && c[i][1] == m && c[i][2] == m) ||
                    (c[0][i] == m && c[1][i] == m && c[2][i] == m)) {
                return true;
            }
        }

        if ((c[0][0] == m && c[1][1] == m && c[2][2] == m) ||
                (c[0][2] == m && c[1][1] == m && c[2][0] == m)) {
            return true;
        }

        return false;
    }
}
