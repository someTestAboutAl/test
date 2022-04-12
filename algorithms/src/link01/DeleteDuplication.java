package link01;

/**
 * 排序链表，删除重复节点（不保留）
 * 哑结点
 * 递归
 * description
 * Author: HP
 * Date: 2022/4/8
 * Time: 13:15
 */
public class DeleteDuplication {
    public static void main(String[] args) {
        DeleteDuplication de = new DeleteDuplication();
        ListNode n7 = new ListNode(4,null);
        ListNode n6 = new ListNode(4,n7);
        ListNode n5 = new ListNode(4,n6);

        ListNode n4 = new ListNode(3,n5);
        ListNode n3 = new ListNode(3,n4);
        ListNode n2 = new ListNode(2,n3);
        ListNode n1 = new ListNode(1,n2);
        System.out.println(n1);
        ListNode res = de.deleteDuplication1(n1);
        System.out.println(res);

    }

    public ListNode deleteDuplication1(ListNode list){

        if (list == null || list.getNext() == null){
            return list;
        }

        ListNode dummy = new ListNode(-1,null);
        dummy.setNext(list);
        ListNode cur = dummy;
        System.out.println("xxx"+cur);
        while(cur.getNext() != null && cur.getNext().getNext() != null){
            if(cur.getNext().getData() == cur.getNext().getNext().getData()){
                int x = cur.getNext().getData();
                while (cur.getNext() != null && cur.getNext().getData() == x){
                    cur.setNext(cur.getNext().getNext());
                }
            } else {
                cur = cur.getNext();
            }
        }

        return dummy.getNext();
    }

    public ListNode deleteDuplication2(ListNode list){
        ListNode dummy = new ListNode(0,null);
        ListNode tail = dummy;
        while (list != null){
            //不同，将其放到dummy中
            if(list.getNext() == null || list.getData() != list.getNext().getData()){
                tail.setNext(list);
                tail = list;
            }
            //相同，跳过
            while (list.getNext() != null && list.getData() == list.getNext().getData()){
                list = list.getNext();
            }
            list = list.getNext();
        }
        tail.setNext(null);
        return dummy.getNext();
    }

    public ListNode deleteDuplication3(ListNode list){
        return list;
    }

}
