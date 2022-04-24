package tree;

import java.util.Arrays;
import java.util.Stack;

/**
 * 重建二叉树(前序 & 中序)
 * 递归:时间：O(n),空间：O(n)
 * 栈（迭代）:时间：O(n),空间：O(n)
 * description
 * Author: HP
 * Date: 2022/4/22
 * Time: 14:32
 */
public class ReConstructBinaryTree {
    public static void main(String[] args) {
        ReConstructBinaryTree re = new ReConstructBinaryTree();
//        int[] pre = {1,2,4,7,3,5,6,8};
//        int[] vin = {4,7,2,1,5,3,8,6};
        int[] pre = {1};
        int[] vin = {1};
        System.out.println(re.reConstructBinaryTree1(pre,vin));
        System.out.println(re.reConstructBinaryTree2(pre,vin));


    }



    public TreeNode reConstructBinaryTree1(int[] pre,int[] vin){

        if(pre == null || pre.length == 0 || vin.length == 0 || vin == null){

            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < vin.length; i++){
            if (vin[i] == root.getVal()){
                root.setLeft(reConstructBinaryTree1(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(vin,0,i)));
                root.setRight(reConstructBinaryTree1(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(vin,i+1,vin.length)));
                break;
            }
        }
        return  root;
    }

    public  TreeNode reConstructBinaryTree2(int[] pre,int[] vin){
        if(pre == null || pre.length == 0 || vin.length == 0 || vin == null){

            return null;
        }
        Stack<TreeNode> s = new Stack();
        TreeNode root = new TreeNode(pre[0]);
        s.push(root);

        for (int i =1,j = 0; i < pre.length;i++){
            TreeNode node = s.peek();
            //构造左子树
            if (node.getVal() != vin[j]){
                node.setLeft(new TreeNode(pre[i]));
                s.push(node.getLeft());
            }else {
                //已经到达最左边的节点，向上构造右子树
                while (!s.isEmpty() && s.peek().getVal() == vin[j]){
                    node = s.pop();
                    j++;
                }
                node.setRight(new TreeNode(pre[i]));
                s.push(node.getRight());
            }
        }
        return root;
    }

}
