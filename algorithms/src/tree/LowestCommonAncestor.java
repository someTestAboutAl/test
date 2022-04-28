package tree;

/**
 * 二叉搜索树的最近公共祖先
 * 找到满足是p，q两个节点的公共祖先且深度尽可能大的节点值
 * 递归-时间：O(n),空间：O(n)
 * 遍历-时间：O(n),空间：O(n)
 * description
 * Author: HP
 * Date: 2022/4/21
 * Time: 16:25
 */
public class LowestCommonAncestor {

    public static void main(String[] args) {

        LowestCommonAncestor ancestor = new LowestCommonAncestor();
        TreeNode n1 = new TreeNode(5);
        TreeNode n2 = new TreeNode(3);
        TreeNode n3 = new TreeNode(7);
        TreeNode n4 = new TreeNode(1);
        TreeNode n5 = new TreeNode(4);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(8);
//        n1.setLeft(n2);
//        n1.setRight(n3);
//        n2.setLeft(n4);
//        n2.setRight(n5);
//        n3.setLeft(n6);
//        n3.setRight(n7);
        System.out.println(ancestor.lowestCommonAncestor2(n1,3,8));

    }

    public int lowestCommonAncestor1(TreeNode root,int p, int q){

        if (root == null){

            return -1;
        }
        //两个节点都小于当前节点，都在当前节点的左子树中
        if (p < root.getVal() && q < root.getVal()){

            return lowestCommonAncestor1(root.getLeft(),p,q);
        }else if (p > root.getVal() && q > root.getVal()){  //两个节点都大于当前节点，都在当前节点的右子树中

            return lowestCommonAncestor1(root.getRight(),p,q);
        }else{

            return root.getVal();
        }

    }

    public int lowestCommonAncestor2(TreeNode root,int p, int q){
        if (root == null){

            return -1;
        }

        while (true){
            if (p < root.getVal() && q < root.getVal()){

                root = root.getLeft();
            }else if (p > root.getVal() && q > root.getVal()){

                root = root.getRight();
            }else{

                break;
            }
        }

        return  root.getVal();
    }
}
