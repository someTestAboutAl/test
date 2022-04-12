package link01;

import java.util.ArrayList;
import java.util.List;

/**
 * 链表中环的入口节点
 * 哈希
 * 快慢指针
 * arrylisy
 * description
 * Author: HP
 * Date: 2022/4/11
 * Time: 21:13
 */
public class EntryNodeOfLoop {
    public static void main(String[] args) {
        EntryNodeOfLoop en = new EntryNodeOfLoop();
        ListNode n7 = new ListNode(7,null);
        ListNode n6 = new ListNode(6,n7);
        ListNode n5 = new ListNode(5,n6);

        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
//        n7.setNext(n4);
        int res = en.entryNodeOfLoop2(n1);
        System.out.println(res);

    }


    public int entryNodeOfLoop1(ListNode list){
        List temp = new ArrayList();
        while (list != null){
            if (temp.contains(list)){
//                list.setNext(null);
                return list.getData();
            }
            temp.add(list);
            list = list.getNext();
        }
        return 0;
    }


    public int entryNodeOfLoop2(ListNode list){
        ListNode fast = list;
        ListNode slow = list;
        while (fast != null && fast.getNext() != null){
            fast = fast.getNext().getNext();
            slow = slow.getNext();
            if(fast == slow){
                break;
            }
        }

        if (fast == null || fast.getNext() == null){

            return 0;
        }

        fast = list;
        while (fast != slow){
            fast = fast.getNext();
            slow = slow.getNext();
        }
        return fast.getData();
    }
}
