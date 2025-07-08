package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void playerShouldReturnCorrectMarker() {
        Player playerX = new Player('X');
        Player playerO = new Player('O');

        assertEquals('X', playerX.getMarker(), "Marker von playerX sollte 'X' sein");
        assertEquals('O', playerO.getMarker(), "Marker von playerO sollte 'O' sein");
    }
}
