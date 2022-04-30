package tree;

import java.util.Stack;

/**
 * 给定一颗二叉搜索树，返回其中第K小的节点值
 * 递归中序遍历
 * 非递归中序遍历-栈
 * 类似：GetNext，LowestCommonAncestor
 * description
 * Author: HP
 * Date: 2022/4/28
 * Time: 17:26
 */
public class KthNode {
    private  int count = 0;
    TreeNode res = null;

    public static void main(String[] args) {
        KthNode k = new KthNode();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(2);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        System.out.println(k.kthNode1(n1,8));
        System.out.println(k.kthNode2(n1,8));

    }

    /**
     * 递归中序遍历
     * 时间：O(n),空间：O(n)
     * @param root
     * @param k
     * @return
     */
    public int kthNode1(TreeNode root,int k){
        midOrder(root,k);
        if (res == null){
            return -1;
        }
        return res.getVal();

    }

    /**
     * 中序遍历
     * @param root
     * @param k
     * @return
     */
    public void midOrder(TreeNode root,int k){
        if (root == null || count > k){
            return ;
        }

//        System.out.println("左： " + root.getVal());
        midOrder(root.getLeft(),k);
        count++;
//        System.out.println("count: " + count);
        if (count == k){
//            System.out.println(root);
            res = root;
        }
//        System.out.println("右： " + root.getVal());
        midOrder(root.getRight(),k);
    }

    /**
     * 非递归-栈
     * 时间：O(n),空间：O(n)
     * @param root
     * @param k
     * @return
     */
    public int kthNode2(TreeNode root , int k){
        if (root == null){
            return -1;
        }
        TreeNode node = null;
        int count = 0;
        Stack<TreeNode> s = new Stack<>();
        while (!s.isEmpty() || root != null){
            while (root != null){
                s.push(root);
                root = root.getLeft();
            }
            node = s.pop();
            count++;
            if (count == k){
                return node.getVal();
            }

                root = node.getRight();

        }

        return -1;
    }
}
