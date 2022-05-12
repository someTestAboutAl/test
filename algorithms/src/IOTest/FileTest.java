package IOTest;

import java.io.*;

/**
 * description
 * Author: HP
 * Date: 2022/5/10
 * Time: 20:24
 */
public class FileTest {
    public static void main(String[] args) {
        FileTest f = new FileTest();

//        System.out.println(System.getProperty("user.dir"));
//
        f.copy("src/IOTest/123.jpg","src/IOTest/123copy.jpg");

    }

    public void readTest(){

        //1。创建源
        File s = new File("src/IOTest/test.txt");
        InputStream in = null;

        try {
            //2.选择流
            in = new FileInputStream(s);
            int str ;
            //3.操作（读取数据）
            while ((str=in.read() )!= -1){
                System.out.print((char) str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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

    public void writeTest(){
        //1。创建源
        File s = new File("src/IOTest/test1.txt");
        OutputStream out = null;

        try {
            //2.选择流
            out = new FileOutputStream(s,true);
            String str  = "AAA,BBBB,VVVVV,NM,";
            byte[] b = str.getBytes(); //字符串 --> 字节数组（编码）
            //3.操作（写入数据）
            out.write(b,0,b.length);
            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                //4.释放资源
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public  void copy(String str, String copyStr){
        File read = new File(str);
        File write = new File(copyStr);
        InputStream in = null;
        OutputStream out = null;

        try {
            //2.选择流
            in = new FileInputStream(read);
            out = new FileOutputStream(write,true);
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

    public void readerTest(){
        //1。创建源
        File s = new File("src/IOTest/test.txt");
        Reader in = null;

        try {
            //2.选择流
            in = new FileReader(s);
            char[] flush = new char[1024] ;
            int len = -1;
            //3.操作（读取数据）
            while ((len=in.read(flush) )!= -1){
                String str = new String(flush,0,len);
                System.out.print(str);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
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

    public void writerTest(){
        //1。创建源
        File s = new File("src/IOTest/test1.txt");
        Writer out = null;

        try {
            //2.选择流
            out = new FileWriter(s,true);
            //01
//            String str  = "AAA,BBBB,VVVVV,NM,你好";
//            char[] b = str.toCharArray(); //字符串 --> 字符数组
//            //3.操作（写入数据）
//            out.write(b,0,b.length);
            //02
//            String str = "你还拿现金哦啥都";
//            out.write(str);

            //03
            out.append("nih").append("在吗");

            out.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (out != null){
                //4.释放资源
                try {
                    out.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}
