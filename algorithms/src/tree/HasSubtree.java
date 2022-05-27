package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定A,B两棵树，判断B是不是A的子结构
 * （空树不是任意树的子结构）
 * description
 * Author: HP
 * Date: 2022/4/25
 * Time: 9:52
 */
public class HasSubtree {

    public static void main(String[] args) {
        HasSubtree h = new HasSubtree();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        TreeNode n10 = new TreeNode(10);
        n8.setLeft(n9);
        n8.setRight(n10);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        System.out.println(h.hasSubtree1(n1,n8));
        System.out.println(h.hasSubtree2(n1,n8));

    }

    /**
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree1(TreeNode root1,TreeNode root2){
        if (root2 == null || root1 == null){
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root1);

        while (!queue.isEmpty()){

            TreeNode node = queue.poll();

            if (node.getVal() == root2.getVal()){

                return isSameTree(node,root2);
            }

            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }

            if (node.getRight() != null){
                queue.add(node.getRight());

            }
        }

        return false;
    }

    /**
     *
     * @param root1
     * @param root2
     * @return
     */
    public boolean hasSubtree2(TreeNode root1,TreeNode root2){
        if (root2 == null || root1 == null){
            return false;
        }

        return isSameTree(root1,root2)||hasSubtree2(root1.getLeft(),root2)||hasSubtree2(root1.getRight(),root2);
    }

    /**
     *
     * @param n1
     * @param n2
     * @return
     */
    public boolean isSameTree(TreeNode n1,TreeNode n2){
        if (n2 == null){
            return true;
        }

        if (n1 == null||n1.getVal() != n2.getVal()){
            return false;
        }

        if (n1.getVal() == n2.getVal() && isSameTree(n1.getLeft(),n2.getLeft())&&isSameTree(n1.getRight(),n2.getRight())){
            return true;
        }

        return false;
    }
}
