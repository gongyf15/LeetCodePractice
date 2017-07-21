/**
 * Created by gongyuanfeng on 2017/7/21.
 * 较好的方法：分而治之
 * 更好的方法，二分查找
 * 最好的方法，Trie结构
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        if(strs.length == 1) return strs[0];
        String result = strs[0];

        for(int i=1;i<strs.length;i++){
            int j;
            for(j=0;j<Math.min(result.length(), strs[i].length()); j++){
                if(result.charAt(j) != strs[i].charAt(j)){
                    result = result.substring(0,j);
                    break;
                }
            }
            result = result.substring(0,j);
        }

        return result;
    }

}
