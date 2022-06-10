package threadTest.useRunnable;

/**
 * description:
 * user:芋头
 * date:2022/6/8
 * time:22:27
 */
public class StartRun implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 10 ; i++){
            System.out.println("我是run");
        }
    }


    public static void main(String args[]){
        //创建实现类对象
        StartRun sr = new StartRun();
        //创建代理类对象
        Thread t = new Thread(sr);

        t.start();

//        new Thread(new StartRun()).start();//简单写法

        for (int i = 0; i < 10; i++){
            System.out.println("我是main");
        }
    }
}
