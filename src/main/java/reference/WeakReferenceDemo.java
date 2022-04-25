package reference;

import java.lang.ref.WeakReference;

import day1.Teacher;

/**
 * 弱引用Demo
 */
public class WeakReferenceDemo {
    public static void main(String[] args) throws Throwable{
        /** 创建Teacher对象的弱引用 */
        Teacher teacher = new Teacher("aaa", 15);
        WeakReference<Object> weakReference = new WeakReference<>(teacher); /** 创建弱引用对象 */

        /** 使得teacher失去引用，可被GC回收 */
        teacher = null;

        /** 执行GC前，查看弱引用并未被回收 */
        System.out.println("---------Before GC----------");
        System.out.println("weakReference=" + weakReference.get());

        /** 执行GC，所以弱引用已经被回收 */
        System.gc();
        System.out.println("---------After GC----------");
        Thread.sleep(1000); // 睡眠1秒钟，保证GC已经执行完毕
        System.out.println("weakReference=" + weakReference.get());
    }
}