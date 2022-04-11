package recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * description
 * Author: HP
 * Date: 2022/4/1
 * Time: 16:46
 */
public class Step {

    /**
     * 递归
     * @param i
     * @return
     */
    public  int step1(int i){
        if (i <= 0){

            return  0;
        }
        if(i < 3 && i > 0){
            return i;
        }
        return step1(i-1)+step1(i-2);
    }

    /**
     * 保留中间结果
     * @param i
     * @return
     */
    public int step2(int i){
        //List<Integer> list = new ArrayList();
//        if (list.get(i) != 0){
//            return list.get(i);
//        }
//        if (i <= 0){
//
//            return  0;
//        }
//        if(i < 3 && i > 0){
//            list.set(i,i);
//            return list.get(i) ;
//        }

        int [] result = new int[100];

        if (result[i] != 0){
            return  result[i];
        }

        if (i <= 0){
            return  0;
        }

        if(i < 3 && i > 0){
            return result[i] = i ;
        }

        return step2(i-1)+step2(i-2);

    }

    /**
     * 动态规划
     * @param i
     * @return
     */
    public int step3(int i){
        if(i <= 0){
            return 0;
        }else {
            int sum = 0;
            int stepf= 1;
            int stepff = 0;

            for(int j = 1; j <= i;j++){
                sum = stepf + stepff;
                stepf = sum;
                stepff = stepf;
            }

            return sum;
        }
    }


    public static void main(String[] args) {
        Step s = new Step();
        System.out.println(s.step1(11));
    }
}
