/*
 * @lc app=leetcode.cn id=103 lang=java
 *
 * [103] 二叉树的锯齿形层序遍历
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
import java.util.LinkedList;
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
//     public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
//         if(root==null){
//             return new ArrayList<List<Integer>>();
//         }
//         LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
//         List<List<Integer>> res = new ArrayList<List<Integer>>();
//         queue.add(root);
//         boolean target = true;
//         // ArrayList<Integer> temp1 = new ArrayList<Integer>();
//         // temp1.add(root.val);
//         // res.add(temp1);
//         while(queue.size()>0){
//             int size = queue.size();
//             ArrayList<Integer> temp = new ArrayList<Integer>();
//             if(target) {
//                 for(int i =0;i<size;i++) {
//                     TreeNode t = queue.remove();                   
//                         if(t.right!=null){
//                             queue.add(t.right);
//                             temp.add(t.right.val);
//                         }
//                         if(t.left!=null){
//                             queue.add(t.left);
//                             temp.add(t.left.val);
//                         }                                                        
//                 }
//                 target = false;
//             }else{
//                 for(int i =0;i<size;i++) {
//                     TreeNode t = queue.removeLast();    
//                     if(t.left!=null){
//                         queue.add(t.left);
//                         temp.add(t.left.val);
//                     }
//                     if(t.right!=null){
//                         queue.add(t.right);
//                         temp.add(t.right.val);
//                     }                   
//                 }
//                 target = true;
//             }
//             // if(temp.size()>0){
//             //     res.add(temp);
//             // }
           
//         }
//         return res;
//     }
// }
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root==null) {
            return new ArrayList<List<Integer>>();
        }        
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        
        boolean target = true;
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);

        while(queue.size()>0) {
            
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for(int i=0;i<size;++i) {
                TreeNode t = queue.remove();
                if(target){
                    tmp.add(t.val);
                }else{
                    tmp.add(0,t.val);
                }
                
                if(t.left!=null){
                    queue.add(t.left);
                }
                if(t.right!=null){
                    queue.add(t.right);
                }
                
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
            target = !target;
        }
        return res;
    }
}
// @lc code=end

