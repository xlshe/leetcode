public class WordBreak {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        if (wordDict == null || wordDict.size() == 0) {
            return false;
        }
        
        boolean[] matches = new boolean[s.length()];
        for (int i=0; i<s.length(); i++) {
            matches[i] = false;
        }
        
        for (int i=0; i<s.length(); i++) {
            if (wordDict.contains(s.substring(0, i+1))) {
                matches[i] = true;
                continue;
            }
            
            for (int j=i; j>0; j--) {
                if (matches[j-1] && wordDict.contains(s.substring(j, i+1))) {
                    matches[i] = true;
                    break;
                }
            }
        }
        return matches[s.length() - 1];
    }
}
