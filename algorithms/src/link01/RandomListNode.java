package link01;

/**
 * description
 * Author: HP
 * Date: 2022/4/12
 * Time: 10:20
 */
public class RandomListNode {
    int lable;
    RandomListNode next = null;
    RandomListNode random = null;

    public RandomListNode(int lable) {
        this.lable = lable;
    }
    public int getLable() {
        return lable;
    }

    public void setLable(int lable) {
        this.lable = lable;
    }

    public RandomListNode getNext() {
        return next;
    }

    public void setNext(RandomListNode next) {
        this.next = next;
    }

    public RandomListNode getRandom() {
        return random;
    }

    public void setRandom(RandomListNode random) {
        this.random = random;
    }

    @Override
    public String toString() {
        return "RandomListNode{" +
                "lable=" + lable +
                ", next=" + next +
                ", random=" + random +
                '}';
    }
}
