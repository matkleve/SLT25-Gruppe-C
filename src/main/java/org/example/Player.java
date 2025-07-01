package org.example;

// Represents a player in the game
public class Player {

    // The player's symbol (e.g., 'X' or 'O')
    private char marker;

    // Constructor: initializes the player with a marker
    public Player(char marker) {
        this.marker = marker;
    }

    // Returns the player's marker
    public char getMarker() {
        return marker;
    }
}