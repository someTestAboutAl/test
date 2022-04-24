package tree;

import java.util.Stack;

/**
 * 二叉树镜像
 * 递归:时间：O(n),空间：O(n)
 * 栈/队列:时间：O(n),空间：O(n)
 * description:
 * user:芋头
 * date:2022/4/14
 * time:16:35
 */
public class Mirror {

    public static void main(String[] args) {

    }

    public TreeNode mirror1(TreeNode root){
        if(root == null){
            return null;
        }
        mirror1(root.getRight());
        mirror2(root.getLeft());
        TreeNode temp = root.getLeft();
        root.setLeft(temp.getRight());
        root.setRight(temp);
        return root;
    }

    public TreeNode mirror2(TreeNode root){

        if(root == null){
            return null;
        }
        Stack<TreeNode> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()){
            TreeNode node = s.pop();
            if(node.getRight() != null){
                s.add(node.getRight());
            }
            if (node.getLeft() != null){
                s.add(node.getLeft());
            }
            TreeNode temp = node.getLeft();
            node.setLeft(node.getRight());
            node.setRight(temp);

        }

        return root;
    }
}
