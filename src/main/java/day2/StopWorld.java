package day2;

import java.util.HashMap;

/**
 * 测试STW和垃圾回收情况
 * -Xmx512m -Xms512m -Xmn400k -XX:+UseSerialGC -Xloggc:gc.log -XX:+PrintGCDetails
 * +UseSerialGC: 开启串型GC  Xloggc: GC日志
 * @author yianmou
 **/
public class StopWorld {
    private static ProduceObjectThread produceObjectThread;
    private static PrintTimeThread printTimeThreadextends;

    public static void main(String[] args) {
        produceObjectThread = new ProduceObjectThread();
        printTimeThreadextends = new PrintTimeThread();
        produceObjectThread.start();
        printTimeThreadextends.start();
    }
}

class ProduceObjectThread extends Thread {
    HashMap map = new HashMap();
    @Override
    public void run() {
        try {
            while (true) {
                if (map.size()*512/1024/1024 >= 400) {
                    map.clear();
                    System.out.println("map is cleaned");
                }
                for (int i=0; i<100; i++) {
                    map.put(System.nanoTime(), new byte[512]);
                }
                Thread.sleep(1);
            }
        } catch (Throwable e) {e.printStackTrace();}
    }
}

class PrintTimeThread extends Thread {
    public static final long startTime = System.currentTimeMillis();
    @Override
    public void run() {
        try {
            while (true) {
                long t = System.currentTimeMillis() - startTime;
                System.out.println(t/1000 + "." + t%1000);
                Thread.sleep(100);
            }
        } catch (Throwable e) {e.printStackTrace();}
    }
}