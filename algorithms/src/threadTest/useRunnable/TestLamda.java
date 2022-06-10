package threadTest.useRunnable;

/**
 * description:
 * user:芋头
 * date:2022/6/9
 * time:9:18
 */
public class TestLamda {
    public static void main(String args[]){

        Ilove love = (a,b) -> {
            System.out.println("加法");
            return  a + b;
        };

        System.out.println(love.lamda(10,20));

        love = (a , b) -> a+b;
        System.out.println(love.lamda(1,2));

    }
}

interface Ilove{

    int lamda(int a, int b);
}

//class love implements Ilove{
//    @Override
//    public int lamda(int a, int b) {
//        System.out.println("加法");
//        return  a + b;
//    }
//}