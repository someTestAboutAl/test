package threadTest.synTest;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * description:
 * user:芋头
 * date:2022/6/10
 * time:11:31
 */
public class SynContainer {

    //线程安全，操作并发容器--list提供了对应的并发容器
//    public static void main(String args[]) throws InterruptedException {
//
//        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
//
//        for (int i = 0; i < 100; i++ ){
//
//            new  Thread (()->{
//
//                list.add(Thread.currentThread().getName());
//
//            }).start();
//
//        }
//
//        Thread.sleep(1000);
//        System.out.println(list.size());
//
//    }


    //使用synchronized实现锁
//    public static void main(String args[]) throws InterruptedException {
//
//        List<String> list = new ArrayList<>();
//
//        for (int i = 0; i < 100; i++ ){
//
//            new  Thread (()->{
//
//                synchronized(list){
//                    list.add(Thread.currentThread().getName());
//                }
//                    }).start();
//
//        }
//
//        Thread.sleep(1000);
//        System.out.println(list.size());
//
//    }


    //没有实现锁
    public static void main(String args[]) throws InterruptedException {

        List<String> list = new ArrayList<>();

        for (int i = 0; i < 1000; i++ ){

            new  Thread (()->{ list.add(Thread.currentThread().getName()); }).start();

        }

        Thread.sleep(1000);
        System.out.println(list.size());

    }

}
