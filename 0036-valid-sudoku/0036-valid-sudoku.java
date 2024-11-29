class Solution {
    public boolean isValidSudoku(char[][] board) {
      //rows check
        for(int row = 0; row <= 8; row++){
            if(!isValidRange(board, row, row, 0, 8)){
                return false;
            }
        }
        //cols check
        for(int col = 0; col <= 8; col++){
            if(!isValidRange(board, 0, 8, col, col)){
                return false;
            }
        }
        //boxes
        for(int i = 0; i <= 2; i++){
            for(int j = 0; j <= 2; j++){
                if(!isValidRange(board, i*3, i*3+2, j*3, j*3+2)){
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidRange(char[][] board, int rS, int rE, int cS, int cE){
        boolean[] numUsed = new boolean[10];

        for(int row = rS; row  <= rE; row++){
            for(int col = cS; col <= cE; col ++){
                if(board[row][col] != '.'){
                    //checks for duplicates
                    if(numUsed[board[row][col] - '0']){
                        return false;
                    }
                    //marks digits as used
                    numUsed[board[row][col] - '0'] = true;
                }
            }
        }
        return true;
    }
}