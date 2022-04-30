package tree;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个二叉树和一个整数sum
 * 找出有多少条路径的和等于sum（不需要从根节点开始，叶子节点结束）
 * description
 * Author: HP
 * Date: 2022/4/29
 * Time: 10:55
 */
public class HasPathSum3 {

    int res1 = 0;//dfs路径总数
    int res2 = 0;//层次，路径总数
    HashMap<Integer,Integer> mp = new HashMap<>();//前缀和（哈希map）不同路径及其数目

    public static void main(String[] args) {
        HasPathSum3 h = new HasPathSum3();
        TreeNode n1 = new TreeNode(1);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(4);
        TreeNode n7 = new TreeNode(3);
        TreeNode n8 = new TreeNode(-1);
        n1.setLeft(n2);
        n1.setRight(n3);
        n2.setLeft(n4);
        n2.setRight(n5);
        n3.setLeft(n6);
        n3.setRight(n7);
        n5.setLeft(n8);
//        System.out.println(h.hasPathSum1(n1,4));
        System.out.println(h.hasPathSum2(n1,4));
//        System.out.println(h.hasPathSum3(n1,4));

    }

    /**
     * DFS
     * 以每个节点作为根节点，查询其所有路径中所有符合要求的路径
     * 时间：O(n^2),空间：O(n)
     * @param root
     * @param sum
     * @return
     */
    public int hasPathSum1(TreeNode root,int sum){
        if (root == null){
            return  0;
        }

        dfs1(root,sum);
        hasPathSum1(root.getLeft(),sum);
        hasPathSum1(root.getRight(),sum);

        return res1;
    }

    /**
     * 查询以root作为根节点的所有路径上所有符合要求的路径数
     * @param root
     * @param sum
     */
    public void dfs1(TreeNode root, int sum){
        if (root == null){
            return;
        }

        if (sum == root.getVal()){
            res1++;
        }
        dfs1(root.getLeft(),sum-root.getVal());
        dfs1(root.getRight(),sum-root.getVal());
    }

    /**
     * 层次遍历
     * 以每一层的各个节点为根节点，查找其所有路径中符合要求的
     * @param root
     * @param sum
     * @return
     */
    public int hasPathSum3(TreeNode root,int sum){
        if (root == null){
            return  0;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()){
            TreeNode node = q.poll();
            cengci(node,sum);
            if (node.getLeft() != null){
                q.add(node.getLeft());
            }
            if (node.getRight() != null){
                q.add(node.getRight());
            }
        }
        return res2;
    }

    /**
     * 查询以root作为根节点的所有路径上所有符合要求的路径数
     * @param root
     * @param sum
     */
    public void cengci(TreeNode root, int sum){
        if (root == null){
            return;
        }

        if (sum == root.getVal()){
            res2++;
        }
        cengci(root.getLeft(),sum-root.getVal());
        cengci(root.getRight(),sum-root.getVal());
    }


    /**
     * 利用哈希表
     * 时间：O(n),空间：O(n)
     * @param root
     * @param sum
     * @return
     */
    public int hasPathSum2(TreeNode root, int sum){
        mp.put(0,1);
        return dfs2(root,sum,0);
    }

    /**
     *前缀和：根节点到-当前节点路径的和
     * 采用DFS
     * map记录的是到当前节点为止，所有出现的前缀和<前缀和，出现次数>
     * @param root
     * @param sum
     * @param last 到上一层为止的累加和
     * @return
     */
    public int dfs2(TreeNode root,int sum,int last){
        if (root == null){
            return 0;
        }

        int cursum = 0;//记录和为sum的路径总数
        int temp = last + root.getVal();//到当前节点为止的前缀和

        //如果当前的和减去sum的值在列表中出现过，pre = temp - sum; sum + pre = temp;即前缀和为pre的节点之后到temp经过了一点和为sum的路径
        if (mp.containsKey(temp - sum)){
            cursum += mp.get(temp - sum);//将前缀和为pre的数目加入到结果中
        }

        //将当前节点的前缀和加入到map中
        mp.put(temp,mp.getOrDefault(temp,0) + 1);
        System.out.println("前： "+mp);

        //进入子节点
        cursum += dfs2(root.getLeft(),sum,temp);
        cursum += dfs2(root.getRight(),sum,temp);

        //回溯，将已经遍历过的节点的前缀从map中删除
        mp.put(temp,mp.get(temp)-1);
        System.out.println("后： "+mp);

        return cursum;

    }
}
