package threadTest.useRunnable;

/**
 * description:
 * user:芋头
 * date:2022/6/8
 * time:22:39
 */
public class RAdd  implements Runnable{

    int a;
    int b;

    public RAdd(int i, int j) {
        this.a = i;
        this.b = j;
    }

    @Override
    public void run() {

        Add add = new Add();
        add.add(a,b);

    }

    public static void main(String args[]){
        RAdd r1 = new RAdd(3,8);//11
        RAdd r2 = new RAdd(6,8);//14
        RAdd r3 = new RAdd(9,8);//17

        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);

        t1.start();
        t2.start();
        t3.start();
    }
}
