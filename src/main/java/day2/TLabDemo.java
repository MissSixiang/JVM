package day2;

/**
 * -XX:+UseTLAB -XX:+PrintTLAB -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis
 * -XX:-UseTLAB -XX:+PrintTLAB -Xcomp -XX:-BackgroundCompilation -XX:-DoEscapeAnalysis
 *  XX:+UseTLAB 开启TLAB -BackgroundCompilation 希望我们JVM第一次就将字节码编译成本地代码
 * @description
 * @author: yianmou
 **/
public class TLabDemo {
    public static void alloc() {
        byte[] b = new byte[2];
        b[0] = 1;
    }

    public static void main(String[] args) {
        long b = System.currentTimeMillis();
        for (int i=0; i<10000000;i++) {
            alloc();
        }
        long e = System.currentTimeMillis();
        System.out.println("------------TLabDemo耗时：" + (e-b) + "------------");
    }
}
