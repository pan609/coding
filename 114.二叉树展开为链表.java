/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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

import java.util.ArrayList;
import java.util.List;

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
// class Solution {
//     public void flatten(TreeNode root) {
//         List<TreeNode> list = new ArrayList<TreeNode>();
//         preorderTraversal(root, list);
//         int size = list.size();
//         for (int i = 1; i < size; i++) {
//             TreeNode prev = list.get(i - 1), curr = list.get(i);
//             prev.left = null;
//             prev.right = curr;
//         }
//     }

//     public void preorderTraversal(TreeNode root, List<TreeNode> list) {
//         if (root != null) {
//             list.add(root);
//             preorderTraversal(root.left, list);
//             preorderTraversal(root.right, list);
//         }
//     }
// }

class Solution {
    List<String> res = new ArrayList<String>();
    public void flatten(TreeNode root) {
        if(root == null){
            return;
        }
        flatten(root.left);
        flatten(root.right);
        TreeNode tmp=root.right;
       root.right = root.left;
        root.left = null;
        while(root.right !=null){
            root = root.right;
        }
        root.right = tmp;
        
    }

    
}
// @lc code=end

