package tree;

import java.util.*;

/**
 * 给定一个二叉树，按照之字形层序遍历
 * （第一层：左-->右，下一层：右-->左）
 * 要求：时间：O(n),空间：O(n)
 * description
 * Author: HP
 * Date: 2022/4/30
 * Time: 9:50
 */
public class PrintZhi {
    public static void main(String[] args) {

        PrintZhi p = new PrintZhi();
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
        System.out.println(p.print1(n1));
        System.out.println(p.print2(n1));

    }

    /**
     * 使用栈
     * 时间：O(n),空间：O(n)
     * @param root
     * @return
     */
    public List<List> print1(TreeNode root){
        if (root == null){
            return null;
        }

        List<List> res = new ArrayList();
        Stack<TreeNode> s1 = new Stack<>();//奇数层:左-->右（入栈顺序：先右后左）
        Stack<TreeNode> s2 = new Stack<>();//偶数层:右-->左（入栈顺序：先左后右）
        s1.push(root);
        int index = 1;
        while (!s1.isEmpty() || !s2.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            if (index % 2 != 0){
                //奇数层
                while (!s1.isEmpty()){
                    TreeNode node = s1.pop();
                    temp.add(node.getVal());
                    if (node.getLeft() != null){
                        s2.push(node.getLeft());
                    }
                    if (node.getRight() != null){
                        s2.push(node.getRight());
                    }
                }
                res.add(temp);
            }else {
                //偶数层
                while (!s2.isEmpty()){
                    TreeNode node = s2.pop();
                    temp.add(node.getVal());
                    if (node.getRight() != null){
                        s1.push(node.getRight());
                    }
                    if (node.getLeft() != null){
                        s1.push(node.getLeft());
                    }
                }
                res.add(temp);
            }

            index++;
        }
        return res;
    }

    /**
     * 使用队列
     * 时间：O(n),空间：O(n)
     * @param root
     * @return
     */
    public List<List> print2(TreeNode root){
        if (root == null){
            return null;
        }

        List<List> res = new ArrayList();
        Deque<TreeNode> dq = new LinkedList<>();
//        Queue<TreeNode> q = new LinkedList<>();
        dq.add(root);
        int index = 1;
        while (!dq.isEmpty()){
            List<Integer> temp = new ArrayList<>();
            int len = dq.size();
            for (int i = 0; i < len; i++){
               if(index % 2 != 0){
                   //奇数层
                   TreeNode node = dq.pollFirst();//从队列前面取
                   temp.add(node.getVal());//层次遍历，保存奇数层的节点值：从左到右
                    //下一层为偶数层（右-->左：放后面，先放左节点再放右节点-->取的时候从后面取--先右后左）
                   if (node.getLeft() != null){
                       dq.addLast(node.getLeft());
                   }
                    if (node.getRight() != null){
                        dq.addLast(node.getRight());
                    }

                }else {
                   //偶数层
                   TreeNode node = dq.pollLast();//从队列后面去
                   temp.add(node.getVal());//层次遍历，保存偶数层的节点值：从右到左
                    //下一层为奇数层（左-->右：放前面，先放右节点再放左节点-->取的时候从前面取--先左后右）
                   if (node.getRight() != null){
                       dq.addFirst(node.getRight());
                   }
                    if (node.getLeft() != null){
                        dq.addFirst(node.getLeft());
                    }

                }
            }
            res.add(temp);
            index++;
        }

        return res;

    }
}
