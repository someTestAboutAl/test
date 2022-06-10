package threadTest.useRunnable;

/**
 * description:
 * user:芋头
 * date:2022/6/8
 * time:23:19
 */
public class Web12306 implements Runnable {

    private int ticketNums = 50;

    static int z = 0;
    static int w = 0;
    static int l = 0;

    @Override
    public void run() {

        while (true){
            if (ticketNums <= 0){
                System.out.println("小张:"+ z +", 小王:"+ w + ", 小李："+l);
                break;
            }

            System.out.println(Thread.currentThread().getName()+":"+ticketNums--);

            if (Thread.currentThread().getName().equals("小张")){
                z++;
            }else if(Thread.currentThread().getName().equals("小王")){
                w++;
            }else {
                l++;
            }
        }

    }

    public static void main(String args[]){
        Web12306 web = new Web12306();

        new Thread(web,"小张").start();
        new Thread(web,"小王").start();
        new Thread(web,"小李").start();
    }


}
