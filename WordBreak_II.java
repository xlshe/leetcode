/*
Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
*/


public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        Map<Integer, List<String>> cached = new HashMap<>();
        List<String> result = helper(s, 0, wordDict, cached);
        if (result == null) {
            return Collections.EMPTY_LIST;
        }
        return result;
    }
    
    public List<String> helper(String s, int start, Set<String> wordDict, Map<Integer, List<String>> cached) {
        List<String> result = new ArrayList<>();
        
        if (start == s.length()) {
            return result;
        }
        
        if (cached.containsKey(start)) {
            return cached.get(start);
        }
        
        for (int i=start; i<s.length(); i++) {
            String sub = s.substring(start, i+1);
            if (wordDict.contains(sub)) {
                List<String> subresult = helper(s, i+1, wordDict, cached);
                if (subresult != null) {
                    if (subresult.isEmpty()) {
                        result.add(sub);
                    } else {
                        for (String tmp : subresult) {
                            result.add(sub + " " + tmp);
                        }
                    }
                }
            }
        }
        if (result.isEmpty()) {
            cached.put(start, null);
            return null;
        }
        cached.put(start, result);
        return result;
    }
    
}
