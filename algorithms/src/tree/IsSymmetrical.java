package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 对称的二叉树
 * 递归
 * 迭代
 * description
 * Author: HP
 * Date: 2022/4/20
 * Time: 20:58
 */
public class IsSymmetrical {
    public static void main(String[] args) {
        IsSymmetrical s = new IsSymmetrical();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(2);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(5);
        TreeNode n7 = new TreeNode(4);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        System.out.println(s.isSymmetrical2(n1));

    }

    public boolean isSymmetrical1(TreeNode root){
        if (root == null){

            return  true;
        }

        return isSame(root.getLeft(),root.getRight());
    }

    public boolean isSame(TreeNode left,TreeNode right){

        if(left == null && right == null){
            return true;
        }
        if (left == null || right == null){
            return  false;
        }

        return left.getVal() == right.getVal() && isSame(left.getLeft(),right.getRight()) && isSame(left.getRight(),right.getLeft());
    }

    public boolean isSymmetrical2(TreeNode root){

        if(root == null){

            return true;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root.getLeft());
        q.add(root.getRight());
        int count = 0;
        while (!q.isEmpty()){
//            System.out.println(q.isEmpty());
            count++;
            TreeNode left = q.poll();
            TreeNode right = q.poll();
            if(left == null && right == null){

                continue;
            }
            if(left == null || right == null){
                return false;
            }
            if (left.getVal() != right.getVal()){
                return  false;
            }
            q.add(left.getLeft());
            q.add(right.getRight());
            q.add(left.getRight());
            q.add(right.getLeft());
        }

        System.out.println(count);
        return true;
    }
}
