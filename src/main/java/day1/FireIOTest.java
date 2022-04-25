package day1;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 燃烧io
 * Author yianmou
 */
public class FireIOTest {

    private static Executor executor = Executors.newCachedThreadPool();

    public static void main(String[] args) {
        executor.execute(() -> {
            while (true) {
                try {
                    FileOutputStream fio = new FileOutputStream(new File("io.text"));
                    for (int i=0; i< 20000; i++) {
                        fio.write(i);
                    }
                    fio.close();
                    FileInputStream fis = new FileInputStream(new File("io.text"));
                    while (fis.read() != -1)
                    System.out.println("i'm working!");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.execute(() -> {
            while (true) {
                System.out.println("i'm sleeping!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        executor.execute(() -> {
            while (true) {
                System.out.println("i'm sleeping too!");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

}
