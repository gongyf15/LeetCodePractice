import java.util.HashSet;
import java.util.Set;

/**
 * Created by gongyuanfeng on 2017/8/28.
 */
public class Solution {
    private boolean isValid(char[][] board, int row, int col, char c){
        for(int i = 0; i < 9; i++) {
            if(board[i][col] != '.' && board[i][col] == c) return false; //check row
            if(board[row][i] != '.' && board[row][i] == c) return false; //check column
            if(board[3 * (row / 3) + i / 3][ 3 * (col / 3) + i % 3] != '.' &&
                    board[3 * (row / 3) + i / 3][3 * (col / 3) + i % 3] == c) return false; //check 3*3 block
        }
        return true;
    }

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board){
        int n = board.length;

        //fill
        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j]=='.'){
                    int k=i/3*3+j/3;//第几个格子
                    for(int num=0; num<9;num++){
                        char t = (char)('0' + num + 1);
                        if(isValid(board,i,j,t)){
                            board[i][j] = t;

                            if(solve(board))
                                return true;
                            else board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
}
