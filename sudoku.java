public class sudoku {

    public static void printSodoku(int sudoku[][]) {
        for (int i = 0; i < sudoku.length; i++) {
            for (int j = 0; j < sudoku.length; j++) {
                System.out.print(sudoku[i][j] + " ");
            }
            System.out.println();
        }    
    }

    public static boolean isSafe(int sudoku[][], int row, int col, int digit){
        //row
        for (int j = 0; j <= 8; j++) {
            if (sudoku[row][j] == digit) {
                return false;
            }
        }

        //column
        for (int i = 0; i <= 8; i++) {
            if (sudoku[i][col] == digit) {
                return false;
            }
        }
        //grid check
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        for (int i = sr; i < sr+3; i++) {
            for (int j = sc; j < sc+3; j++) {
                if(sudoku[i][j] == digit){
                    return false;
                }
            }
        }

        return true;
    }
    public static boolean sudokuSolver(int sudoku[][], int row, int col){
        //base case
        if (row == 9 && col == 0) {
            return true;
        }

        //recursion
        int nextRow = row, nextCol = col+1;
        if (col+1 == 9) {
            nextCol = 0;
            nextRow = row + 1;
        }

        if(sudoku[row][col] != 0){
            return sudokuSolver(sudoku, nextRow, nextCol);
        }

        for(int digit = 1; digit <= 9; digit++){
            if(isSafe(sudoku, row , col , digit)) {
                sudoku[row][col] = digit;
                if (sudokuSolver(sudoku, nextRow, nextCol) ){
                    return true;
                }
                sudoku[row][col] = 0;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int sudoku[][] = {
            {0,0,3,9,0,6,0,0,0},
            {0,0,0,0,0,0,0,8,7},
            {0,0,0,4,0,0,0,0,0},
            {0,0,0,0,2,0,0,5,0},
            {6,0,0,0,0,0,9,0,0},
            {4,0,0,0,0,0,0,0,0},
            {0,0,0,5,0,0,6,0,4},
            {0,8,0,0,7,0,0,0,0},
            {0,2,0,0,0,0,0,0,0}};

        if (sudokuSolver(sudoku, 0, 0)) {
            System.out.println("Solution Exist");
            printSodoku(sudoku);
        } else {
            System.out.println("Solution does not exist");
        }
        
        
    }
    
}
