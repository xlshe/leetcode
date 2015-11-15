/*
Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]
Return ["eat","oath"].
*/

public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        
        TreeNode root = buildPrefixTree(words);
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                helper(result, root, board, visited, i, j);
            }
        }
        
        return new ArrayList(result);
    }
    
    private void helper(Set<String> result, TreeNode root, char[][] board, boolean[][] visited, int x, int y) {
        
        if (root == null) {
            return;
        }
        
        if (root.val != null) {
            result.add(root.val);
        }
        
        if (x < 0 || y < 0 || x >= board.length || y >= board[0].length) {
            return;
        }
        
        if (visited[x][y]) {
            return;
        }
        
        char ch = board[x][y];
        visited[x][y] = true;
        if (root.children[ch-'a'] != null) {
            helper(result, root.children[ch-'a'], board, visited, x + 1, y);
            helper(result, root.children[ch-'a'], board, visited, x - 1, y);
            helper(result, root.children[ch-'a'], board, visited, x, y + 1);
            helper(result, root.children[ch-'a'], board, visited, x, y - 1);
        }
        visited[x][y] = false;
    }
    
    private class TreeNode {
        public char key;
        public String val;
        public TreeNode[] children;
        
        public TreeNode(char key, String val) {
            this.key = key;
            this.val = val;
            children = new TreeNode[26];
        }
    }
    
    TreeNode buildPrefixTree(String[] words) {
        TreeNode root = new TreeNode('^', null);
        for (String word : words) {
            TreeNode n = root;
            for (char ch : word.toCharArray()) {
                if (n.children[ch-'a'] == null) {
                    n.children[ch-'a'] = new TreeNode(ch, null);
                }
                n = n.children[ch - 'a'];
            }
            n.val = word;
        }
        return root;
    }
}
