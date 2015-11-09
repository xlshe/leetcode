/*
Remove the minimum number of invalid parentheses in order to make the input string valid. Return all possible results.

Note: The input string may contain letters other than the parentheses ( and ).

Examples:
"()())()" -> ["()()()", "(())()"]
"(a)())()" -> ["(a)()()", "(a())()"]
")(" -> [""]

*/


public class Solution {
    public List<String> removeInvalidParentheses(String s) {
        
        int openCount = 0, closeCount = 0;
        for (int i=0; i<s.length(); i++) {
            if (s.charAt(i) == '(') {
                openCount ++;
            } else if (s.charAt(i) == ')') {
                if (openCount > 0) {
                    openCount --;
                } else {
                    closeCount ++;
                }
            }
        }
        
        List<String> result = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        helper(s, 0, sb, 0, openCount, closeCount, result);
        return result;
    }
    
    private void helper(String s, int pos, StringBuffer sb, int count, int openCount, int closeCount, List<String> result) {
        
        if (count < 0) {
            return;
        }
        
        if (pos == s.length()) {
            if (count == 0 && openCount == 0 && closeCount == 0) {
                result.add(sb.toString());
            }
            return;
        }
        
        char ch = s.charAt(pos);
        if (ch != '(' && ch != ')') {
            sb.append(ch);
            helper(s, pos + 1, sb, count, openCount, closeCount, result);
            sb.delete(sb.length() - 1, sb.length());
            return;
        }
        
        if (ch == '(') {
            int cnt = 0;
            while (pos+cnt < s.length() && s.charAt(pos+cnt) == '(') {
                cnt ++;
            }
            for (int i=0; i<cnt; i++) {
                sb.append('(');
            }
            helper(s, pos+cnt, sb, count+cnt, openCount, closeCount, result);
            sb.delete(sb.length()-cnt, sb.length());
            
            if (openCount > 0) {
                helper(s, pos+1, sb, count, openCount - 1, closeCount, result);
            }
        } else if (ch == ')') {
            int cnt = 0;
            while (pos+cnt < s.length() && s.charAt(pos+cnt) == ')') {
                cnt ++;
            }
            for (int i=0; i<cnt; i++) {
                sb.append(')');
            }
            helper(s, pos+cnt, sb, count-cnt, openCount, closeCount, result);
            sb.delete(sb.length()-cnt, sb.length());

            
            if (closeCount > 0) {
                helper(s, pos+1, sb, count, openCount, closeCount-1, result);
            }
        }
    }
}
