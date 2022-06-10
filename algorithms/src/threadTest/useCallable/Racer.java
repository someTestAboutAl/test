package threadTest.useCallable;

import java.util.concurrent.*;

/**
 * description:
 * user:芋头
 * date:2022/6/8
 * time:23:40
 */
public class Racer implements Callable<Integer>{

    private  String winner;

    @Override
    public Integer call() throws Exception {
        for (int step = 1; step <= 50; step++){
            System.out.print(Thread.currentThread().getName().equals("pool-1-thread-1")?"兔子:":"乌龟:");
            System.out.println(step);

            boolean flag = gameOver(step);

            if (flag){
                return step;
            }
        }

        return null;
    }

    private boolean gameOver(int step){
        if (winner != null){
            return true;
        }else {
            if(step == 50){
                winner = Thread.currentThread().getName().equals("pool-1-thread-1")?"兔子":"乌龟";
                System.out.println("winner:" + winner);
                return  true;
            }
        }

        return false;
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {
        Racer r = new Racer();

        //创建执行服务
        ExecutorService ser = Executors.newFixedThreadPool(2);

        //提交执行
        Future<Integer> res1 = ser.submit(r);//pool-1-thread-1--兔子
        Future<Integer> res2 = ser.submit(r);//pool-1-thread-2--乌龟

        //获取结果
        Integer r1 = res1.get();
        Integer r2 = res2.get();
        System.out.println("兔子："+r1 + "； "+"乌龟："+r2);


        //关闭结果
        ser.shutdownNow();
    }


}
