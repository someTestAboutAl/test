package link01;

/**
 * description
 * Author: HP
 * Date: 2022/4/5
 * Time: 10:51
 */
public class Merge {
    public static void main(String[] args) {

        Merge m = new Merge();
        ListNode n7 = new ListNode(7,null);
        ListNode n6 = new ListNode(5,n7);
        ListNode n5 = new ListNode(3,n6);

//        ListNode n4 = new ListNode(8,null);
//        ListNode n3 = new ListNode(4,n4);
//        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,null);
        ListNode result = m.merge(null,null);
        System.out.println(result);

    }


    public ListNode merge(ListNode list1, ListNode list2){
        ListNode temp = new ListNode(-1,null);
        ListNode head = temp;
        while (list1 != null && list2 != null){
            if(list1.getData() >= list2.getData()){
                temp.setNext(list2);
                temp = list2;
                list2 = list2.getNext();
            }else {
                temp.setNext(list1);
                temp = list1;
                list1 = list1.getNext();
            }
        }

        if(list1 != null){

            temp.setNext(list1);
        }

        if(list2 != null){

            temp.setNext(list2);
        }

        return head.getNext();
    }
}
