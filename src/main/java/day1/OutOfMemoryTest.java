package day1;

import java.util.ArrayList;
import java.util.List;

/**
 * 设置最大堆内存-Xmx10M，造成OutOfMemoryError异常
 * <p>
 * Author yianmou
 */
public class OutOfMemoryTest {

    public static void main(String[] args) {
        System.out.println("-Xmx" + Runtime.getRuntime().maxMemory() / 1000000 + "M");
        System.out.println("free" + Runtime.getRuntime().freeMemory() / 1000000 + "M");

        List<byte[]> total = new ArrayList<>();
        int num = 0;
        while (true) {
            System.out.println("num=" + num);
            if (num >= 1000) {
                break;
            }
            total.add(new byte[1 * 1000 * 1000]); // 1M
            num++;
        }
    }
}

