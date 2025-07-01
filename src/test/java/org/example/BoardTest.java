package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BoardTest {

    private Board board;

    /**
     * Diese Methode wird vor jedem Test aufgerufen.
     * Hier wird ein frisches Board-Objekt erzeugt, damit
     * jeder Test unabhängig und sauber startet.
     */
    @BeforeEach
    void setUp() {
        board = new Board();
    }

    /**
     * Testet, ob das Board nach der Initialisierung komplett leer ist.
     * Jede Zelle sollte ein Leerzeichen ' ' enthalten.
     */
    @Test
    void boardShouldBeEmptyAfterInitialization() {
        // Schleife über alle 3x3 Zellen
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                // Prüft, ob die Zelle leer ist
                assertTrue(board.isCellEmpty(i, j), "Cell (" + i + "," + j + ") should be empty");
            }
        }
    }

    /**
     * Testet, ob ein Marker (z.B. 'X') korrekt in eine leere Zelle gesetzt wird.
     */
    @Test
    void placeMarkerShouldSetCell() {
        // Zuerst sicherstellen, dass die Zelle leer ist
        assertTrue(board.isCellEmpty(0, 0));

        // Platziere einen Marker 'X' in die Zelle (0,0)
        board.place(0, 0, 'X');

        // Danach darf die Zelle nicht mehr leer sein
        assertFalse(board.isCellEmpty(0, 0));

        // Und der Wert der Zelle muss 'X' sein
        assertEquals('X', board.getCells()[0][0]);
    }

    /**
     * Testet, dass eine belegte Zelle nicht durch einen neuen Marker überschrieben
     * wird.
     * Das Board soll den ursprünglichen Marker behalten.
     */
    @Test
    void placeMarkerShouldNotOverwriteExisting() {
        // Marker 'O' in die Zelle (1,1) setzen
        board.place(1, 1, 'O');

        // Versuch, die Zelle (1,1) mit 'X' zu überschreiben (soll nicht klappen)
        board.place(1, 1, 'X');

        // Überprüfe, dass der ursprüngliche Marker 'O' erhalten bleibt
        assertEquals('O', board.getCells()[1][1], "Cell should not be overwritten");
    }

    /**
     * Testet, dass isFull() false zurückgibt,
     * wenn das Board noch leere Zellen enthält.
     */
    @Test
    void boardIsFullReturnsFalseIfEmptyCells() {
        // Leeres Board vorbereiten
        board.clear();

        // Das Board ist leer, also nicht voll
        assertFalse(board.isFull());

        // Setze einen Marker, es sind aber noch freie Zellen vorhanden
        board.place(0, 0, 'X');

        // Board sollte immer noch nicht voll sein
        assertFalse(board.isFull());
    }

    /**
     * Testet, dass isFull() true zurückgibt,
     * wenn alle Zellen mit Markern belegt sind.
     */
    @Test
    void boardIsFullReturnsTrueWhenNoEmptyCells() {
        // Board komplett füllen (alle 9 Zellen)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.place(i, j, 'X');
            }
        }

        // Board ist nun voll
        assertTrue(board.isFull());
    }

    /**
     * Testet, dass die Methode clear() das Board wieder komplett leert.
     * Nach clear() sollten alle Zellen wieder leer sein.
     */
    @Test
    void clearEmptiesTheBoard() {
        // Setze zuerst einen Marker
        board.place(0, 0, 'X');

        // Leere das Board
        board.clear();

        // Überprüfe, dass jede Zelle leer ist
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertTrue(board.isCellEmpty(i, j));
            }
        }
    }
}
