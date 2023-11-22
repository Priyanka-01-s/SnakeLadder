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
        int dice_val =  rand_num.nextInt(6) + 1; // 1-6
        return dice_val;
    }

    public void movePlayer(int steps){
        int newPos = initial_pos + steps;
        
        int dice_val = roll_dice();
        for(int snakePosition : snake_pos){
            if(newPos == snakePosition){
                System.out.printf("SNAKE BITE!!! Going reverse by ",+ dice_val+" steps");
                newPos -= dice_val;
                return;
            }
        }

        for(int ladderPosition : ladder_pos){
            if(newPos == ladderPosition){
                System.out.printf("GOT A LADDER!!!Climbing up to ",+ dice_val+ " steps");
                newPos += dice_val;
                return;
            }
        }
        initial_pos = newPos;

    }
    public static void main(String[] args) {
        System.out.println("WELCOME TO SNAKE LADDER GAME");
        //snakeLadder sl= new snakeLadder();
        
    }
}
