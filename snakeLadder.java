package Assgn3_ladder;

import java.util.Random;

public class snakeLadder {

    private static final int board_size = 100;
    private static final int[] snake_pos = { 4, 10, 25, 27, 39, 44, 51, 63, 76, 83, 91, 97 };
    private static final int[] ladder_pos = { 3, 11, 19, 30, 37, 45, 54, 66, 71, 78 };

    // int initial_pos =0;
    // int diceRoll =0;
    // public snakeLadder() {//initial pos =0
    // this.initial_pos = 0;
    // }
    private int[] initial_pos;
    private int[] diceRoll;

    public snakeLadder(int numPlayers) {
        this.initial_pos = new int[numPlayers];
        this.diceRoll = new int[numPlayers];
    }

    public int roll_dice() {
        Random rand_num = new Random();
        return rand_num.nextInt(6) + 1; // 1-6

    }

    public void movePlayer(int playerIndex, int steps) {
        int newPos = initial_pos[playerIndex] + steps;

        for (int snakePosition : snake_pos) {
            if (newPos == snakePosition) {
                System.out.println("Snake position " + snakePosition);
                System.out.printf("SNAKE BITE!!! Going reverse by ", +steps + " steps");
                System.out.println(
                        "Player " + (playerIndex + 1) + " got a snake bite! Going down to position " + snakePosition);
                initial_pos[playerIndex] = snakePosition - steps;
                return;
            }
        }

        for (int ladderPosition : ladder_pos) {
            if (newPos == ladderPosition) {
                System.out.println("Ladder position " + ladderPosition);
                System.out.printf("GOT A LADDER!!!Climbing up to ", +steps + " steps");
                System.out.println(
                        "Player " + (playerIndex + 1) + " got a snake bite! Going down to position " + ladderPosition);
                initial_pos[playerIndex] = ladderPosition + steps;
                return;
            }
        }
        // initial_pos= newPos;
        if (newPos <= board_size) {
            initial_pos[playerIndex] = newPos;
        }

        // player has reached exactly 100
        if (initial_pos[playerIndex] == board_size) {
            System.out.println("Player " + (playerIndex + 1) + " reached the end of the board in "
                    + diceRoll[playerIndex] + " moves!");
        }

    }

    public void playGame() {
        int currPlayer = 0;
        while (true) {
            int diceVal = roll_dice();
            diceRoll[currPlayer]++;
            System.out.println("Player " + (currPlayer + 1) + " rolled a " + diceVal);

            movePlayer(currPlayer, diceVal);
            // System.out.println("\nYour current position is "+ initial_pos);
            System.out.println("Player " + (currPlayer + 1) + " is now at position " + initial_pos[currPlayer]);
            System.out.println();

            try {
                Thread.sleep(1000); // Pause
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            // System.out.println("The number of times dice is thrown "+diceRoll);

            if (diceVal != 6) {
                currPlayer = (currPlayer + 1) % initial_pos.length; // Move to the next player
            }

            // Check if any player has won
            for (int i = 0; i < initial_pos.length; i++) {
                if (initial_pos[i] >= board_size) {
                    System.out.println("Player " + (i + 1) + " won the game!");
                    return;
                }
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("WELCOME TO SNAKE LADDER GAME");
        int numPlayers = 2;
        snakeLadder sl = new snakeLadder(numPlayers);
        sl.playGame();
        System.out.println("Congratulations! Player reached the end of the board!");

    }
}
