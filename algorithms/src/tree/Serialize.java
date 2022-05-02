package tree;

/**
 * 将二叉树以某种遍历结果（先，中，后序，层序）保存为字符串
 * 反序列化，根据序列化字符串重构二叉树
 * description
 * Author: HP
 * Date: 2022/5/2
 * Time: 10:54
 */
public class Serialize {
    int index = 0;
    public static void main(String[] args) {
        Serialize s = new Serialize();
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
//        System.out.println(s.serialize(n1));
//        System.out.println(s.deSerialize(s.serialize(n1)));
        String str = "01234567";
        int var = Integer.valueOf(str.charAt(3));
        int val1 = 0;
        val1 = val1 * 10 + ((str.charAt(2)) - '0');
        System.out.println(var);
        System.out.println(val1);

    }

    /**
     * 递归-序列化二叉树
     * 前序遍历
     * @param root
     * @param s
     */
    public void serializeUtil(TreeNode root, StringBuilder s){
        if (root == null){
            s.append("#");
            return;
        }
        s.append(root.getVal()).append("!");
        serializeUtil(root.getLeft(),s);
        serializeUtil(root.getRight(),s);
    }

    /**
     * 序列化
     * 前序遍历
     * @param root
     * @return
     */
    public String serialize(TreeNode root){
        if (root == null){
            return "#";
        }
        StringBuilder s = new StringBuilder();
        serializeUtil(root,s);
        return s.toString();
    }

    /**
     * 递归反序列化
     * 前序
     * @param s
     * @return
     */
    public TreeNode deSerializeUtil(String s){
        if (s.charAt(index) == '#'){
            index++;
            return null;
        }

        int val = 0;
        while (s.charAt(index) != '!' && index != s.length()){
            val = val * 10 + ((s.charAt(index)) - '0');
            index++;
        }
        TreeNode root = new TreeNode(val);
        if (index == s.length()){
            return root;
        }else {
            index++;
        }
        root.setLeft(deSerializeUtil(s));
        root.setRight(deSerialize(s));
        return root;
    }

    /**
     * 反序列化
     * 前序
     * @param s
     * @return
     */
    public TreeNode deSerialize(String s){
        if (s == "#"){
            return null;
        }
        TreeNode root = deSerializeUtil(s);

        return root;
    }
}
