package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个节点，给出中序遍历中的下一个节点
 * description
 * Author: HP
 * Date: 2022/4/24
 * Time: 20:53
 */
public class GetNext {


    public static void main(String[] args) {
        GetNext g = new GetNext();
        TreeNode n1 = new TreeNode(8);
        TreeNode n2 = new TreeNode(6);
        TreeNode n3 = new TreeNode(10);
        TreeNode n4 = new TreeNode(5);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(9);
        TreeNode n7 = new TreeNode(11);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n2.setNext(n1);
        n3.setLeft(n6);
        n3.setRight(n7);
        n3.setNext(n1);
        n4.setNext(n2);
        n5.setNext(n2);
        n6.setNext(n3);
        n7.setNext(n3);
        System.out.println(g.getNext1(null));
//        System.out.println(g.getNext1(n4));
//        System.out.println(g.getNext1(n5));
        System.out.println(g.getNext2(null));
//        System.out.println(g.getNext2(n4).getVal());
//        System.out.println(g.getNext2(n5).getVal());

    }

    /**
     * 中序遍历直接查找
     * 时间：O(n),空间：O(n)
     * @param node
     * @return
     */
    public int getNext1(TreeNode node){

        if (node == null){
            return 0;
        }
        TreeNode root = node;
        while (root.getNext() != null){
            root = root.getNext();
        }
        List<Integer> list = new ArrayList();
        list = inorder(root,list);

        for (int i = 0; i < list.size(); i++){
            if (list.get(i) == node.getVal()){
                return  i == list.size()-1?0:list.get(i+1);
            }
        }

        return  0;
    }

    /**
     * 中序遍历
     * @param node
     * @return
     */
    public List<Integer> inorder(TreeNode node,List<Integer> list){
        if (node != null){
            inorder(node.getLeft(),list);
            list.add(node.getVal());
            inorder(node.getRight(),list);
        }
//        for (int i = 0; i < list.size(); i++){
//            System.out.print("list： "+list+"， ");
//            }

        return list;
    }

    /**
     * 三种情况
     * （1）当前节点有右子树，返回右子树的最左节点
     * （2）当前节点无右子树，且为父节点的左子树，返回父节点
     * （3）当前节点无右子树，且为父节点的右子树，向上查找父节点，直至父节点为某一节点的左节点，返回该节点
     * 时间：O(n),空间：O(1)
     * @param node
     * @return
     */
    public TreeNode getNext2(TreeNode node){

        if (node == null){
            return null;
        }

        //情况1
        if (node.getRight() != null){
            node = node.getRight();
            while (node.getLeft() != null){
                node = node.getLeft();
            }
            return node;
        }

        while (node.getNext() != null){
            //情况2
            if (node.getNext().getLeft().getVal() == node.getVal()){
                return node.getNext();
            }
            node = node.getNext();//情况3
        }
        return  null;
    }
}
