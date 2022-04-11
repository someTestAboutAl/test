package planeGame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * description
 * Author: HP
 * Date: 2022/3/30
 * Time: 21:55
 */
public class MyGameFrame extends JFrame {

    Image i1 = GameUtil.getImage("images/111.jpg");
    Image i2 = GameUtil.getImage("images/222.jpg");
    int x = 250;
    int y = 250;
    public void paint(Graphics g){
        g.drawImage(i1,0,0,null);
        g.drawImage(i2,250,250,null);
        x++;
//        Color c = g.getColor();
//        Font f = g.getFont();
//        g.setColor(Color.BLUE);
//        g.setFont(new Font("宋体",Font.BOLD,50));
//        g.drawLine(100,100,300,300);
//        g.drawRect(100,100,300,300);
//        g.drawOval(100,100,300,300);
//        g.fillRect(100,100,40,40);
//        g.drawString("LLL",200,200);
//        g.setColor(c);
//        g.drawImage(i,250,250,null);
    }
    class  PaintThread extends Thread{

        public void run(){
            while (true){
                repaint();

                try {
                    Thread.sleep(40);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public  void launchFrame(){
        this.setTitle("测试");
        this.setVisible(true);
        this.setSize(500,500);
        this.setLocation(300,300);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new  PaintThread().start();
    }

    public static void main(String[] args) {
        MyGameFrame f = new MyGameFrame();
        f.launchFrame();
    }
}
