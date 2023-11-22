package Assgn3_ladder;

public class snakeLadder {

    private static final int board_size = 100;
    private static final int[] snake_pos ={4,10,25,27,39,44,51,63,76,83,91,97};
    private static final int[] ladder_pos ={3,11,19,30,37,45,54,66,71,78};

    int initial_pos =0;

    public snakeLadder() {//initial pos =0
        this.initial_pos = 0;
    }
    public static void main(String[] args) {
        System.out.println("WELCOME TO SNAKE LADDER GAME");
        //snakeLadder sl= new snakeLadder();
        
    }
}
