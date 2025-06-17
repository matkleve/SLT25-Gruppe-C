package org.example;

public class TicTacToe {
    private Player player1;
    private Player player2;
    private Player currentPlayer;
    private Board board;

    
    public TicTacToe() {
        player1 = new Player('X');
        player2 = new Player('O');
        currentPlayer = player1;
        board = new Board();
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        board.clear();

        while (true) {
            board.print();
            System.out.println("Spieler " + currentPlayer.getMarker() + " ist am Zug.");
            System.out.print("Zeile (0-2): ");
            int x = scanner.nextInt();
            System.out.print("Spalte (0-2): ");
            int y = scanner.nextInt();

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
        currentPlayer = (currentPlayer == player1) ? player2 : player1;
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
