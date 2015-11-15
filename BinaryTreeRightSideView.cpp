 /**
* Definition for binary tree
* struct TreeNode {
*     int val;
*     TreeNode *left;
*     TreeNode *right;
*     TreeNode(int x) : val(x), left(NULL), right(NULL) {}
* };
*/
class Solution {
public:
    vector<int> rightSideView(TreeNode *root) {
        vector<int> right_side;
        rightSide(root, right_side, 0);
        return right_side;
    }
    void rightSide(TreeNode *r, vector<int> &a, int i)
    {
        if (r == NULL)return;
        if (i == a.size())
            a.push_back(r->val);
        rightSide(r->right, a, i + 1);
        rightSide(r->left, a, i + 1);
    }
};
