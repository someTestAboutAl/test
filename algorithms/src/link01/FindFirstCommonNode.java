package link01;

import java.util.Stack;

/**
 * description
 * Author: HP
 * Date: 2022/4/6
 * Time: 11:11
 */
public class FindFirstCommonNode {
    public static void main(String[] args) {

        FindFirstCommonNode f = new FindFirstCommonNode();
        ListNode n7 = new ListNode(7,null);
        ListNode n6 = new ListNode(6,n7);
        ListNode n5 = new ListNode(5,n6);

        ListNode n4 = new ListNode(4,n5);
        ListNode n3 = new ListNode(3,n4);
//        ListNode n2 = new ListNode(2,n3);
//        ListNode n1 = new ListNode(1,n2);

        ListNode n8 = new ListNode(8,null);
        ListNode n9 = new ListNode(9,n8);
        System.out.println(n3.toString());
        System.out.println(n9.toString());
//        ListNode re = f.findFirstCommonNode1(n1,n9);
        ListNode re = f.findFirstCommonNode3(n3,n9);
        System.out.println(re);
    }

    /**
     *  O(n*m)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode findFirstCommonNode1(ListNode list1,ListNode list2){
        ListNode n = list1;
        ListNode m ;

        while (n != null){
            m = list2;
            while (m != null){
                if(n.getData() != m.getData()){
                    m = m.getNext();
                }else {
                    return n;
                }
            }
            n = n.getNext();
        }

        return n;
    }

    /**
     * 栈-O(m+n)
     * @param list1
     * @param list2
     * @return
     */
    public ListNode findFirstCommonNode2(ListNode list1,ListNode list2){
        Stack<ListNode> s1 = new Stack();
        Stack<ListNode> s2 = new Stack();

        while (list1 != null){
            s1.push(list1);
            list1 = list1.getNext();
        }

        while (list2 != null){
            s2.push(list2);
            list2 = list2.getNext();
        }

        ListNode temp = null;
        while (!s1.isEmpty() && !s2.isEmpty()){
            ListNode  m = s1.pop();
            ListNode  n = s2.pop();
            if(m.getData() == n.getData()){
                temp = m;
            }else {
                break;
            }
        }

        return temp;
    }

    /**
     * 指针
     * @param list1
     * @param list2
     * @return
     */
    public ListNode findFirstCommonNode3(ListNode list1,ListNode list2){

        ListNode m = list1;
        ListNode n = list2;
        ListNode temp = null;

        if(list1 == null || list2 == null){

            return null;
        }
        int num = 0;
        while (m.getData() != n.getData()){

//            m =(m.getNext() == null)?list2:m.getNext();
//            n =(n.getNext() == null)?list1:n.getNext();
            m = m.getNext();
            n = n.getNext();

            if(m == null){
                m = list2;
                num ++;
            }
            if(n == null){
                n = list1;
                num++;
            }

            if(num > 2){
                return null;
            }
        }
        return  m;
    }

}
