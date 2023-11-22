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
    public static void main(String[] args) {
        System.out.println("WELCOME TO SNAKE LADDER GAME");
        //snakeLadder sl= new snakeLadder();
        
    }
}
