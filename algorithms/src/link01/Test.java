package link01;


/**
 * description
 * Author: HP
 * Date: 2022/3/4
 * Time: 14:42
 */
public  class Test {
    public String str = "6";
    private int h = 9;
    private static final String s = "hiji";


//    public static  Test t1 = new Test();
//    {
//        out.println("1-1-");
//    }
//    static
//    {
//        out.println("2-2-");
//    }

//    static  int x = 10;
//    static {
//        x += 5;
//    }




    public  static int step(int i){
        if(i < 3 && i > 0){
            return i;
        }
        return step(i-1)+step(i-2);
    }

    public static void main(String[] args){

        Test test = new Test(66);
        String s;
//        Test.step(1);
//        try{
//            System.out.println("try");
//
//            throw new Exception();
//
//        } catch (Exception e) {
//            e.printStackTrace();
//            System.out.println("catch");
//        }finally {
//            System.out.println("finally");
//        }

//        String s = "aaa";
//        s += 'a';
//        say(s);
//        String[] a;
//        Object m[] = new Object[0];
//        m[0] = "mmm";
//        Integer i = new Integer(1);
//        testInteger(i);
//        System.out.println("1?5"+i);
//        byte a=2,b=4,c;
//        short s = 16;
//        b = s;
//        c = a * b;

//        int a = 2;
//        boolean B = false;
//
//        Test test = new Test();
//        System.out.println(test.step(9));


//        Integer a = 10;
//        Integer b = 1;
//        Integer c = 500;
//        Integer d = 500;
//        String s= "Admin";
//        System.out.println(s.toLowerCase(Locale.ROOT)=="admin");
//
//        System.out.println(a++ + a--);
//        System.out.println(c==d);
//        int [] m;
//        String a = "hi"+"ji";
//        String b = "hi";
//        String c = "ji";
//        System.out.println(a==s);
//        System.out.println((b+c)==s);
//        Test test = new Test();
//        test.run();
//        Scanner sc = new Scanner(System.in);
//        int x = 10;
//        x += 10;
//        Integer n1 = new Integer(46);
//        Integer n2 = new Integer(46);
//        System.out.println(n1==n2);
//        System.out.println(n1!=n2);
//        int a =10;
//        int i = 0;
//        int [] a = {0, 0, 4, 2, 5, 0, 3, 0};
//        ArrayList<Integer> arrayList = new ArrayList();
//        arrayList.add(0);
//        arrayList.add(0);
//        arrayList.add(4);
//        arrayList.add(2);
//        arrayList.add(5);
//        arrayList.add(0);
//        arrayList.add(3);
//        arrayList.add(0);
//        Integer z = new Integer(0);
//        while (i < arrayList.size()){
//            if (arrayList.get(i).equals(z)){
//                arrayList.remove(i);
//            }
//            i++;
//        }
//        double c = 100;
//        System.out.println(JSONObject.toJSONString(arrayList));
//        int b,c;
//        c = b + a;
//        try {
//            int i = 100 / 0;
//            System.out.println(i);
//        }catch (Exception e){
//            System.out.println(1);
//            throw  new RuntimeException();
//        }finally {
//            System.out.println(2);
//        }
//        System.out.println(3);
//        int a = 3,c =3;
//        byte b = 12;
//        boolean  s = false;
//        long n = 123l;
//        float f = (float) 0.9239;
//        System.out.println(a++);
//        List list = new ArrayList();
//        int b = a++;
//        int d = ++c;
//        System.out.println("b = "+b+",a = "+a);
//        System.out.println("d = "+d+",c = "+c);

//        Test test = new Test();
//        test.start(test.str);
//        System.out.println(test.str);

//        String a = new String("mystring");
//        String b = "mystring";
//        String c = "my"+"string";
//        String d = c;
//        System.out.println(a == b);
//        System.out.println(a == c);
//        System.out.println(b == c);
//        System.out.println(b == d);

//        Test test  = new Test();
//        test.run();
//        test.clone();
//        int i = 0;
//        test.add(i);
//        i = i ++;
//        System.out.println(i);
//        System.out .println(Test.x);


//        byte b1 = 1, b2 = 2, b3, b6;
//        final byte b4 = 4, b5 = 5;
//        b6 = b4 + b5;
//        b3 = (byte) (b1 + b2);
//        System.out.println(b3 + b6);
//         Test test = new Test();
//         System.out.println( test.test1());
//        Object o = new Object(){
//            public boolean equals(Object obj){
//                return  true;
//            }
//        };
//
//        System.out.println(o.equals("Fred"));
//        Test t2 = new Test();
    }

    Test(int a ){
        h = a;
    }
    public void start(String str){
//        for (int i = 0; i < 10; i++){
//            System.out.println(i);
//        }
        str = "10";
        h = 0;
    }

//    static {
//        x /= 3;
//    }

//    void add(int i){
//        i++;
//    }

    public static  int s(int x){
        int j = 1;
        switch (x){
            case 1:
                j++;
            case 2:
                j++;
            case 4:
                j++;
            case 5:
                j++;
            default:
                j++;
        }
        return j+x;
    }
}

class A{
    public A(){}

    {
        System.out.println("语句块A");
    }

    static {
        System.out.println("静态语句块A");
    }

    public static void main(String[] args) {
//        Test t = new Test();
//        Test.step(1);
    }
}

class B extends A{
    public B(){}

    {
        System.out.println("语句块B");
    }

    static {
        System.out.println("静态语句块B");
    }

    public static void main(String[] args) {

        new B();
    }
}

interface m{}
