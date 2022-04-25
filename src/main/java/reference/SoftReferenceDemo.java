package reference;

import java.lang.ref.SoftReference;

import day1.Teacher;

/**
 * 软引用Demo
 * -Xmx10m -XX:+PrintGCDetails
 *
 * Author yianmou
 */
public class SoftReferenceDemo {
    public static void main(String[] args) throws Throwable {
        /** 查看空余内存 */
        System.out.println("---------Free " + Runtime.getRuntime().freeMemory() / 1000000 + "M----------");

        /** 创建Teacher对象的软引用 */
        Teacher teacher = new Teacher("aaa", 15);
        SoftReference softReference = new SoftReference(teacher);
        System.out.println("softReference=" + softReference.get());

        /** 使得teacher失去引用，可被GC回收 */
        teacher = null;

        /** 执行第一次GC后，软引用并未被回收 */
        System.gc();
        System.out.println("---------First GC----------");
        System.out.println("softReference=" + softReference.get());

        /** 可以通过对数组大小数值调整，来造成内存资源紧张 */
        byte[] bytes = new byte[7*971*1024];
        System.out.println("---------Assign Big Object----------");

        /** 执行第二次GC，由于堆空间不足，所以软引用已经被回收 */
        System.gc();
        System.out.println("---------Second GC----------");
        Thread.sleep(1000); // 睡眠1秒钟，保证GC已经执行完毕
        System.out.println("softReference=" + softReference.get());
    }
}
