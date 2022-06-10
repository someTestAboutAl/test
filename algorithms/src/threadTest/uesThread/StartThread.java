package threadTest.uesThread;

/**
 * description:
 * user:芋头
 * date:2022/6/8
 * time:21:56
 */
public class StartThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 100 ; i++){
            System.out.println("我是run");
        }
    }

    public static void main(String args[]){
        StartThread t = new StartThread();
        t.start();
        for (int i = 0; i < 100; i++){
            System.out.println("我是main");
        }
    }
}
