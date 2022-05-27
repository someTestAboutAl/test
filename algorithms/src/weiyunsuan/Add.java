package weiyunsuan;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 空间复杂度 O(1)，时间复杂度 O(1)
 * description:
 * user:芋头
 * date:2022/5/27
 * time:17:35
 */
public class Add {

    /**
     * 位运算，非递归
     * 时间：O(log(max(num1,num2)))，空间：O(1)
     * @param num1
     * @param num2
     * @return
     */
    public int solution01(int num1 , int num2){

//        int add = num2; //进位
//        int sum = num1; //和
//
//        while (add != 0){
//
//            int temp = sum ^ add;//无进位 和 进位 异或 求和
//
//            add = (sum & add) << 1; // 产生进位 与运算
//
//            sum = temp;
//        }
//
//        return sum;
        while (num2 != 0){
            int sum = num1 ^ num2;
            int temp = (num1 & num2) << 1;
            num1 = sum;
            num2 = temp;
        }

        return num1;
    }


    /**
     * 位运算，递归
     * 时间：O(log(max(num1,num2)))，空间：O(log(max(num1,num2)))
     * @param num1
     * @param num2
     * @return
     */
    public int solution02(int num1 , int num2){

        return num2 != 0 ? solution02(num1 ^ num2, (num1 & num2) << 1) :num1;

    }

}
