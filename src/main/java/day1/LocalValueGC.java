package day1;

/**
 * 局部变量表GC和槽位复用
 * Author yianmou
 */
public class LocalValueGC {
    public static void main(String[] args) {
        LocalValueGC localValueGC = new LocalValueGC();
        localValueGC.Gc1();
        localValueGC.Gc2();
        localValueGC.Gc3();
        localValueGC.Gc4();
        localValueGC.Gc5();
    }

    public void Gc1() {
        int[] a = {1, 2, 3};
        System.gc();
    }

    public void Gc2() {
        int[] a = {1, 2, 3};
        a = null;
        System.gc();
    }

    public void Gc3() {
        {
            int[] a = {1, 2, 3};
            System.out.println(a);
        }
        System.gc();
    }

    public void Gc4() {
        {
            int[] a = {1, 2, 3};
            System.out.println(a);
        }
        int b = 100;
        System.gc();
    }

    public void Gc5() {
        Gc1();
        System.gc();
    }
}


