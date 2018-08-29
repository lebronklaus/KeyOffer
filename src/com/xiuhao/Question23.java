package com.xiuhao;

/**
 * 链表中环的入口节点
 */
public class Question23 {

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3;

        System.out.println(entryNodeofLoop(node1).val);

    }
    //寻找链表中一快一慢两个指针相遇的节点
    public static ListNode meetingNode(ListNode head){
        if(head==null){
            return null;
        }
        ListNode slow = head.next;
        if(slow==null){
            return null;
        }
        ListNode fast = slow.next;
        while (slow.next!=null&&fast.next!=null){
            if(slow.val==fast.val){
                return slow;
            }
            slow = slow.next;
            fast = fast.next;
            if(fast!=null){
                fast = fast.next;
            }
        }
        return null;
    }

    public static ListNode entryNodeofLoop(ListNode head){
        ListNode meetingNode = meetingNode(head);
        if(head==null){
            return null;
        }

        //得到环中节点的数目
        int nodeInLoop = 1;
        ListNode pre = meetingNode;
        while(pre.next!=meetingNode){
            pre = pre.next;
            nodeInLoop++;
        }

        //先移动指针pre次数为环中节点数目
        pre = head;
        for(int i=0;i<nodeInLoop;i++){
            pre = pre.next;
        }
        //再移动指针pNode和pre，两个指针相遇的节点即为环的入口
        ListNode pNode = head;
        while(pre!=pNode){
            pre = pre.next;
            pNode = pNode.next;
        }
        return pre;
    }
}
