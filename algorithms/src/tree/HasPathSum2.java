package tree;

import java.util.*;

/**
 * 二叉树中和为某一值的路径
 * 给定一颗二叉树的根节点和一个整数
 * 找出二叉树中节点值的和为该整数的所有路径
 * description
 * Author: HP
 * Date: 2022/4/27
 * Time: 20:54
 */
public class HasPathSum2 {

    List<List> res1 = new ArrayList<>();
    List<Integer> path1 = new LinkedList<>();
    public static void main(String[] args) {
        HasPathSum2 h = new HasPathSum2();
        TreeNode n1 = new TreeNode(10);
        TreeNode n2 = new TreeNode(5);
        TreeNode n3 = new TreeNode(12);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(7);
        TreeNode n6 = new TreeNode(1);
        TreeNode n7 = new TreeNode(1);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        System.out.println(h.hasPathSum1(n1,0));
        System.out.println(h.hasPathSum2(n1,0));
    }

    /**
     * 深度优先
     * 时间：O(n^2),空间：O(n)
     * @param root
     * @param sum
     * @return
     */
    public List<List> hasPathSum1(TreeNode root, int sum){
        DFS(root,sum);
        return res1;
    }
    public void  DFS(TreeNode root,int sum){
//        System.out.println("in");
//        System.out.println(root);
        //出口
        if (root == null){
            return;
        }
        sum -= root.getVal();//计算路径和
        path1.add(root.getVal());//将当前节点加入路径
//        System.out.println(sum);

        //当前节点为叶节点且路径和等于sum，将其路径加入到结果集中
        if(sum == 0 && root.getLeft() == null && root.getRight() == null){
            res1.add(new ArrayList(path1));
        }

        DFS(root.getLeft(),sum);//递归查看左节点
        DFS(root.getRight(),sum);//递归查看右节点
        path1.remove(path1.size()-1);//当前路径不符合要求，移除最后一个节点向上回溯
    }

    /**
     * 广度优先-队列
     * 时间：O(n^2),空间：O(n)
     * @param root
     * @param sum
     * @return
     */
    public List<List> hasPathSum2(TreeNode root, int sum){
        List<List> res = new ArrayList<>();
        if (root == null){

            return res;
        }
        Queue<ArrayList<Integer>> path = new LinkedList<>();//存放当前遍历经过的每条路径
        Queue<TreeNode> node = new LinkedList<>();//存放当前遍历经过的节点
        path.add(new ArrayList<>(Arrays.asList(root.getVal())));
        node.add(root);
        while (!node.isEmpty()){
            TreeNode curNode = node.poll();//弹出当前节点，遍历其左右节点
            ArrayList<Integer> curPath = path.poll();//弹出当前节点对应的路径

            //当前节点存在左节点，将左节点加入其路径之后再放入队列
            if (curNode.getLeft() != null){
                ArrayList<Integer> list = new ArrayList(curPath);
                list.add(curNode.getLeft().getVal());
                path.add(list);
                node.add(curNode.getLeft());
            }

            //当前节点存在右节点，将右节点加入其路径之后再放入队列
            if (curNode.getRight() != null){
                ArrayList<Integer> right = new ArrayList(curPath);
                right.add(curNode.getRight().getVal());
                path.add(right);
                node.add(curNode.getRight());
            }

            //当前节点为叶子结点，弹出以该叶子结点为结束的路径，判断该路径是否符合条件，若符合，将其加入到结果集res中
            if (curNode.getRight() == null && curNode.getLeft() == null){
                ArrayList<Integer> list = curPath;
                int m = sum;
                for (int i = 0; i < list.size(); i++){

                    m -= list.get(i);
                }

                if(m == 0){
                    res.add(list);
                }
            }
        }

        return res;
    }
}
