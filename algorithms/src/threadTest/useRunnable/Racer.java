package threadTest.useRunnable;

/**
 * description:
 * user:芋头
 * date:2022/6/8
 * time:23:40
 */
public class Racer implements Runnable {

    private  String winner;
    @Override
    public void run() {
        for (int step = 1; step <= 50; step++){
            System.out.println(Thread.currentThread().getName()+":"+step);
            boolean flag = gameOver(step);
            if (flag){
                break;
            }
        }
    }

    private boolean gameOver(int step){
        if (winner != null){
            return true;
        }else {
            if(step == 50){
                winner = Thread.currentThread().getName();
                System.out.println("winner:" + winner);
                return  true;
            }
        }

        return false;
    }

    public static void main(String args[]){
        Racer r = new Racer();

        new Thread(r,"乌龟").start();
        new Thread(r,"兔子").start();
    }
}
