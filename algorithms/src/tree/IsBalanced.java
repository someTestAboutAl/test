package tree;

/**
 * 判断是否为平衡二叉树
 * 自顶向下：时间：O(nlog2n),空间：O(n)
 * 自底向上-递归：时间：O(n),空间：O(n)
 * description
 * Author: HP
 * Date: 2022/4/19
 * Time: 11:33
 */
public class IsBalanced {
    public static void main(String[] args) {

        IsBalanced b = new IsBalanced();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);

        System.out.println(b.isBalanced2(n1));

    }


    /**
     * 自底向上
     * @param root
     * @return
     */
    public boolean isBalanced1(TreeNode root){
        if (treeDepth1(root) == -1){
            return false;
        }
        return true;
    }

    /**
     *自顶向下
     * @param root
     * @return
     */
    public boolean isBalanced2(TreeNode root){

        if (root == null){
            return true;
        }

        return  Math.abs(treeDepth2(root.getLeft()) - treeDepth2(root.getRight())) <= 1 && isBalanced2(root.getLeft()) && isBalanced2(root.getRight());
    }


    public int treeDepth1(TreeNode root){
        if(root == null){
            return  0;
        }
        int l = treeDepth1(root.getLeft());
        if (l == -1){
            return -1;
        }
        int r = treeDepth1(root.getRight());
        if (r == -1){
            return -1;
        }
        if (Math.abs(l-r) > 1){
            return -1;
        }

        return Math.max(l,r)+1;
    }


    public int treeDepth2(TreeNode root){
        if(root == null){
            return  0;
        }
        int l = treeDepth2(root.getLeft());
        int r = treeDepth2(root.getRight());

        return Math.max(l,r)+1;
    }
}
