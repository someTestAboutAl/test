package IOTest;

import java.io.*;

/**
 * description
 * Author: HP
 * Date: 2022/5/11
 * Time: 20:32
 */
public class UtilTest01 {

    public static void main(String[] args) {
        try {
            InputStream in = new FileInputStream("src/IOTest/test.txt");
            OutputStream out = new FileOutputStream("src/IOTest/test1.txt");
            copy(in,out);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

    public static void copy(InputStream in, OutputStream out){
//        File read = new File(str);
//        File write = new File(copyStr);
//        InputStream in = null;
//        OutputStream out = null;

        try {
            //2.选择流
//            in = new FileInputStream(read);
//            out = new FileOutputStream(write,true);
            byte[] flush = new byte[1024];
            int len = -1;

            //3.操作（读取数据）
            while ((len=in.read(flush) )!= -1){
                out.write(flush,0,len);
            }
            out.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if ( out != null){
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (in != null){
                //4.释放资源
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
