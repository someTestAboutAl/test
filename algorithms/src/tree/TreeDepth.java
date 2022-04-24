package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * 分治法
 *
 * description:
 * user:芋头
 * date:2022/4/14
 * time:15:58
 */
public class TreeDepth {

    public static void main(String[] args) {

    }

    /**
     * 使用队列保存每一层的节点
     * @param root
     * @return
     */
    public int treeDepth1(TreeNode root){
        if (root == null){
            return 0;
        }

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int high = 0;
        while (!q.isEmpty()){
            int size = q.size();
            while (size != 0){
                TreeNode temp = q.poll();
                if(temp.getLeft() != null){
                    q.add(temp.getLeft());
                }
                if (temp.getRight() != null){
                    q.add(temp.getRight());
                }
                size--;
            }

            high++;
        }

        return high;
    }

    /**
     * 递归
     * 时间：O(n),空间：O(n)
     * @param root
     * @return
     */
    public int treeDepth2(TreeNode root){
        if(root == null){
            return  0;
        }
        int l = treeDepth2(root.getLeft());
        int r = treeDepth2(root.getRight());

        return Math.max(l,r)+1;
    }
}
