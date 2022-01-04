/*
 * @lc app=leetcode.cn id=98 lang=java
 *
 * [98] 验证二叉搜索树
 */

// @lc code=start
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
class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Long.MAX_VALUE,Long.MIN_VALUE);
    }
    public boolean isValidBST(TreeNode root, long upper, long lower) {
        if(root == null) {
            return true;
        }
        if(root.val>=upper|| root.val<=lower){
            return false;
        }
        return isValidBST(root.left,root.val,lower) 
        && isValidBST(root.right,upper,root.val);
    }
}

// @lc code=end

