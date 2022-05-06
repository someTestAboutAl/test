package array;

/**
 * 给定一个长度为 n 的非降序数组，和一个非负整数 K
 * 统计 K 在数组中出现的次数
 * 要求空间：O(1) 时间：O(logn)
 * description
 * Author: HP
 * Date: 2022/5/5
 * Time: 11:22
 */
public class GetNumberOfK {
    public static void main(String[] args) {

        GetNumberOfK g = new GetNumberOfK();
        int[] a1 = {1,2,3,3,4,4,5,7,8};
        int[] a2 = {3,3,4,6,8,9,12};
        System.out.println(g.solution1(a1,3));
        System.out.println(g.solution1(a2,6));
//        System.out.println(g.solution2(a1,3));
//        System.out.println(g.solution2(a2,6));

    }

    /**
     * 二分
     * 空间：O(1) 时间：O(logn)
     * @param a
     * @param k
     * @return
     */
    public int solution1(int[] a, int k){

//        int first = binarySearch(a,k);
//        int last = binarySearch(a,k+1);

//        return (first == a.length || a[first] != k)?0:last-first;
        return binarySearch(a,k+0.5) - binarySearch(a,k-0.5);

    }

    public int binarySearch(int[] a,double k){
        int l = 0;//左边界
        int r = a.length-1;//右边界
        int m = 0;
        while (l <= r){
            m = (l + r)/2; // m = l + ((l - r) >> 1)
            if (a[m] > k){
                r = m-1;
            }else if (a[m] < k){
                l = m + 1;
            }
        }
        System.out.println("l: "+l);

        return  l;

    }

    /**
     * 直接计算
     * 空间：O(1) 时间：O(n)
     * @param a
     * @param k
     * @return
     */
    public int solution2(int[] a, int k){
        int count = 0;
        for (int i : a){
            if (i == k){
                count++;
            }
            if (i > k){
                break;
            }
        }

        return  count;
    }
}
