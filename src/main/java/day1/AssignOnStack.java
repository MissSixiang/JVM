package day1;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.time.StopWatch;
import org.apache.lucene.util.RamUsageEstimator;

import jdk.nashorn.internal.ir.debug.ObjectSizeCalculator;

/**
 * 栈上分配（默认开启）
 * 【开启栈上分配】-Xmx50m -Xms50m -XX:+PrintFlagsFinal -XX:+PrintGCDetails -XX:-UseTLAB
 * 【关闭栈上分配】-Xmx50m -Xms50m -XX:+PrintFlagsFinal -XX:+PrintGCDetails -XX:-UseTLAB -XX:-DoEscapeAnalysis
 *  注意：-XX:+PrintFlagsFinal只是为了查看参数设置情况，可以去掉。
 * @author: yianmou
 **/
public class AssignOnStack {
    public static void main(String[] args) {
        sizeOfStudent();
        StopWatch stopWatch = StopWatch.createStarted();
        // 制造将近7.5个G左右的对象
        for (int i=0; i< 100000000; i++) {
            initStudent();
        }
        stopWatch.stop();
        System.out.println("========执行一共耗时：" + stopWatch.getTime(TimeUnit.MILLISECONDS) + "毫秒");
    }

    /**
     * student所占用空间为80bytes
     */
    public static void sizeOfStudent() {
        Student student = new Student();
        student.setName("yianmou");
        System.out.println("========student大小为：" + ObjectSizeCalculator.getObjectSize(student));
        System.out.println("========student大小为：" + RamUsageEstimator.humanSizeOf(student));
    }

    public static void initStudent() {
        Student student = new Student();
        student.setName("yianmou");
    }
}

