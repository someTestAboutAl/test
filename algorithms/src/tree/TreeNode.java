package tree;

/**
 * description:
 * user:芋头
 * date:2022/4/14
 * time:15:54
 */
public class TreeNode {
    private int val;
    private TreeNode left = null;
    private TreeNode right = null;
    private TreeNode next = null;//指向父节点

    public TreeNode(int val) {
        this.val = val;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode getNext() {
        return next;
    }

    public void setNext(TreeNode next) {
        this.next = next;
    }

    @Override
    public String toString() {
        PrintByRows p = new PrintByRows();
        System.out.println(p.printByRows1(this));
        return "TreeNode{" +
                "val=" + val +
                ", left=" + left +
                ", right=" + right +
                '}';
    }
}
