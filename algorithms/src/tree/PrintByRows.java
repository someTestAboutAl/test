package tree;

import java.util.*;

/**
 * 从上到下打印一颗二叉树
 * 同一层节点从左至右输出，一层输出一行
 * 类似：PrintZhi，PrintFromTopToBottom
 * description
 * Author: HP
 * Date: 2022/4/30
 * Time: 19:25
 */
public class PrintByRows {
    public static void main(String[] args) {
        PrintByRows p = new PrintByRows();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        n1.setLeft(n2);
        n1.setRight(n3);
//        n2.setLeft(n4);
//        n2.setRight(n5);
//        n3.setLeft(n6);
//        n3.setRight(n7);
        System.out.println(p.printByRows1(n1));
        System.out.println(p.printByRows2(n1));

    }

    /**
     * 使用队列，非递归层次遍历
     * 时间：O(n),空间：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> printByRows1(TreeNode root){
        if (root == null){
            return null;
        }
        List<List<Integer>> res = new ArrayList();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = q.size();
            for (int i = 0; i < len; i++){
                    TreeNode node = q.poll();
                    temp.add(node.getVal());
                    if (node.getLeft() != null){
                        q.add(node.getLeft());
                    }
                    if (node.getRight() != null){
                        q.add(node.getRight());
                    }

                }
            res.add(temp);

        }
        return res;
    }

    /**
     *递归层次遍历
     * 时间：O(n),空间：O(n)
     * @param root
     * @return
     */
    public List<List<Integer>> printByRows2(TreeNode root){
        if (root == null){
            return null;
        }

        List<List<Integer>> res = new ArrayList<>();
        levelTraversal(root,res,1);
        return res;
    }

    /**
     * 递归层次遍历
     * @param node
     * @param list
     * @param depth
     */
    public void levelTraversal(TreeNode node,List<List<Integer>> list,int depth){
        if (node == null){
            return;
        }

        if (list.size() < depth){
            list.add(new ArrayList<>());
        }
//        System.out.println(node.getVal());
        list.get(depth-1).add(node.getVal());
        levelTraversal(node.getLeft(),list,depth+1);
        levelTraversal(node.getRight(),list,depth+1);
    }


}
