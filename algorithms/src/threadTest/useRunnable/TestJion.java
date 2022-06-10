package threadTest.useRunnable;

/**
 * description:
 * user:芋头
 * date:2022/6/9
 * time:11:02
 */
public class TestJion implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 10;i++){
            if (i % 2 == 0){
                Thread.yield();
            }
            System.out.println("run:"+i);
        }
    }

    public static void main(String args[]) throws InterruptedException {

        TestJion jion = new TestJion();
        new Thread(jion).start();
//        Thread t = new Thread(jion);
//        t.start();

        for (int i = 0; i < 10;i++){
            if (i == 5){
//                t.join();
                Thread.sleep(10);
            }
            System.out.println("main:"+i);
        }
    }
}
