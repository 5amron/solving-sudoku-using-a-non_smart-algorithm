import java.util.Random;

public class Main{
    static int[] sudoku_board;
    public static int[][] new_sudoku_board;
    
    public static void main(String[] args) {

        Main main = new Main();

        new_sudoku_board = new int[9][9];
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                new_sudoku_board[i][j]=0;
            }

        }
        sudoku_board = new int[] {
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1,
                9,8,7,6,5,4,3,2,1 };
        
        int l=0;
        int m=0;
        for (int i = 0; i < 9; i++) {
            for (int k = 0; k < 9; k++) {

                m = sudoku_board[l];
                sudoku_board[l] = 0;
                new_sudoku_board[i][k] = m;
                l++;
            }
        }
        System.out.println("Initial Board :");
        System.out.println(" ");
        System.out.println(main.print_sudoku());

//            System.out.print(sudoku_board[j] + (j % 9 == 0 ? "\n" : " "));
//            System.out.println();

//        int mine;
//        for (int j = 0; j < 81;j++) {
//
//
//        }

        //System.out.println("hello");
        int r_1;
        int r_2;
        Random rr;
        rr = new Random();

        int max = 9;
        int min = 0;
        r_1 = rr.nextInt(max - min + 1) + min;

//        r_1 = rr.nextInt(9);
//        r_2 = r2.nextInt(9);
        //r_2=r_2*3;

        sudoku_board[r_1] = 1;

        long time = System.nanoTime();
        checking();
        time = System.nanoTime() - time;
        System.out.println("duration: " + time/1000000 + " ms");
        //System.out.println(main.print_sudoku());

        System.out.println("hello");
        for (int j = 0; j < 81;) {
            System.out.print(sudoku_board[j++] + (j % 9 == 0 ? "\n" : " "));

        }

        }

    public String print_sudoku(){
        StringBuilder out = new StringBuilder();

        for(int i = 0; i < new_sudoku_board.length; i++){
            if(i == 3 || i == 6){
                System.out.println(" ");
            }
            for(int j = 0; j < new_sudoku_board[i].length; j++){
                if(j == 3 || j == 6){
                    
                    out.append('|');
                }

                if(new_sudoku_board[i][j] > 0){
                    out.append(new_sudoku_board[i][j]);
                    
                    
                }
                else
                    out.append('_');

                out.append(' ');
            }
            out.append('\n');
        }
        return out.toString();
    }


    static boolean checking() {
        for (int element = 0, kk, i; element < 81; element++)
            if (sudoku_board[element] < 1) {
                go: for (kk = 0; kk++ < 9;) {
                    for (i = 0; i < 9; i++) {
                        if (sudoku_board[element % 9 + 9 * i] == kk
                                | sudoku_board[(element - element % 3) % 9 + element / 27 * 27 + i % 3 + i / 3 * 9] == kk
                                | sudoku_board[element / 9 * 9 + i] == kk) {
                            continue go;
                        }
                    }
                    sudoku_board[element] = kk;
                    if (checking()){
                        return true;
                    }
                    sudoku_board[element] = 0;
                }
                return false;
            }
        return true;
    }



}









