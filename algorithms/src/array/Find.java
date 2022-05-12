package array;

/**
 * 给定一个二维数组
 * 按行递增，按列递增
 * 判断数组中是否包含该整数
 * 要求：空间：o(1)，时间:(m+n)
 * description
 * Author: HP
 * Date: 2022/5/6
 * Time: 16:09
 */
public class Find {
    public static void main(String[] args) {
        Find f = new Find();
        int[][] a = {{1,2,8,9},{2,4,9,12},{4,7,10,13},{6,8,11,15}};

        System.out.println(f.solution1(a,7));
        System.out.println(f.solution2(a,7));
        System.out.println(f.solution3(a,7));

        System.out.println(f.solution1(a,3));
        System.out.println(f.solution2(a,3));
        System.out.println(f.solution3(a,3));


    }

    /**
     * 直接遍历查找
     * 空间：o(1)，时间:(mn)
     * @param a
     * @param k
     * @return
     */
    public boolean solution1(int [][] a,int k){
        int m = a.length;
        int n = a[0].length;

        if (a == null || m == 0 ){
            return false;
        }

        for(int i = 0; i < m; i++){
            for (int j = 0; j < n; j++){
                if (a[i][j] == k){
                    return true;
                }
            }
        }

        return false;
    }

    /**
     * 线性查找，利用有序的特性
     * 空间：o(1)，时间:(m+n)
     * @param a
     * @param k
     * @return
     */
    public boolean solution2(int [][] a,int k){
        int m = a.length; //行数
        int n = a[0].length; //列数

        if (a == null || m == 0 || n == 0){
            return false;
        }

        int i = 0; //行标
        int j = n-1; //列标，从右上角开始

        while (i < m && j >= 0){
            if (a[i][j] == k){
                return  true; //相等
            }

            if (a[i][j] > k){
                j--;  //大于k，该列都大于k，所以向左移一列
            }else {
                i++;  //小于k，该行都小于k，向下移一行
            }
        }

        return false;
    }

    /**
     * 二分查找
     * 逐行使用二分查找
     * 空间：o(1)，时间:(mlogn)
     * @param a
     * @param k
     * @return
     */
    public boolean solution3(int [][] a,int k){

        if (a == null || a.length == 0 || a[0].length == 0){
            return false;
        }

        for (int[] i :a){
            if (binarySearch(i,k)){
                return true;
            }
        }

        return false;

    }

    public boolean binarySearch(int[] a,int k){
        int l = 0;//左边界
        int r = a.length-1;//右边界
        int m = 0;
        while (l <= r){
            m = (l + r)/2; // m = l + ((l - r) >> 1)
            if (a[m] == k){
                return true;
            }
            if (a[m] > k){
                r = m-1;
            }else if (a[m] < k){
                l = m + 1;
            }
        }
        return  false;

    }

//    public boolean solution4(int [][] a,int k){
//
//    }
}
