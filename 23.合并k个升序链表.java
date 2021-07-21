/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        // if(lists == null){
        //     return null;
        // }
        // if(lists.length == 1){
        //     return lists[0];
        // }
        // if(lists.length == 2){
        //     return test( lists[0], lists[1]);
        // }
        // ListNode tempList3 = new ListNode();
        // ListNode tempList2 = new ListNode();
        // ListNode tempList =tempList3;
        // for(int i = 0;i<lists.length;i++) {
        //     tempList2 = lists[i];
        //     tempList = test(tempList,tempList2);
        // }
        // return tempList3.next;
        ListNode ans = null;
        for (int i = 0; i < lists.length; ++i) {
            ans = test(ans, lists[i]);
        }
        return ans;
    }

    public ListNode test(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2; 
        } 
         if(list2 == null){
            return list1;
        }


        ListNode l1 = new ListNode(-1);
        ListNode l2 = l1;
        while(list1!=null && list2!=null){
            if(list1.val<list2.val){
                l2.next = list1;
                list1 = list1.next;
            }else{
                l2.next = list2;
                list2 = list2.next;
            }

            l2=l2.next;
        }

        // if(list1 == null) {
        //     l2.next = list2;
        // } else{
        //     l2.next = list1;
        // }
        l2.next = list1 == null ? list2 : list1;

        return l1.next;

    }
}
// @lc code=end

