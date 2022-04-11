package link01;

/**
 * description
 * Author: HP
 * Date: 2022/4/8
 * Time: 13:15
 */
public class deleteDuplication {
    public static void main(String[] args) {

    }

//    public ListNode deleteDuplication1(ListNode list){
//
//        if (list == null || list.getNext() == null){
//            return null;
//        }
//        ListNode head = null;
//        while(list!=null){
//            ListNode temp = list.getNext();
//            while (temp!=null){
//                if(list.getData() == temp.getData()){
//
//                }
//            }
//        }
//    }

//
//    public ListNode deleteDuplication(ListNode pHead) {
//        //使用虚拟结点dummy可以减少对边界的判断
//        ListNode dummy = new ListNode(-1);
//        ListNode tail = dummy;
//        while (pHead != null){
//            //如果当前结点为最后一个结点或与后面的值不同，则保留这个结点，接在tailhoumi
//            if(pHead.next == null || pHead.next.val != pHead.val){
//                tail.next = pHead;
//                tail = pHead;
//            }
//            //如果与下一结点相同，则跳过
//            while(pHead.next != null && pHead.next.val == pHead.val){
//                pHead = pHead.next;
//            }
//            pHead = pHead.next;
//        }
//        tail.next = null;
//        return dummy.next;
//    }
}
