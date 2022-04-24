package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树中和为某一值的路径(一)
 * 递归、先序遍历（回溯-剪枝）
 * 层次遍历
 *
 * description
 * Author: HP
 * Date: 2022/4/16
 * Time: 21:55
 */
public class HasPathSum {
    class Node{
        TreeNode node;
        int sum;

        public  Node(TreeNode node,int sum){
            this.node = node;
            this.sum = sum;
        }
    }
    public static void main(String[] args) {
        HasPathSum h = new HasPathSum();
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

        System.out.println(h.hasPathSum1(n1,8));


    }

    public boolean hasPathSum1(TreeNode root,int sum){

        if(root == null){
            return false;
        }

        Queue<Node> queue = new LinkedList<>();
        Node curNode =new Node(root,root.getVal());
        queue.add(curNode);

        while (!queue.isEmpty()){
            curNode = queue.poll();
            TreeNode  node = curNode.node;
            if(node.getLeft() == null && node.getRight() == null){

                if (curNode.sum == sum){

                    return true;
                }
            }

            if (node.getLeft() != null){
                queue.add(new Node(node.getLeft(),curNode.sum+node.getLeft().getVal()));
            }

            if (node.getRight() != null){
                queue.add(new Node(node.getRight(),curNode.sum+node.getRight().getVal()));
            }

        }

        return  false;

    }

//    public boolean hasPathSum2(TreeNode root){
//
//    }

    public boolean hasPathSum3(TreeNode root,int sum){
        if (root == null){
            return  false;
        }
        if(root.getRight()==null && root.getLeft()==null){
            return root.getVal() == sum;
        }

        return (hasPathSum3(root.getLeft(),sum-root.getVal())||hasPathSum3(root.getRight(),sum-root.getVal()));

    }

}
