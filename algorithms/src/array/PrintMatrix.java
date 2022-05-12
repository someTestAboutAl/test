package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个矩阵，按照顺时针螺旋
 * description
 * Author: HP
 * Date: 2022/5/11
 * Time: 20:35
 */
public class PrintMatrix {
    public static void main(String[] args) {

        PrintMatrix p = new PrintMatrix();
        int[][] g = {{1,3,1},
                     {1,5,1},
                     {4,2,1}};
        System.out.println(p.solution1(g));
        System.out.println(p.solution2(g));

    }

    /**
     * 直接打印
     * 空间：o(1)，时间:(mn)
     * @param a
     * @return
     */
    public List<Integer> solution1(int[][] a){
        List<Integer> res = new ArrayList<>();
        if(a.length == 0){
            return null;
        }
        int left = 0;
        int right = a[0].length - 1;
        int up = 0;
        int low = a.length - 1;
        while (left <= right && up <= low){
            for (int i = left; i <= low; i++){
                res.add(a[up][i]);
            }
            up++;
            if (up > low){
                break;
            }

            for (int i = up; i <= low; i++){
                res.add(a[i][right]);
            }
            right--;
            if (left > right){
                break;
            }


            for (int i = right; i >= left; i--){
                res.add(a[low][i]);
            }
            low--;
            if (up > low){
                break;
            }


            for (int i = low; i >= up; i--){
                res.add(a[i][left]);
            }
            left++;
            if (left > right){
                break;
            }
        }

        return res;
    }

    /**
     * 逆转矩阵
     * 空间：o(mn)，时间:(mn)
     * @param a
     * @return
     */
    public List<Integer> solution2(int[][] a){
        List<Integer> res = new ArrayList<>();
        int count = 0;
        while (true){
            if (count != 0){
                a =rotate(a);
            }

            for (int i = 0; i < a.length; i++){
                res.add(a[0][i]);
            }
            count++;

            if (a.length == 1){
                break;
            }
        }

        return res;
    }

    public  int[][] rotate(int[][] mat){
        int row = mat[0].length;
        int col = mat.length;
        if (row  == 1){
            int[][] res = new int[1][col-1];
            for (int i = 1; i < col;i++){
                res[1][i-1] = mat[i][0];
            }

            return res;
        }
        int[][] res = new int[row-1][col-1];
        int res_i = 0;
        int res_j = 0;
        for (int i = row-1; i >= 0; --i){
            res_j =0;
            for (int j = 1; j < col; ++j){
                res[res_i][res_j++] = mat[j][i];
            }
            ++res_i;
        }

        return res;
    }
}
