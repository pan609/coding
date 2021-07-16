/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
import java.util.LinkedList;
import java.util.Queue;




class Solution {
    public Node connect(Node root) {
        if(root == null){
            return root;
        }
        Queue<Node> queue = new LinkedList<Node>(); 
        queue.add(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0 ;i<size;i++){
               Node node = queue.poll();
                if(i<size-1){
                    node.next =queue.peek();
                }
                if(node.left!=null){
                    queue.add(node.left);
                    queue.add(node.right);
                }
                    
            }
            
        }

        return root;
    }
}

// @lc code=end

