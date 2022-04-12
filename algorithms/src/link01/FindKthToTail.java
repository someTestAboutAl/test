package link01;

import java.util.Stack;

/**
 * 返回倒数第K的节点之后的链表
 * 快慢指针
 * 栈
 * description
 * Author: HP
 * Date: 2022/3/10
 * Time: 20:58
 */
public class FindKthToTail {

    public static void main(String[] args){
        FindKthToTail f = new FindKthToTail();
        ListNode n7 = new ListNode(7,null);
        ListNode n6 = new ListNode(6,n7);
        ListNode n5 = new ListNode(5,n6);
//        ListNode n4 = new ListNode(4,n5);
//        ListNode n3 = new ListNode(3,n4);
//        ListNode n2 = new ListNode(2,n3);
//        ListNode n1 = new ListNode(1,n2);
        System.out.println(n5.toString());
        ListNode result1 = f.findKthToTail(n5,4);
        ListNode result2 = f.findKthToTailByStack(n5,4);
        System.out.println("1:普通 - "+result1);
        System.out.println("2:栈 - "+result2);
    }

    /**
     * 快慢指针
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTail(ListNode head,int k){

        if(head == null || k < 1){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;

        //定义两个指针指向头结点，将fast节点向后一定K-1个位置
        while(k > 1){
            //当K大于链表长度时，返回null
            if(fast.getNext() == null){
                return null;
            }
            fast=fast.getNext();
            k--;
        }

        while(fast.getNext()!=null){
                fast=fast.getNext();//将两个指针不断向后移动，直到fast指向最后一个节点，此时slow正好为倒数第K个节点
                slow=slow.getNext();
            }

        return slow;
    }

    /**
     * 栈
     * @param head
     * @param k
     * @return
     */
    public ListNode findKthToTailByStack(ListNode head , int k){
        if (head == null || k < 1){
            return  null;
        }
        Stack<ListNode> stack = new Stack();
        int length = 0;
        while(head != null){
            stack.push(head);
            head = head.getNext();
            length++;
        }
        if(k > length){
            return null;
        }
        ListNode first = stack.pop();
        while (k > 1){
            ListNode second = stack.pop();
            second.setNext(first);
            first = second;
            k--;
        }

        return first;
    }

    public void printListNode(ListNode node){
        while (node.getNext()!= null){
            System.out.println(node.toString());
            node = node.getNext();
        }
        System.out.println(node.toString());
    }

}
