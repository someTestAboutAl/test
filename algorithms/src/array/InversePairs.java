package array;

/**
 * 数组中前面一个数大于后面的数字，组成一个逆序对
 * 求逆序对的总数
 * 要求：空间：O(n) 时间：O(nlogn)
 * description
 * Author: HP
 * Date: 2022/5/10
 * Time: 10:04
 */
public class InversePairs {

    int sum = 0;
    public static void main(String[] args) {

    }

    /**
     * 暴力解法
     * 空间：O(1) 时间：O(n^2)
     * @param a
     * @return
     */
    public int solution1(int[] a){
        int count = 0;
        for (int i = 0; i < a.length-1; i++){
            for (int j = i+1; j < a.length; j++){
                if (a[i] > a[j]){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 归并
     * 空间：O(n) 时间：O(nlogn)
     * @param a
     * @return
     */
    public int solution2(int[] a){

        if (a == null || a.length < 2){
            return -1;
        }

        sort(a, 0, a.length-1);

        return   sum;
        
    }

    /**
     *
     * @param a
     * @param left
     * @param right
     */
    public void sort(int[] a,int left,int right){
        if(left < right){
            int mid = (right+left)/2;
            sort(a,left,mid);
            sort(a,mid+1,right);
            mergeSort(a,left,right,mid);
        }
    }

    /**
     *
     * @param a
     * @param left
     * @param right
     * @param mid
     */
    public void mergeSort(int[] a,int left,int right,int mid){
        int[] temp = new int[right - left + 1];
        int c = 0; //临时数组的下标起点
        int s = left;//保存原数组起点下标
        int r = mid+1;//右序列指针
        int l = left;//左序列指针
        while (l<=mid && r<=right){
            if(a[l]<=a[r]){
                temp[c] = a[l];
                c++;
                l++;
            }else {
                temp[c] = a[r];
                sum += mid + 1 - l;
                sum %= 1000000007;
                c++;
                r++;
            }
        }
        while(l<=mid){//将左边剩余元素填充进temp中
            temp[c++] = a[l++];
        }
        while(r<=right){//将右序列剩余元素填充进temp中
            temp[c++] = a[r++];
        }
        //将temp中的元素全部拷贝到原数组中
        for (int num : temp){
            a[s++] = num;
        }
    }
}