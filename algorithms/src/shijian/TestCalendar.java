package shijian;

import javafx.scene.input.DataFormat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.SimpleFormatter;

/**
 * description
 * Author: HP
 * Date: 2022/4/6
 * Time: 21:36
 */
public class TestCalendar {

    public static void main(String[] args) throws ParseException {
        String s = "2122-4-6";
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = df.parse(s);
        Calendar c = new GregorianCalendar();
        c.setTime(date);
        System.out.println("日\t一\t二\t三\t四\t五\t六");
        c.set(Calendar.DAY_OF_MONTH,1);

        for(int i = 1;i < c.get(Calendar.DAY_OF_WEEK)-1;i++){
            System.out.print("\t");
        }
        int days = c.getActualMaximum(Calendar.DATE);
        for(int i = 1; i <= days ; i++){
            System.out.print(c.get(Calendar.DAY_OF_MONTH)+"\t");
            if(c.get(Calendar.DAY_OF_WEEK)== Calendar.SUNDAY){
                System.out.println();
            }
            c.add(Calendar.DAY_OF_MONTH,1);
        }
    }



}
