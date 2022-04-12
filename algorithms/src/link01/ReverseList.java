package link01;

import java.util.Stack;

/**
 * 反转链表
 * 头插法
 * 栈
 * 递归
 * description
 * Author: HP
 * Date: 2022/4/7
 * Time: 14:37
 */
public class ReverseList {
    public static void main(String[] args) {

        ReverseList r = new ReverseList();
        ListNode n7 = new ListNode(7,null);
        ListNode n6 = new ListNode(6,n7);
        ListNode n5 = new ListNode(5,n6);
        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);

        ListNode n8 = new ListNode(8,null);
        ListNode n9 = new ListNode(9,n8);

        System.out.println(n1.toString());
//        System.out.println(n9.toString());
//        ListNode re = r.reverseList1(n8);
//        ListNode re = r.reverseList2(n1);
        ListNode re = r.reverseList3(n1);
        System.out.println(re);

    }

    /**
     * 插入
     * @param head
     * @return
     */
    public ListNode reverseList1(ListNode head){
        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode temp = head.getNext();
        while (temp.getNext() != null){
            ListNode item = temp.getNext();
            temp.setNext(item.getNext());
            item.setNext(head.getNext());
            head.setNext(item);
        }
        ListNode list = head.getNext();
        head.setNext(null);
        temp.setNext(head);
        return list;
    }

    /**
     * 栈
     * @param head
     * @return
     */
    public ListNode reverseList2(ListNode head){

        if(head == null || head.getNext() == null){
            return head;
        }

        Stack<ListNode> s = new Stack<>();
        while (head != null){
            s.push(head);
            head = head.getNext();
        }

        ListNode temp = s.pop();
        ListNode first = temp;
        while (!s.isEmpty()){
            first.setNext(s.pop());
            first = first.getNext();
        }
        first.setNext(null);
        return temp;
    }

    /**
     * 递归
     *
     * @param head
     * @return
     */
    public ListNode reverseList3(ListNode head){

        if(head == null || head.getNext() == null){
            return head;
        }

        ListNode temp = reverseList3(head.getNext());
        head.getNext().setNext(head);
        head.setNext(null);
        return temp;

    }

}
