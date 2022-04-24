package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上往下打印二叉树
 * 队列：时间：O(n),空间：O(n)
 * description
 * Author: HP
 * Date: 2022/4/16
 * Time: 21:54
 */
public class PrintFromTopToBottom {
    public static void main(String[] args) {
        PrintFromTopToBottom p = new PrintFromTopToBottom();
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

        System.out.println(p.printFromTopToBottom(n1));
    }


    public List printFromTopToBottom(TreeNode root){
        if(root == null){
            return null;
        }
        List list = new ArrayList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            list.add(node.getVal());
            if(node.getLeft() != null){
                queue.add(node.getLeft());
            }
            if (node.getRight() != null){
                queue.add(node.getRight());
            }
        }

        return list;
    }
}
