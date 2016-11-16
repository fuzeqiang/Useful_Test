package enumtest;

/**
 * Created by fuzeqiang(100918) on 2016/11/2 0002.
 */
public enum Test {
//    T1("a", 0),
//    T2("b", 0),
//    T3("c", 0);
//
//    private Test(String s1, int i1) {
//        this.s1 = s1;
//        this.i1 = i1;
//    }
//
//    public String s1;
//    public String s2;
//    public int i1;
//    public int i2;

    T1, T2;



    public static void main(String[] args) {
        System.out.println(Test.class.getSuperclass());
        System.out.println(Test.valueOf("T1"));
        System.out.println(Test.T1.ordinal());
//        Test test = new Test();
    }
}
