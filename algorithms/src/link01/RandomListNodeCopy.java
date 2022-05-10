package link01;

import java.util.HashMap;

/**
 * 复杂链表的复制
 * description
 * Author: HP
 * Date: 2022/4/12
 * Time: 10:24
 */
public class RandomListNodeCopy {
    public static void main(String[] args) {
        RandomListNodeCopy copy = new RandomListNodeCopy();
        RandomListNode n1 = new RandomListNode(1);
        RandomListNode n2 = new RandomListNode(2);
        RandomListNode n3 = new RandomListNode(3);
        RandomListNode n4 = new RandomListNode(4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n1.random = n3;
//        n2.random = n1;
        copy.printRandomList(n1);
        System.out.println();
        copy.printRandomList(copy.randomListNodeCopy1(n1));


    }

    public RandomListNode randomListNodeCopy1(RandomListNode pHead){
//        // 2.原地解法
//        if(pHead == null) return pHead;
//        // 1.将拷贝节点放到原节点后面，例如1->2->3这样的链表就变成了这样1->1'->2->2'->3->3'
//        for (RandomListNode node = pHead, copy = null; node != null; node = node.next.next) {
//            copy = new RandomListNode(node.getLable());
//            copy.next = node.next;
//            node.next = copy;
//        }
//        // 2.把拷贝节点的random指针安排上
//        for (RandomListNode node = pHead; node != null; node = node.next.next) {
//            if (node.random != null) {
//                node.next.random = node.random.next;
//            }
//        }
//        // 3.分离拷贝节点和原节点，变成1->2->3和1'->2'->3'两个链表，后者就是答案
//        RandomListNode newHead = pHead.next;
//        for (RandomListNode node = pHead, temp = null; node != null && node.next != null;) {
//            temp = node.next;
//            node.next = temp.next;
//            node = temp;
//        }
//        return newHead;

        if(pHead == null){
            return null;
        }
        RandomListNode temp = pHead;
        while (temp != null){
            RandomListNode copy = new RandomListNode(temp.lable);
            copy.setNext(temp.getNext());
            temp.setNext(copy);
            temp = temp.next.next;
        }

        temp = pHead;
        while (temp != null){
            if (temp.getRandom() != null){
                temp.getNext().setRandom(temp.getRandom().getNext());
            }
            temp = temp.next.next;
        }

        RandomListNode newList = pHead.next;
        while (pHead != null && pHead.getNext() != null){
            temp = pHead.getNext();
            pHead.setNext(temp.getNext());
            pHead = temp;
        }

        return newList;
    }

    public RandomListNode randomListNodeCopy2(RandomListNode pHead){
        if(pHead == null){
            return null;
        }
        // 1.map解法
        RandomListNode newHead = new RandomListNode(pHead.getLable());
        RandomListNode tmp = newHead;
        RandomListNode next = pHead.next;
        // map中key为head中的node，value为复制的node
        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
        map.put(pHead,newHead);
        while(next != null){
            RandomListNode tnext = new RandomListNode(next.getLable());
            map.put(next,tnext);
            tmp.next = tnext;
            next = next.next;
            tmp = tmp.next;
        }
        tmp = newHead;
        // 当所有的node创建完后，才能添加random值
        while(tmp != null){
            tmp.random = map.get(pHead.random);
            tmp = tmp.next;
            pHead = pHead.next;
        }
        return newHead;
    }

    public void printRandomList(RandomListNode list){
        while (list != null){
            System.out.print("--lable: "+list.lable+",");
            if(list.next == null){
                System.out.print("next: " + null+",");
            }else {
                System.out.print("next: " + list.next.lable+",");
            }
            if(list.random == null){
                System.out.print("random: " + null+";");
            }else {
                System.out.print("random: " + list.random.lable+";");
            }
            list = list.next;
        }
    }
}
