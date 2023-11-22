package Assgn3_ladder;

import java.util.Random;

public class snakeLadder {

    private static final int board_size = 100;
    private static final int[] snake_pos ={4,10,25,27,39,44,51,63,76,83,91,97};
    private static final int[] ladder_pos ={3,11,19,30,37,45,54,66,71,78};

    int initial_pos =0;

    public snakeLadder() {//initial pos =0
        this.initial_pos = 0;
    }

    public int roll_dice(){
        Random rand_num = new Random();
        return rand_num.nextInt(6) + 1; // 1-6
         
    }

    public void movePlayer(int steps){
        int newPos = initial_pos + steps;
        
        for(int snakePosition : snake_pos){
            if(newPos == snakePosition){
                System.out.println("Snake position "+snakePosition);
                System.out.printf("SNAKE BITE!!! Going reverse by ", + steps+" steps");
                initial_pos =newPos-steps;
                return;
            }
        }

        for(int ladderPosition : ladder_pos){
            if(newPos == ladderPosition){
                System.out.println("Ladder position "+ladderPosition);
                System.out.printf("GOT A LADDER!!!Climbing up to ",+ steps+ " steps");
                initial_pos = newPos + steps;
                return;
            }
        }
        //initial_pos= newPos;
        if(newPos <0){
            initial_pos =0;
        }
        else if(newPos > board_size) {
            initial_pos = newPos-steps;
        }else{
            initial_pos= newPos;
        }
        System.out.println("YOUR UPDATED POSITION IS : "+ newPos);

        
    }

    public void playGame(){
        while (initial_pos<board_size) {
            int diceVal = roll_dice();
            System.out.println("You rolled a " + diceVal);

            movePlayer(diceVal);
            System.out.println("\nYour current position is "+ initial_pos);

            try {
                Thread.sleep(1000); // Pause 
            } catch (InterruptedException e) {
                e.printStackTrace();
            }           

        }
    }
    public static void main(String[] args) {
        System.out.println("WELCOME TO SNAKE LADDER GAME");
        snakeLadder sl= new snakeLadder();
        sl.playGame();
        System.out.println("Congratulations! Player reached the end of the board!");
        
    }
}
