package link01;

/**
 * description
 * Author: HP
 * Date: 2022/4/4
 * Time: 20:36
 */
public class ListNode {

    private int data;
    private ListNode next;

    public ListNode(int data,ListNode next){
        this.data = data;
        this.next = next;
    }

    public int getData() {
        return data;
    }

    public ListNode getNext() {
        return next;
    }

    public void setData(int data) {
        this.data = data;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        return "ListNode{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
