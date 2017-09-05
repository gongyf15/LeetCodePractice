import java.util.*;

/**
 * Question:
 * You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

 For example, given:
 s: "barfoothefoobarman"
 words: ["foo", "bar"]

 You should return the indices: [0,9].
 (order does not matter).
 *
 * Wrong answer
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int len = words[0].length();
        int len2 = words.length;
        int j=len*len2;
        List<Integer> r =new ArrayList<Integer>();
        HashSet<String> base = new HashSet<String>();
        for(String sSub:words) base.add(sSub);
        HashSet<String> h = new HashSet<String>();
        for(int i=0;i<=s.length()-j;i++){
            for(int ss=0; ss<len2; ss++){
                String strSub = s.substring(i+ss*len, i+(ss+1)*len);
                if(!base.contains(strSub) || h.contains(strSub)){
                    h.clear();
                    break;
                }
                else{
                    h.add(strSub);
                    if(h.size()==len2){
                        r.add(i);
                        h.clear();
                        break;
                    }
                }
            }
        }
        return r;
    }

}

/*
 * 用滑动窗口法，类似
 */
