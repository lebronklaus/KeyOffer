package com.xiuhao;

/**
 * 删除链表的节点 && 删除链表中重复的节点
 */
public class Question18 {
    public static void main(String[] args) {
        ListNode node11 = new ListNode(1);
        ListNode node22 = new ListNode(2);
        ListNode node33 = new ListNode(3);
        ListNode node44 = new ListNode(4);
        ListNode node55 = new ListNode(5);

        node11.next = node22;
        node22.next = node33;
        node33.next = node44;
        node44.next = node55;

        printNodeList(node11);
        deleteNode(node11,node55);
        printNodeList(node11);

    }

    public static void deleteNode(ListNode head,ListNode target){
        if(head==null||target==null){
            return ;
        }
        if(target.next==null){
            if(head==target){
                head.next=null;
                return ;
            }
            ListNode node = head.next;
            while(node.next!=target){
                node = node.next;
            }
            node.next = null;
        }else{
            target.val = target.next.val;
            target.next = target.next.next;
        }
    }

    public static void printNodeList(ListNode head){
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
        System.out.println();
    }


    public static void deleteDuplication(ListNode pHead){
        ListNode pre = null;
        ListNode p = pHead;
        if(p==null){
            return ;
        }

        while (p!=null){
            while (p.next!=null&&p.next.val!=p.val){
                pre = p;
                p = p.next;
            }
            while (p.next!=null&&p.val==p.next.val){
                p=p.next;
            }
            if(p.next==null){
                pre.next = null;
            }else{
                pre.next = p.next;
                p = p.next;
            }

        }
    }

    public static ListNode deleteDuplicationNode(ListNode pHead)
    {
        if (pHead == null) {
            return null;
        }
        ListNode preNode = null;
        ListNode node = pHead;
        while (node != null) {
            if (node.next != null && node.val == node.next.val) {
                int value = node.val;
                while (node.next != null && node.next.val == value) {
                    node = node.next;
                }
                if (preNode == null) {
                    pHead = node.next;
                } else {
                    preNode.next = node.next;
                }
            } else {
                preNode = node;
            }
            node = node.next;
        }
        return pHead;
    }
}
