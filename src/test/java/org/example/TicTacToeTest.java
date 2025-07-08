package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TicTacToeTest {

    private TicTacToe game;

    @BeforeEach
    void setUp() {
        game = new TicTacToe();
    }

    @Test
    void constructorShouldInitializePlayersAndBoard() {
        assertNotNull(game.getPlayerX());
        assertNotNull(game.getPlayerO());
        assertNotNull(game.getBoard());
        assertEquals('X', game.getPlayerX().getMarker());
        assertEquals('O', game.getPlayerO().getMarker());
        assertEquals(game.getPlayerX(), game.getCurrentPlayer());
    }

    @Test
    void switchCurrentPlayerShouldTogglePlayers() {
        assertEquals(game.getPlayerX(), game.getCurrentPlayer());
        game.switchCurrentPlayer();
        assertEquals(game.getPlayerO(), game.getCurrentPlayer());
        game.switchCurrentPlayer();
        assertEquals(game.getPlayerX(), game.getCurrentPlayer());
    }

    @Test
    void hasWinnerDetectsRowWin() {
        // Setze eine Reihe komplett mit 'X'
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'X';
        cells[0][1] = 'X';
        cells[0][2] = 'X';

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerDetectsColumnWin() {
        char[][] cells = game.getBoard().getCells();
        cells[0][1] = 'O';
        cells[1][1] = 'O';
        cells[2][1] = 'O';

        // Spieler O ist dran
        game.setCurrentPlayer(game.getPlayerO());

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerDetectsDiagonalWin() {
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'X';
        cells[1][1] = 'X';
        cells[2][2] = 'X';

        assertTrue(game.hasWinner());
    }

    @Test
    void hasWinnerReturnsFalseWhenNoWinner() {
        char[][] cells = game.getBoard().getCells();
        cells[0][0] = 'X';
        cells[0][1] = 'O';
        cells[0][2] = 'X';

        assertFalse(game.hasWinner());
    }
}
