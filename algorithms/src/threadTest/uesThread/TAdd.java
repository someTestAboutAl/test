package threadTest.uesThread;

/**
 * description:
 * user:芋头
 * date:2022/6/8
 * time:22:17
 */
public class TAdd extends Thread {

    int a;
    int b;

    public TAdd(int i, int j) {
        this.a = i;
        this.b = j;
    }

    @Override
    public void run() {
        Add add = new Add();
        add.add(a,b);
    }


    public static void main(String args[]){
        TAdd t1 = new TAdd(3,8);//11
        TAdd t2 = new TAdd(6,8);//14
        TAdd t3 = new TAdd(9,8);//17

        t1.start();
        t2.start();
        t3.start();
    }
}
