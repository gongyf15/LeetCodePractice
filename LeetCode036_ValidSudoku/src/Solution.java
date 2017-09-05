import java.util.HashSet;
import java.util.Set;

/**
 * Created by gongyuanfeng on 2017/8/28.
 * Three flags are used to check whether a number appear.

    used1: check each row

    used2: check each column

    used3: check each sub-boxes
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int n = board.length;
        int[][] row = new int[n][n];
        int[][] column = new int[n][n];
        int[][] box = new int[n][n];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]!='.'){
                    int num = board[i][j]-'0'-1;
                    int k=i/3*3+j/3;//第几个格子
                    if(row[i][num]==1||column[j][num]==1||box[k][num]==1) return false;
                    else row[i][num]= column[j][num]= box[k][num]= 1;
                }
            }
        }
        return true;
    }

    public static void main(String[] args){
        System.out.print(1);
    }
}
