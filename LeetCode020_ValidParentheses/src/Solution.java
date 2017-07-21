import java.util.Stack;

/**
 * Created by gongyuanfeng on 2017/7/21.
 */
public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stk = new Stack<Character>();
        for(int i=s.length()-1;0<=i;i--){
            if(!stk.isEmpty() && ((stk.peek()==']'&&s.charAt(i)=='[') || (stk.peek()=='}'&&s.charAt(i)=='{') || (stk.peek()==')'&&s.charAt(i)=='('))){
                stk.pop();
            }
            else
                stk.push(s.charAt(i));
        }
        if(stk.isEmpty()) return true;
        return false;
    }

}
