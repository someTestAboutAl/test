package link01;

import java.util.LinkedList;

/**
 * description
 * Author: HP
 * Date: 2022/3/10
 * Time: 20:58
 */
public class RemoveNthFromEnd {

    public static void main(String[] args){
        RemoveNthFromEnd re = new RemoveNthFromEnd();
        ListNode n7 = new ListNode(7,null);
        ListNode n6 = new ListNode(6,n7);
        ListNode n5 = new ListNode(5,n6);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        System.out.println(n1.toString());
        ListNode result = re.RemoveNthFromEnd(n1,4);
        System.out.println(result.toString());
    }

    public ListNode RemoveNthFromEnd(ListNode head,int k){

        if(head == null || k < 1){
            return head;
        }
        ListNode fast = head;
        ListNode slow = head;

        //定义两个指针指向头结点，将fast节点向后一定K个位置
        while(k > 0 && fast.getNext()!=null){
            fast=fast.getNext();
            k--;
        }

        if(k==1){
            head = head.getNext();//此时，要删除的节点为头结点，也就是第一个节点，删除头结点
        }else if (k==0){
            while(fast.getNext()!=null){
                fast=fast.getNext();//将两个指针不断向后移动，直到fast指向最后一个节点
                slow=slow.getNext();
            }
            slow.setNext(slow.getNext().getNext());//此时slow的下一个节点就是倒数第K个节点，删除slow的下一个节点
        }

        return head;
    }

    public void printListNode(ListNode node){
        while (node.getNext()!= null){
            System.out.println(node.toString());
            node = node.getNext();
        }
        System.out.println(node.toString());
    }

}
