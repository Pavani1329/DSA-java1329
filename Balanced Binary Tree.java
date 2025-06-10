/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isBalanced(TreeNode root){
        return height(root)!=-1;
    }
    int height(TreeNode node){
        if (node==null)return 0;
        int l=height(node.left),r=height(node.right);
        if(l==-1||r==-1||l-r>1||r-l>1)return -1;
        return(l>r?l:r)+1;
    }
}
