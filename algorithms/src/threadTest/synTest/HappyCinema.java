package threadTest.synTest;

import java.util.ArrayList;
import java.util.List;

/**
 * description:
 * user:芋头
 * date:2022/6/10
 * time:11:49
 */
public class HappyCinema {
    public  static void main(String args[]){
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        Cinema cinema = new Cinema(list,"今日影院");

        List<Integer> seats1 = new ArrayList<>();
        list.add(1);
        list.add(2);
        Customer c1 = new Customer(cinema,seats1);

        List<Integer> seats2 = new ArrayList<>();
        list.add(8);
        list.add(3);
        Customer c2 = new Customer(cinema,seats2);

        new Thread(c1,"lily").start();
        new Thread(c2,"merry").start();
    }
}


class Customer implements Runnable{
    Cinema cinema;
    List<Integer> seats;

    public Customer(Cinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {

        synchronized (cinema) {
            boolean flag = cinema.bookTickets(seats);
            if (flag) {
                System.out.println("出票成功：" + Thread.currentThread().getName() + "买到的位置为: " + seats);
            } else {
                System.out.println("出票失败：" + Thread.currentThread().getName() + "现有的位置为: " + cinema.available);

            }

        }
    }
}
class Cinema{
    List<Integer> available;
    String name;

    public Cinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTickets(List<Integer> seats){

        System.out.println("可用位子为："+ available.size());

        List<Integer> copy = new ArrayList();
        copy.addAll(available);
        copy.removeAll(seats);

        if(copy.size() != available.size() - seats.size()){
            System.out.println("选择位置失败了");
            return false;
        }

        available = copy;
        return true;
    }

}