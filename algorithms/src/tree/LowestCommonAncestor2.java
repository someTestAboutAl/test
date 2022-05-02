package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一颗二叉数，和两个节点，找到两个节点的最近公共祖先
 * description
 * Author: HP
 * Date: 2022/5/2
 * Time: 9:49
 */
public class LowestCommonAncestor2 {
    boolean flag = false;
    public static void main(String[] args) {
        LowestCommonAncestor2 l = new LowestCommonAncestor2();
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
        n3.setRight(n7);
        System.out.println(l.lowestCommonAncestor1(n1,1,5));
        System.out.println(l.lowestCommonAncestor2(n1,1,5));

    }

    /**
     * 递归
     * 时间：O(n),空间：O(n)
     * @param root
     * @param val1
     * @param val2
     * @return
     */
    public int lowestCommonAncestor1(TreeNode root, int val1, int val2){

        if (root == null){

            return -1;
        }

        return dfs(root,val1,val2).getVal();
    }

    public TreeNode dfs(TreeNode root, int val1, int val2){
        if (root == null){
            return null;
        }
        if (root.getVal() == val1 || root.getVal() == val2){
            return root;
        }
        TreeNode left = dfs(root.getLeft(), val1, val2);
        TreeNode right = dfs(root.getRight(),val1,val2);
        if (left == null){
            return right;
        }

        if (right == null){
            return left;
        }

        return root;
    }

    /**
     * 分别找到两个节点的路径，找到路径上的公共节点
     * 时间：O(n),空间：O(n)
     * @param root
     * @param val1
     * @param val2
     * @return
     */
    public int lowestCommonAncestor2(TreeNode root, int val1, int val2){
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        findNode(list1,root,val1);
        flag = false;
        findNode(list2,root,val2);
        System.out.println(list1);
        System.out.println(list2);
        int len = list1.size() > list2.size()?list2.size():list1.size();
        for (int i = 0; i < len; i++){
            if (list2.get(i) != list1.get(i) ){
                return list1.get(i-1);
            }

        }

        return list1.get(len-1);
    }

    public void findNode(List<Integer> list,TreeNode root, int val){
        if (flag||root == null){
            return;
        }
        list.add(root.getVal());
        if (root.getVal() == val){
            flag = true;
            return;
        }
        findNode(list,root.getLeft(),val);
        findNode(list,root.getRight(),val);
        if (flag){
            return;
        }
        list.remove(list.size()-1);
    }

}
