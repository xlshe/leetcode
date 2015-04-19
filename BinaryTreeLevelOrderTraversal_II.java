/* Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:
Given binary tree {3,9,20,#,#,15,7},

return its bottom-up level order traversal */

/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        
        LinkedList<List<Integer>> stack = new LinkedList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        
        queue.offer(root);
        int count = 1;
        
        while (!queue.isEmpty()) {
            int tmp = 0;
            LinkedList<Integer> level = new LinkedList<>();
            for (int i=0; i<count; i++) {
                TreeNode n = queue.poll();
                
                level.add(n.val);
                
                if (n.left != null) {
                    queue.offer(n.left);
                    tmp ++;
                }
                if (n.right != null) {
                    queue.offer(n.right);
                    tmp ++;
                }
            }
            count = tmp;
            stack.push(level);
        }
        return stack;
    }
}
