import java.util.ArrayList;
import java.util.List;

/**
 * Created by gongyuanfeng on 2017/8/29.
 * 回溯超时了9的时候（不要用StringBuilder,用char[][]）
 */
public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> r = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<n;i++)
            sb.append(".");

        //(i,j):j-i+(n-1)为所在对角斜边cross的维数，i+j为反对角斜边
        backtrace(r , new ArrayList<>(), new int[2][2*n-1], new int[n], n, sb);

        return r;
    }

    private void backtrace(List<List<String>> r, List<String> strs,int[][] cross, int[] column, int n, StringBuilder sb){
        if( strs.size() == n ){
            r.add(new ArrayList<>(strs));
            return;
        }

        int j = strs.size();
        for(int i=0; i<n ;i++){
            if(column[i]==0&&cross[0][i-j+n-1]==0&&cross[1][i+j]==0){
                sb.replace(i,i+1,"Q");
                strs.add(sb.toString());
                sb.replace(i,i+1,".");

                column[i]=1;
                cross[0][i-j+n-1]=1;
                cross[1][i+j]=1;
                backtrace(r , strs, cross,column, n, sb);
                column[i]=0;
                cross[0][i-j+n-1]=0;
                cross[1][i+j]=0;
                strs.remove(strs.size()-1);
            }
        }

    }

    public static void main(String[] args){
        Solution s = new Solution();
        s.solveNQueens(4);
    }
}
