/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeRightSideView {
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return new LinkedList<>();
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        LinkedList<Integer> result = new LinkedList<>();
        int levelCnt = 1;
        queue.offer(root);
        while(!queue.isEmpty()) {
            int cnt = 0;
            for (int i=0; i<levelCnt; i++) {
                TreeNode node = queue.poll();
                if (i == levelCnt - 1) {
                    result.offer(node.val);
                }
                if (node.left != null) {
                    queue.offer(node.left);
                    cnt ++;
                }
                if (node.right != null) {
                    queue.offer(node.right);
                    cnt ++;
                }
            }
            levelCnt = cnt;
        }
        return result;
    }
}
